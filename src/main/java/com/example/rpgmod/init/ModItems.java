package com.example.rpgmod.init;

import com.example.rpgmod.RpgMod;
import com.example.rpgmod.item.MagicSwordItem;
import com.example.rpgmod.item.ManaCrystalItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RpgMod.MOD_ID);

    // --- Silahlar ---
    public static final RegistryObject<Item> MAGIC_SWORD = ITEMS.register("magic_sword",
            () -> new MagicSwordItem(Tiers.DIAMOND, 3, -2.4F,
                    new Item.Properties().rarity(Rarity.RARE)));

    // --- Materyaller ---
    public static final RegistryObject<Item> MANA_CRYSTAL = ITEMS.register("mana_crystal",
            () -> new ManaCrystalItem(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> SHADOW_ESSENCE = ITEMS.register("shadow_essence",
            () -> new Item(new Item.Properties()));

    // --- İyileştirme eşyası (basit örnek, sağ tıkla can doldurur) ---
    public static final RegistryObject<Item> HEALTH_POTION_ITEM = ITEMS.register("greater_healing_potion",
            () -> new net.minecraft.world.item.Item(new Item.Properties().stacksTo(16)) {
                @Override
                public net.minecraft.world.InteractionResultHolder<net.minecraft.world.item.ItemStack> use(
                        net.minecraft.world.level.Level level, net.minecraft.world.entity.player.Player player,
                        net.minecraft.world.InteractionHand hand) {
                    net.minecraft.world.item.ItemStack stack = player.getItemInHand(hand);
                    if (!level.isClientSide) {
                        player.heal(10.0F);
                        if (!player.getAbilities().instabuild) {
                            stack.shrink(1);
                        }
                        level.playSound(null, player.blockPosition(),
                                net.minecraft.sounds.SoundEvents.PLAYER_LEVELUP,
                                net.minecraft.sounds.SoundSource.PLAYERS, 0.6F, 1.2F);
                    }
                    return net.minecraft.world.InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
                }
            });

    // --- Mob doğurma yumurtaları ---
    public static final RegistryObject<Item> VOID_WRAITH_SPAWN_EGG = ITEMS.register("void_wraith_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.VOID_WRAITH, 0x0d0d1a, 0x6a3fd6, new Item.Properties()));

    public static final RegistryObject<Item> CRYSTAL_GOLEM_SPAWN_EGG = ITEMS.register("crystal_golem_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.CRYSTAL_GOLEM, 0x3d3d4a, 0x7de3ff, new Item.Properties()));

    // ==================== RPG Mod ek doğurma yumurtaları (30+ yeni mob) ====================
    public static final RegistryObject<Item> EMBER_GHOUL_SPAWN_EGG = ITEMS.register("ember_ghoul_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.EMBER_GHOUL, 0xB33000, 0x2A0800, new Item.Properties()));
    public static final RegistryObject<Item> FROST_FIEND_SPAWN_EGG = ITEMS.register("frost_fiend_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.FROST_FIEND, 0x1E5A8C, 0xCFF3FF, new Item.Properties()));
    public static final RegistryObject<Item> BOG_ZOMBIE_SPAWN_EGG = ITEMS.register("bog_zombie_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.BOG_ZOMBIE, 0x3A4A22, 0x7A8C3F, new Item.Properties()));
    public static final RegistryObject<Item> SHADOW_STALKER_SPAWN_EGG = ITEMS.register("shadow_stalker_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.SHADOW_STALKER, 0x14101E, 0x7A4FD6, new Item.Properties()));
    public static final RegistryObject<Item> WITHER_ACOLYTE_SPAWN_EGG = ITEMS.register("wither_acolyte_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.WITHER_ACOLYTE, 0x1A1A1A, 0x4A4A4A, new Item.Properties()));
    public static final RegistryObject<Item> CURSED_KNIGHT_SPAWN_EGG = ITEMS.register("cursed_knight_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.CURSED_KNIGHT, 0x3A3A46, 0x8C2F2F, new Item.Properties()));
    public static final RegistryObject<Item> BONE_REAVER_SPAWN_EGG = ITEMS.register("bone_reaver_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.BONE_REAVER, 0xD8D0B8, 0x4A6B3A, new Item.Properties()));
    public static final RegistryObject<Item> CORRUPTED_PIGLIN_SPAWN_EGG = ITEMS.register("corrupted_piglin_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.CORRUPTED_PIGLIN, 0x4A5C2E, 0xC7A26B, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_GOLEM_SPAWN_EGG = ITEMS.register("obsidian_golem_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.OBSIDIAN_GOLEM, 0x0D0D14, 0x6A3FD6, new Item.Properties()));
    public static final RegistryObject<Item> VENOM_SPIDER_SPAWN_EGG = ITEMS.register("venom_spider_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.VENOM_SPIDER, 0x2E0D3A, 0x7ADB4E, new Item.Properties()));
    public static final RegistryObject<Item> PLAGUE_RAT_SPAWN_EGG = ITEMS.register("plague_rat_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.PLAGUE_RAT, 0x5C5324, 0xA9A15A, new Item.Properties()));
    public static final RegistryObject<Item> ROT_HOUND_SPAWN_EGG = ITEMS.register("rot_hound_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.ROT_HOUND, 0x3C3A2E, 0x6E7A3C, new Item.Properties()));
    public static final RegistryObject<Item> SWAMP_TROLL_SPAWN_EGG = ITEMS.register("swamp_troll_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.SWAMP_TROLL, 0x2E3B1E, 0x8FA24A, new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_BOAR_SPAWN_EGG = ITEMS.register("crimson_boar_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.CRIMSON_BOAR, 0x6E0F0F, 0x2A0505, new Item.Properties()));
    public static final RegistryObject<Item> GIANT_WASP_SPAWN_EGG = ITEMS.register("giant_wasp_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.GIANT_WASP, 0x2A2308, 0xE8C93A, new Item.Properties()));
    public static final RegistryObject<Item> NIGHT_OWL_STALKER_SPAWN_EGG = ITEMS.register("night_owl_stalker_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.NIGHT_OWL_STALKER, 0x1A1024, 0x6E4FA0, new Item.Properties()));
    public static final RegistryObject<Item> DEEP_CRAWLER_SPAWN_EGG = ITEMS.register("deep_crawler_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.DEEP_CRAWLER, 0x0E3A3A, 0x1A1A1A, new Item.Properties()));
    public static final RegistryObject<Item> STORM_WRAITH_SPAWN_EGG = ITEMS.register("storm_wraith_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.STORM_WRAITH, 0x233A6B, 0xB8E4FF, new Item.Properties()));
    public static final RegistryObject<Item> MOLTEN_IMP_SPAWN_EGG = ITEMS.register("molten_imp_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.MOLTEN_IMP, 0x6B2308, 0xFFAA33, new Item.Properties()));
    public static final RegistryObject<Item> CHAOS_SLIME_SPAWN_EGG = ITEMS.register("chaos_slime_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.CHAOS_SLIME, 0x6B1F8C, 0xE87ADB, new Item.Properties()));
    public static final RegistryObject<Item> WOODLAND_SPRITE_SPAWN_EGG = ITEMS.register("woodland_sprite_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.WOODLAND_SPRITE, 0x2E5C2E, 0x9BE86E, new Item.Properties()));
    public static final RegistryObject<Item> GUARDIAN_SPIRIT_SPAWN_EGG = ITEMS.register("guardian_spirit_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.GUARDIAN_SPIRIT, 0x123B4A, 0x7DE3FF, new Item.Properties()));
    public static final RegistryObject<Item> HIGHLAND_GOAT_SPAWN_EGG = ITEMS.register("highland_goat_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.HIGHLAND_GOAT, 0x8C8C8C, 0xFFFFFF, new Item.Properties()));
    public static final RegistryObject<Item> GENTLE_YAK_SPAWN_EGG = ITEMS.register("gentle_yak_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.GENTLE_YAK, 0x5C4326, 0x2A1D10, new Item.Properties()));
    public static final RegistryObject<Item> SKY_FAWN_SPAWN_EGG = ITEMS.register("sky_fawn_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.SKY_FAWN, 0xAEDFFF, 0xFFFFFF, new Item.Properties()));
    public static final RegistryObject<Item> PRAIRIE_HARE_SPAWN_EGG = ITEMS.register("prairie_hare_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.PRAIRIE_HARE, 0xC7A971, 0xFFFFFF, new Item.Properties()));
    public static final RegistryObject<Item> SNOW_FOX_CUB_SPAWN_EGG = ITEMS.register("snow_fox_cub_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.SNOW_FOX_CUB, 0xF0F8FF, 0x9BC7E8, new Item.Properties()));
    public static final RegistryObject<Item> RIVER_OTTER_SPAWN_EGG = ITEMS.register("river_otter_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.RIVER_OTTER, 0x5A3D22, 0xC7A971, new Item.Properties()));
    public static final RegistryObject<Item> CORAL_TURTLE_SPAWN_EGG = ITEMS.register("coral_turtle_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.CORAL_TURTLE, 0xFF7F8C, 0x2AA198, new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_TORTOISE_SPAWN_EGG = ITEMS.register("ancient_tortoise_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.ANCIENT_TORTOISE, 0x3A4A2E, 0x8C9C6B, new Item.Properties()));
    public static final RegistryObject<Item> LUMINOUS_BEE_SPAWN_EGG = ITEMS.register("luminous_bee_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.LUMINOUS_BEE, 0xFFF4C2, 0xFFFFFF, new Item.Properties()));
    public static final RegistryObject<Item> STAR_PARROT_SPAWN_EGG = ITEMS.register("star_parrot_spawn_egg",
            () -> new net.minecraftforge.common.ForgeSpawnEggItem(
                    ModEntities.STAR_PARROT, 0x8C3FD6, 0xFFD24A, new Item.Properties()));
}
