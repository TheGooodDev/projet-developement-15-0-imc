package com.IMC.ynov.setup;


import com.IMC.ynov.Mod;
import com.IMC.ynov.entities.CompanionEntity;
import com.IMC.ynov.ModFoods;
import com.IMC.ynov.world.features.tree.PearTreeFeature;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.antlr.runtime.tree.Tree;

import static com.IMC.ynov.CompanionMod.MODID;

public class Registration {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);
    private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Mod.MOD_ID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        ENTITIES.register(bus);
        FEATURES.register(bus);
    }



    public static final RegistryObject<Feature<TreeConfiguration>> PEAR_TREE =
            FEATURES.register("pear_tree", ()-> new PearTreeFeature(NoneFeatureConfiguration.CODEC));



    // Some common properties for our blocks and items
    public static final BlockBehaviour.Properties ORE_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE).strength(2f);
    public static final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD);
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);

    public static final RegistryObject<Block> MYSTERIOUS_ORE_OVERWORLD = BLOCKS.register("mysterious_ore_overworld", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> MYSTERIOUS_ORE_OVERWORLD_ITEM = fromBlock(MYSTERIOUS_ORE_OVERWORLD);
    public static final RegistryObject<Block> MYSTERIOUS_ORE_NETHER = BLOCKS.register("mysterious_ore_nether", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> MYSTERIOUS_ORE_NETHER_ITEM = fromBlock(MYSTERIOUS_ORE_NETHER);
    public static final RegistryObject<Block> MYSTERIOUS_ORE_END = BLOCKS.register("mysterious_ore_end", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> MYSTERIOUS_ORE_END_ITEM = fromBlock(MYSTERIOUS_ORE_END);
    public static final RegistryObject<Block> MYSTERIOUS_ORE_DEEPSLATE = BLOCKS.register("mysterious_ore_deepslate", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> MYSTERIOUS_ORE_DEEPSLATE_ITEM = fromBlock(MYSTERIOUS_ORE_DEEPSLATE);
    public static final RegistryObject<Block> PEAR_LOG = BLOCKS.register("pear_log", () -> new Block(WOOD));
    public static final RegistryObject<Block> PEAR_WOOD = BLOCKS.register("pear_wood", () -> new Block(WOOD));
    public static final RegistryObject<Block> PEAR_PLANKS = BLOCKS.register("pear_planks", () -> new Block(WOOD));
    public static final RegistryObject<Block> PEAR_DOOR = BLOCKS.register("pear_door", () -> new Block(WOOD));
    public static final RegistryObject<Block> PEAR_TRAPDOOR = BLOCKS.register("pear_trapdoor", () -> new Block(WOOD));
    public static final RegistryObject<Block> PEAR_PRESSURE_PLATE = BLOCKS.register("pear_pressure_plate", () -> new Block(WOOD));
    public static final RegistryObject<Block> PEAR_SAPLING = BLOCKS.register("pear_sapling", () -> new Block(WOOD));
    public static final RegistryObject<Block> PEAR_SLAB = BLOCKS.register("pear_slab", () -> new Block(WOOD));
    public static final RegistryObject<Block> PEAR_STAIRS = BLOCKS.register("pear_stairs", () -> new Block(WOOD));
    public static final RegistryObject<Block> PEAR_BUTTON = BLOCKS.register("pear_button", () -> new Block(WOOD));
    public static final RegistryObject<Block> PEAR_FENCE = BLOCKS.register("pear_fence", () -> new Block(WOOD));
    public static final RegistryObject<Block> PEAR_FENCE_GATE = BLOCKS.register("pear_fence_gate", () -> new Block(WOOD));
    public static final RegistryObject<Block> PEAR_LEAVES_BLOCK = BLOCKS.register("pear_leaves_block", () -> new Block(WOOD));
    public static final RegistryObject<Block> BANANA_LOG = BLOCKS.register("banana_log", () -> new Block(WOOD));
    public static final RegistryObject<Block> BANANA_WOOD = BLOCKS.register("banana_wood", () -> new Block(WOOD));
    public static final RegistryObject<Block> BANANA_PLANKS = BLOCKS.register("banana_planks", () -> new Block(WOOD));
    public static final RegistryObject<Block> BANANA_DOOR = BLOCKS.register("banana_door", () -> new Block(WOOD));
    public static final RegistryObject<Block> BANANA_TRAPDOOR = BLOCKS.register("banana_trapdoor", () -> new Block(WOOD));
    public static final RegistryObject<Block> BANANA_PRESSURE_PLATE = BLOCKS.register("banana_pressure_plate", () -> new Block(WOOD));
    public static final RegistryObject<Block> BANANA_SAPLING = BLOCKS.register("banana_sapling", () -> new Block(WOOD));
    public static final RegistryObject<Block> BANANA_SLAB = BLOCKS.register("banana_slab", () -> new Block(WOOD));
    public static final RegistryObject<Block> BANANA_STAIRS = BLOCKS.register("banana_stairs", () -> new Block(WOOD));
    public static final RegistryObject<Block> BANANA_BUTTON = BLOCKS.register("banana_button", () -> new Block(WOOD));
    public static final RegistryObject<Block> BANANA_FENCE = BLOCKS.register("banana_fence", () -> new Block(WOOD));
    public static final RegistryObject<Block> BANANA_FENCE_GATE = BLOCKS.register("banana_fence_gate", () -> new Block(WOOD));
    public static final RegistryObject<Block> BANANA_LEAVES_BLOCK = BLOCKS.register("banana_leaves_block", () -> new Block(WOOD));
    public static final RegistryObject<Item> PEAR_FENCE_ITEM = fromBlock(PEAR_FENCE);
    public static final RegistryObject<Item> PEAR_FENCE_GATE_ITEM = fromBlock(PEAR_FENCE_GATE);
    public static final RegistryObject<Item> BANANA_FENCE_ITEM = fromBlock(BANANA_FENCE);
    public static final RegistryObject<Item> BANANA_FENCE_GATE_ITEM = fromBlock(BANANA_FENCE_GATE);



    public static final RegistryObject<Item> PEAR = ITEMS.register("pear",
            () -> new Item(new Item.Properties().food(ModFoods.PEAR)));

    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food(ModFoods.ORANGE)));

    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(ModFoods.BANANA)));

    public static final RegistryObject<Item> FRUIT_SALAD = ITEMS.register("fruit_salad",
            () -> new Item(new Item.Properties().food(ModFoods.FRUIT_SALAD)));



    public static final RegistryObject<EntityType<CompanionEntity>> THIEF = ENTITIES.register("thief", () -> EntityType.Builder.of(CompanionEntity::new, MobCategory.CREATURE)
            .sized(0.6f, 1.95f)
            .clientTrackingRange(8)
            .setShouldReceiveVelocityUpdates(false)
            .build("thief"));
    public static final RegistryObject<Item> THIEF_EGG = ITEMS.register("thief", () -> new ForgeSpawnEggItem(THIEF, 0xff0000, 0x00ff00, ITEM_PROPERTIES));

    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }
}
