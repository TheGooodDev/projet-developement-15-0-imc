package com.IMC.ynov.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.protocol.game.ClientboundHorseScreenOpenPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nullable;

public class CompanionEntity extends TamableAnimal implements OwnableEntity, ContainerListener {
    private static final EntityDataAccessor<Boolean> BREAKING = SynchedEntityData.defineId(CompanionEntity.class, EntityDataSerializers.BOOLEAN);
    private boolean breaking = false;


    //------------------------------------------------------
    protected SimpleContainer inventory;
    private LazyOptional<InvWrapper> itemHandler;

    protected int getInventorySize() {return 12;}

    protected void createInventory() {
        this.inventory = new SimpleContainer(getInventorySize());
        SimpleContainer simpleContainer = this.inventory;
        if (simpleContainer != null) {
            simpleContainer.removeListener(this);
            int i = Math.min(simpleContainer.getContainerSize(), this.inventory.getContainerSize());

            for (int j = 0; j < i; j++) {
                ItemStack itemStack = simpleContainer.getItem(j);
                if (!itemStack.isEmpty()) {
                    this.inventory.setItem(j, itemStack.copy());
                }
            }
        }

        this.inventory.addListener(this);
        this.itemHandler = net.minecraftforge.common.util.LazyOptional.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this.inventory));
    }



    public void openInventory(ServerPlayer pPlayerEntity) {

        if (pPlayerEntity.containerMenu != pPlayerEntity.inventoryMenu) {
            pPlayerEntity.closeContainer();
        }

        pPlayerEntity.nextContainerCounter();
        pPlayerEntity.connection.send(new ClientboundHorseScreenOpenPacket(pPlayerEntity.containerCounter, this.inventory.getContainerSize(), this.getId()));
        pPlayerEntity.containerMenu = new CompanionInventoryMenu(pPlayerEntity.containerCounter, pPlayerEntity.getInventory(), this);
        pPlayerEntity.initMenu(pPlayerEntity.containerMenu);
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.entity.player.PlayerContainerEvent.Open(pPlayerEntity, pPlayerEntity.containerMenu));
    }

    public int getInventoryColumns() { return 4;}
    //------------------------------------------------------

    public CompanionEntity(EntityType<? extends CompanionEntity> type, Level worldIn) {
        super(type, worldIn);
        this.setTame(false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new CompanionBlockGoal(Blocks.COAL_ORE, this, 1.3));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        breaking = tag.getBoolean("Breaking");
        this.createInventory();

        ListTag listtag = tag.getList("Items", 10);

        for (int i = 0; i < listtag.size(); i++) {
            CompoundTag compoundTag = listtag.getCompound(i);
            int j = compoundTag.getByte("Slot") & 255;
            if (j >= 0 && j < this.inventory.getContainerSize()) {
                this.inventory.setItem(j, ItemStack.of(compoundTag));
            }
        }
    }

    @Override
    public boolean save(CompoundTag tag) {
        tag.putBoolean("Breaking", breaking);

        ListTag listtag = new ListTag();
        for (int i = 0; i < this.inventory.getContainerSize(); i++) {
            ItemStack itemStack = this.inventory.getItem(i);
            if(!itemStack.isEmpty()) {
                CompoundTag compoundTag = new CompoundTag();
                compoundTag.putByte("Slot", (byte)i);
                itemStack.save(compoundTag);
                listtag.add(compoundTag);
            }
        }

        tag.put("Items", listtag);
        return super.save(tag);
    }


    //    @Override
//    public Packet<?> getAddEntityPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.MAX_HEALTH, 1.0)
                .add(Attributes.FOLLOW_RANGE, 40.0)
                .add(Attributes.MOVEMENT_SPEED, 0.3);
    }

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        Item item = itemstack.getItem();
        if (this.level.isClientSide) {
            boolean flag = this.isOwnedBy(pPlayer) || this.isTame() || itemstack.is(Items.DIAMOND) && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    if (!pPlayer.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }
                    this.heal((float)item.getFoodProperties().getNutrition());
                    this.gameEvent(GameEvent.MOB_INTERACT, this.eyeBlockPosition());
                    return InteractionResult.SUCCESS;
                } else  if (pPlayer.isSecondaryUseActive()) {
                    openInventory((ServerPlayer) pPlayer);
                    return InteractionResult.sidedSuccess(this.level.isClientSide);
                }
            } else if (itemstack.is(Items.DIAMOND) ) {
                if (!pPlayer.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, pPlayer)) {
                    this.tame(pPlayer);
                    this.navigation.stop();
                    this.setTarget((LivingEntity)null);
                    this.setOrderedToSit(true);
                    this.level.broadcastEntityEvent(this, (byte)7);
                } else {
                    this.level.broadcastEntityEvent(this, (byte)6);
                }

                return InteractionResult.SUCCESS;
            }

            return super.mobInteract(pPlayer, pHand);
        }
    }

    public void setBreaking(boolean value) {
        this.entityData.set(BREAKING, value);
    }

    @Override
    public void containerChanged(Container pInvBasic) {

    }
}
