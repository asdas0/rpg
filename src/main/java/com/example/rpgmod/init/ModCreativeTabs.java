package com.example.rpgmod.init;

import com.example.rpgmod.RpgMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(ForgeRegistries.CREATIVE_MODE_TABS, RpgMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RPG_TAB = CREATIVE_TABS.register("rpg_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MAGIC_SWORD.get()))
                    .title(Component.translatable("creativetab.rpgmod.rpg_tab"))
                    .displayItems((params, output) -> {
                        output.accept(ModItems.MAGIC_SWORD.get());
                        output.accept(ModItems.MANA_CRYSTAL.get());
                        output.accept(ModItems.SHADOW_ESSENCE.get());
                        output.accept(ModItems.HEALTH_POTION_ITEM.get());
                        output.accept(ModItems.VOID_WRAITH_SPAWN_EGG.get());
                        output.accept(ModItems.CRYSTAL_GOLEM_SPAWN_EGG.get());
                        output.accept(ModItems.EMBER_GHOUL_SPAWN_EGG.get());
                        output.accept(ModItems.FROST_FIEND_SPAWN_EGG.get());
                        output.accept(ModItems.BOG_ZOMBIE_SPAWN_EGG.get());
                        output.accept(ModItems.SHADOW_STALKER_SPAWN_EGG.get());
                        output.accept(ModItems.WITHER_ACOLYTE_SPAWN_EGG.get());
                        output.accept(ModItems.CURSED_KNIGHT_SPAWN_EGG.get());
                        output.accept(ModItems.BONE_REAVER_SPAWN_EGG.get());
                        output.accept(ModItems.CORRUPTED_PIGLIN_SPAWN_EGG.get());
                        output.accept(ModItems.OBSIDIAN_GOLEM_SPAWN_EGG.get());
                        output.accept(ModItems.VENOM_SPIDER_SPAWN_EGG.get());
                        output.accept(ModItems.PLAGUE_RAT_SPAWN_EGG.get());
                        output.accept(ModItems.ROT_HOUND_SPAWN_EGG.get());
                        output.accept(ModItems.SWAMP_TROLL_SPAWN_EGG.get());
                        output.accept(ModItems.CRIMSON_BOAR_SPAWN_EGG.get());
                        output.accept(ModItems.GIANT_WASP_SPAWN_EGG.get());
                        output.accept(ModItems.NIGHT_OWL_STALKER_SPAWN_EGG.get());
                        output.accept(ModItems.DEEP_CRAWLER_SPAWN_EGG.get());
                        output.accept(ModItems.STORM_WRAITH_SPAWN_EGG.get());
                        output.accept(ModItems.MOLTEN_IMP_SPAWN_EGG.get());
                        output.accept(ModItems.CHAOS_SLIME_SPAWN_EGG.get());
                        output.accept(ModItems.WOODLAND_SPRITE_SPAWN_EGG.get());
                        output.accept(ModItems.GUARDIAN_SPIRIT_SPAWN_EGG.get());
                        output.accept(ModItems.HIGHLAND_GOAT_SPAWN_EGG.get());
                        output.accept(ModItems.GENTLE_YAK_SPAWN_EGG.get());
                        output.accept(ModItems.SKY_FAWN_SPAWN_EGG.get());
                        output.accept(ModItems.PRAIRIE_HARE_SPAWN_EGG.get());
                        output.accept(ModItems.SNOW_FOX_CUB_SPAWN_EGG.get());
                        output.accept(ModItems.RIVER_OTTER_SPAWN_EGG.get());
                        output.accept(ModItems.CORAL_TURTLE_SPAWN_EGG.get());
                        output.accept(ModItems.ANCIENT_TORTOISE_SPAWN_EGG.get());
                        output.accept(ModItems.LUMINOUS_BEE_SPAWN_EGG.get());
                        output.accept(ModItems.STAR_PARROT_SPAWN_EGG.get());
                    })
                    .build());
}
