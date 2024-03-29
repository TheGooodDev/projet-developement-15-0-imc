package com.IMC.ynov.setup;



import com.IMC.ynov.container.CompanionMenu;
import com.IMC.ynov.entities.CompanionEntity;
import com.IMC.ynov.ModFoods;
import com.IMC.ynov.world.features.tree.BananaTreeGrower;
import com.IMC.ynov.world.features.tree.OrangeTreeGrower;
import com.IMC.ynov.world.features.tree.PearTreeFeature;
import com.IMC.ynov.world.features.tree.PearTreeGrower;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import static com.IMC.ynov.CompanionMod.MODID;

public class Registration {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);
    private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MODID);
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MODID);
    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        ENTITIES.register(bus);
        FEATURES.register(bus);
        CONTAINERS.register(bus);
    }



    public static final RegistryObject<Feature<TreeConfiguration>> PEAR_TREE =
            FEATURES.register("pear_tree", ()-> new PearTreeFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<TreeConfiguration>> BANANA_TREE =
            FEATURES.register("banana_tree", ()-> new PearTreeFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<TreeConfiguration>> ORANGE_TREE =
            FEATURES.register("orange_tree", ()-> new PearTreeFeature(NoneFeatureConfiguration.CODEC));



    // Some common properties for our blocks and items
    public static final BlockBehaviour.Properties ORE_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE).strength(2f);
    public static final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD);
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);

    public static final Item.Properties FOOD_PROPERTIES = new Item.Properties().food(ModFoods.FRUIT_SALAD).tab(ModSetup.ITEM_GROUP);
    public static final BlockBehaviour.Properties LEAVE = BlockBehaviour.Properties.of(Material.LEAVES).strength(1f);


    public static final RegistryObject<RotatedPillarBlock> PEAR_LOG = BLOCKS.register("pear_log", () -> new RotatedPillarBlock(WOOD));
    public static final RegistryObject<Block> PEAR_WOOD = BLOCKS.register("pear_wood", () -> new Block(WOOD));
    public static final RegistryObject<Block> PEAR_PLANKS = BLOCKS.register("pear_planks", () -> new Block(WOOD));
    public static final RegistryObject<DoorBlock> PEAR_DOOR = BLOCKS.register("pear_door", () -> new DoorBlock(WOOD));
    public static final RegistryObject<TrapDoorBlock> PEAR_TRAPDOOR = BLOCKS.register("pear_trapdoor", () -> new TrapDoorBlock(WOOD));
    public static final RegistryObject<PressurePlateBlock> PEAR_PRESSURE_PLATE = BLOCKS.register("pear_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,WOOD));
    public static final RegistryObject<SaplingBlock> PEAR_SAPLING = BLOCKS.register("pear_sapling", () -> new SaplingBlock(new PearTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<SlabBlock> PEAR_SLAB = BLOCKS.register("pear_slab", () -> new SlabBlock(WOOD));
    public static final RegistryObject<StairBlock> PEAR_STAIRS = BLOCKS.register("pear_stairs", () -> new StairBlock(Blocks.BIRCH_STAIRS.defaultBlockState(),WOOD));
    public static final RegistryObject<ButtonBlock> PEAR_BUTTON = BLOCKS.register("pear_button", () -> new WoodButtonBlock(WOOD));
    public static final RegistryObject<FenceBlock> PEAR_FENCE = BLOCKS.register("pear_fence", () -> new FenceBlock(WOOD));
    public static final RegistryObject<FenceGateBlock> PEAR_FENCE_GATE = BLOCKS.register("pear_fence_gate", () -> new FenceGateBlock(WOOD));
    public static final RegistryObject<LeavesBlock> PEAR_LEAVES_BLOCK = BLOCKS.register("pear_leaves_block", () -> new LeavesBlock(LEAVE));

    public static final RegistryObject<RotatedPillarBlock> ORANGE_LOG = BLOCKS.register("orange_log", () -> new RotatedPillarBlock(WOOD));
    public static final RegistryObject<Block> ORANGE_WOOD = BLOCKS.register("orange_wood", () -> new Block(WOOD));
    public static final RegistryObject<Block> ORANGE_PLANKS = BLOCKS.register("orange_planks", () -> new Block(WOOD));
    public static final RegistryObject<DoorBlock> ORANGE_DOOR = BLOCKS.register("orange_door", () -> new DoorBlock(WOOD));
    public static final RegistryObject<TrapDoorBlock> ORANGE_TRAPDOOR = BLOCKS.register("orange_trapdoor", () -> new TrapDoorBlock(WOOD));
    public static final RegistryObject<PressurePlateBlock> ORANGE_PRESSURE_PLATE = BLOCKS.register("orange_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,WOOD));
    public static final RegistryObject<SaplingBlock> ORANGE_SAPLING = BLOCKS.register("orange_sapling", () -> new SaplingBlock(new OrangeTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<SlabBlock> ORANGE_SLAB = BLOCKS.register("orange_slab", () -> new SlabBlock(WOOD));
    public static final RegistryObject<StairBlock> ORANGE_STAIRS = BLOCKS.register("orange_stairs", () -> new StairBlock(Blocks.BIRCH_STAIRS.defaultBlockState(),WOOD));
    public static final RegistryObject<ButtonBlock> ORANGE_BUTTON = BLOCKS.register("orange_button", () -> new WoodButtonBlock(WOOD));
        public static final RegistryObject<FenceBlock> ORANGE_FENCE = BLOCKS.register("orange_fence", () -> new FenceBlock(WOOD));
        public static final RegistryObject<FenceGateBlock> ORANGE_FENCE_GATE = BLOCKS.register("orange_fence_gate", () -> new FenceGateBlock(WOOD));
        public static final RegistryObject<LeavesBlock> ORANGE_LEAVES_BLOCK = BLOCKS.register("orange_leaves_block", () -> new LeavesBlock(LEAVE));


    public static final RegistryObject<RotatedPillarBlock> BANANA_LOG = BLOCKS.register("banana_log", () -> new RotatedPillarBlock(WOOD));
    public static final RegistryObject<Block> BANANA_WOOD = BLOCKS.register("banana_wood", () -> new Block(WOOD));
    public static final RegistryObject<Block> BANANA_PLANKS = BLOCKS.register("banana_planks", () -> new Block(WOOD));
    public static final RegistryObject<DoorBlock> BANANA_DOOR = BLOCKS.register("banana_door", () -> new DoorBlock(WOOD));
    public static final RegistryObject<TrapDoorBlock> BANANA_TRAPDOOR = BLOCKS.register("banana_trapdoor", () -> new TrapDoorBlock(WOOD));
    public static final RegistryObject<PressurePlateBlock> BANANA_PRESSURE_PLATE = BLOCKS.register("banana_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,WOOD));
    public static final RegistryObject<SaplingBlock> BANANA_SAPLING = BLOCKS.register("banana_sapling", () -> new SaplingBlock(new BananaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<SlabBlock> BANANA_SLAB = BLOCKS.register("banana_slab", () -> new SlabBlock(WOOD));
    public static final RegistryObject<StairBlock> BANANA_STAIRS = BLOCKS.register("banana_stairs", () -> new StairBlock(Blocks.BIRCH_STAIRS.defaultBlockState(),WOOD));
    public static final RegistryObject<ButtonBlock> BANANA_BUTTON = BLOCKS.register("banana_button", () -> new WoodButtonBlock(WOOD));
        public static final RegistryObject<FenceBlock> BANANA_FENCE = BLOCKS.register("banana_fence", () -> new FenceBlock(WOOD));
        public static final RegistryObject<FenceGateBlock> BANANA_FENCE_GATE = BLOCKS.register("banana_fence_gate", () -> new FenceGateBlock(WOOD));
        public static final RegistryObject<Block> BANANA_LEAVES_BLOCK = BLOCKS.register("banana_leaves_block", () -> new LeavesBlock(LEAVE));

        public static final RegistryObject<Item> PEAR_FENCE_ITEM = fromBlock(PEAR_FENCE);
        public static final RegistryObject<Item> PEAR_FENCE_GATE_ITEM = fromBlock(PEAR_FENCE_GATE);
        public static final RegistryObject<Item> PEAR_BUTTON_ITEM = fromBlock(PEAR_BUTTON);
        public static final RegistryObject<Item> PEAR_SLAB_ITEM = fromBlock(PEAR_SLAB);
        public static final RegistryObject<Item> PEAR_STAIRS_ITEM = fromBlock(PEAR_STAIRS);
        public static final RegistryObject<Item> PEAR_DOOR_ITEM = fromBlock(PEAR_DOOR);
        public static final RegistryObject<Item> PEAR_TRAPDOOR_ITEM = fromBlock(PEAR_TRAPDOOR);
        public static final RegistryObject<Item> PEAR_PLANKS_ITEM = fromBlock(PEAR_PLANKS);
        public static final RegistryObject<Item> PEAR_LOG_ITEM = fromBlock(PEAR_LOG);
        public static final RegistryObject<Item> PEAR_WOOD_ITEM = fromBlock(PEAR_WOOD);
        public static final RegistryObject<Item> PEAR_PRESSURE_PLATE_ITEM = fromBlock(PEAR_PRESSURE_PLATE);
        public static final RegistryObject<Item> PEAR_LEAVES_BLOCK_ITEM = fromBlock(PEAR_LEAVES_BLOCK);
        public static final RegistryObject<Item> PEAR_SAPLING_ITEM = fromBlock(PEAR_SAPLING);

        public static final RegistryObject<Item> BANANA_FENCE_ITEM = fromBlock(BANANA_FENCE);
        public static final RegistryObject<Item> BANANA_FENCE_GATE_ITEM = fromBlock(BANANA_FENCE_GATE);
        public static final RegistryObject<Item> BANANA_BUTTON_ITEM = fromBlock(BANANA_BUTTON);
        public static final RegistryObject<Item> BANANA_SLAB_ITEM = fromBlock(BANANA_SLAB);
        public static final RegistryObject<Item> BANANA_STAIRS_ITEM = fromBlock(BANANA_STAIRS);
        public static final RegistryObject<Item> BANANA_DOOR_ITEM = fromBlock(BANANA_DOOR);
        public static final RegistryObject<Item> BANANA_TRAPDOOR_ITEM = fromBlock(BANANA_TRAPDOOR);
        public static final RegistryObject<Item> BANANA_PLANKS_ITEM = fromBlock(BANANA_PLANKS);
        public static final RegistryObject<Item> BANANA_LOG_ITEM = fromBlock(BANANA_LOG);
        public static final RegistryObject<Item> BANANA_WOOD_ITEM = fromBlock(BANANA_WOOD);
        public static final RegistryObject<Item> BANANA_PRESSURE_PLATE_ITEM = fromBlock(BANANA_PRESSURE_PLATE);
        public static final RegistryObject<Item> BANANA_LEAVES_BLOCK_ITEM = fromBlock(BANANA_LEAVES_BLOCK);
        public static final RegistryObject<Item> BANANA_SAPLING_ITEM = fromBlock(BANANA_SAPLING);

        public static final RegistryObject<Item> ORANGE_FENCE_ITEM = fromBlock(ORANGE_FENCE);
        public static final RegistryObject<Item> ORANGE_FENCE_GATE_ITEM = fromBlock(ORANGE_FENCE_GATE);
        public static final RegistryObject<Item> ORANGE_BUTTON_ITEM = fromBlock(ORANGE_BUTTON);
        public static final RegistryObject<Item> ORANGE_SLAB_ITEM = fromBlock(ORANGE_SLAB);
        public static final RegistryObject<Item> ORANGE_STAIRS_ITEM = fromBlock(ORANGE_STAIRS);
        public static final RegistryObject<Item> ORANGE_DOOR_ITEM = fromBlock(ORANGE_DOOR);
        public static final RegistryObject<Item> ORANGE_TRAPDOOR_ITEM = fromBlock(ORANGE_TRAPDOOR);
        public static final RegistryObject<Item> ORANGE_PLANKS_ITEM = fromBlock(ORANGE_PLANKS);
        public static final RegistryObject<Item> ORANGE_LOG_ITEM = fromBlock(ORANGE_LOG);
        public static final RegistryObject<Item> ORANGE_WOOD_ITEM = fromBlock(ORANGE_WOOD);
        public static final RegistryObject<Item> ORANGE_PRESSURE_PLATE_ITEM = fromBlock(ORANGE_PRESSURE_PLATE);
        public static final RegistryObject<Item> ORANGE_LEAVES_BLOCK_ITEM = fromBlock(ORANGE_LEAVES_BLOCK);
        public static final RegistryObject<Item> ORANGE_SAPLING_ITEM = fromBlock(ORANGE_SAPLING);


        public static final RegistryObject<Item> PEAR = ITEMS.register("pear",
                () -> new Item(FOOD_PROPERTIES));

        public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
                () -> new Item(FOOD_PROPERTIES));

        public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
                () -> new Item(FOOD_PROPERTIES));

        public static final RegistryObject<Item> FRUIT_SALAD = ITEMS.register("fruit_salad",
                () -> new Item(FOOD_PROPERTIES));


        public static final RegistryObject<EntityType<CompanionEntity>> COMPANION = ENTITIES.register("companion", () -> EntityType.Builder.of(CompanionEntity::new, MobCategory.CREATURE)
                .sized(0.6f, 1.95f)
                .clientTrackingRange(8)
                .setShouldReceiveVelocityUpdates(false)
                .build("companion"));
        public static final RegistryObject<Item> COMPANION_EGG = ITEMS.register("companion", () -> new ForgeSpawnEggItem(COMPANION, 0xff0000, 0x00ff00, ITEM_PROPERTIES));

        public static final RegistryObject<MenuType<CompanionMenu>> COMPANION_INVENTORY = CONTAINERS.register("companion_inventory",
            () -> IForgeMenuType.create((windowId, inv, data) -> {
                Entity entity = Minecraft.getInstance().level.getEntity(data.readInt());

                if (entity instanceof CompanionEntity companionEntity) {
                    return new CompanionMenu(windowId, inv, companionEntity);
                } else {
                    throw new IllegalStateException("Tried to open a miner minion inventory with a non miner minion entity!");
                }

            }));


        public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
            return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
        }

    }