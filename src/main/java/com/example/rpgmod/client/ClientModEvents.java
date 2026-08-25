package com.example.rpgmod.client;

import com.example.rpgmod.RpgMod;
import com.example.rpgmod.client.model.CrystalGolemModel;
import com.example.rpgmod.client.model.VoidWraithModel;
import com.example.rpgmod.client.renderer.CrystalGolemRenderer;
import com.example.rpgmod.client.renderer.VoidWraithRenderer;
import com.example.rpgmod.init.ModEntities;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Client tarafı bağlamalar:
 * 1) Mob'ların attribute'larının (can, hız, hasar) server'a kaydı (zorunlu)
 * 2) Mob'ların kendi özgün model katmanının (LayerDefinition) kaydı
 * 3) Mob'lara kendi özgün renderer'larının bağlanması
 *
 * NOT: RPG Mod'un 30'dan fazla yeni canlısı vanilla Minecraft model
 * geometrilerini (zombi, örümcek, kurt, inek, arı, tavşan, kaplumbağa,
 * ifrit, balçık, papağan) yeniden kullanır; bu yüzden yeni bir
 * LayerDefinition kaydına ihtiyaçları yoktur, sadece kendi dokuları
 * (texture) ile farklı görünürler.
 */
@Mod.EventBusSubscriber(modid = RpgMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {

    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(ModEntities.VOID_WRAITH.get(),
                com.example.rpgmod.entity.VoidWraithEntity.createAttributes().build());
        event.put(ModEntities.CRYSTAL_GOLEM.get(),
                com.example.rpgmod.entity.CrystalGolemEntity.createAttributes().build());

        // ==================== RPG Mod ek canlılar ====================
        event.put(ModEntities.EMBER_GHOUL.get(),
                com.example.rpgmod.entity.EmberGhoulEntity.createAttributes().build());
        event.put(ModEntities.FROST_FIEND.get(),
                com.example.rpgmod.entity.FrostFiendEntity.createAttributes().build());
        event.put(ModEntities.BOG_ZOMBIE.get(),
                com.example.rpgmod.entity.BogZombieEntity.createAttributes().build());
        event.put(ModEntities.SHADOW_STALKER.get(),
                com.example.rpgmod.entity.ShadowStalkerEntity.createAttributes().build());
        event.put(ModEntities.WITHER_ACOLYTE.get(),
                com.example.rpgmod.entity.WitherAcolyteEntity.createAttributes().build());
        event.put(ModEntities.CURSED_KNIGHT.get(),
                com.example.rpgmod.entity.CursedKnightEntity.createAttributes().build());
        event.put(ModEntities.BONE_REAVER.get(),
                com.example.rpgmod.entity.BoneReaverEntity.createAttributes().build());
        event.put(ModEntities.CORRUPTED_PIGLIN.get(),
                com.example.rpgmod.entity.CorruptedPiglinEntity.createAttributes().build());
        event.put(ModEntities.OBSIDIAN_GOLEM.get(),
                com.example.rpgmod.entity.ObsidianGolemEntity.createAttributes().build());
        event.put(ModEntities.VENOM_SPIDER.get(),
                com.example.rpgmod.entity.VenomSpiderEntity.createAttributes().build());
        event.put(ModEntities.PLAGUE_RAT.get(),
                com.example.rpgmod.entity.PlagueRatEntity.createAttributes().build());
        event.put(ModEntities.ROT_HOUND.get(),
                com.example.rpgmod.entity.RotHoundEntity.createAttributes().build());
        event.put(ModEntities.SWAMP_TROLL.get(),
                com.example.rpgmod.entity.SwampTrollEntity.createAttributes().build());
        event.put(ModEntities.CRIMSON_BOAR.get(),
                com.example.rpgmod.entity.CrimsonBoarEntity.createAttributes().build());
        event.put(ModEntities.GIANT_WASP.get(),
                com.example.rpgmod.entity.GiantWaspEntity.createAttributes().build());
        event.put(ModEntities.NIGHT_OWL_STALKER.get(),
                com.example.rpgmod.entity.NightOwlStalkerEntity.createAttributes().build());
        event.put(ModEntities.DEEP_CRAWLER.get(),
                com.example.rpgmod.entity.DeepCrawlerEntity.createAttributes().build());
        event.put(ModEntities.STORM_WRAITH.get(),
                com.example.rpgmod.entity.StormWraithEntity.createAttributes().build());
        event.put(ModEntities.MOLTEN_IMP.get(),
                com.example.rpgmod.entity.MoltenImpEntity.createAttributes().build());
        event.put(ModEntities.CHAOS_SLIME.get(),
                com.example.rpgmod.entity.ChaosSlimeEntity.createAttributes().build());
        event.put(ModEntities.WOODLAND_SPRITE.get(),
                com.example.rpgmod.entity.WoodlandSpriteEntity.createAttributes().build());
        event.put(ModEntities.GUARDIAN_SPIRIT.get(),
                com.example.rpgmod.entity.GuardianSpiritEntity.createAttributes().build());
        event.put(ModEntities.HIGHLAND_GOAT.get(),
                com.example.rpgmod.entity.HighlandGoatEntity.createAttributes().build());
        event.put(ModEntities.GENTLE_YAK.get(),
                com.example.rpgmod.entity.GentleYakEntity.createAttributes().build());
        event.put(ModEntities.SKY_FAWN.get(),
                com.example.rpgmod.entity.SkyFawnEntity.createAttributes().build());
        event.put(ModEntities.PRAIRIE_HARE.get(),
                com.example.rpgmod.entity.PrairieHareEntity.createAttributes().build());
        event.put(ModEntities.SNOW_FOX_CUB.get(),
                com.example.rpgmod.entity.SnowFoxCubEntity.createAttributes().build());
        event.put(ModEntities.RIVER_OTTER.get(),
                com.example.rpgmod.entity.RiverOtterEntity.createAttributes().build());
        event.put(ModEntities.CORAL_TURTLE.get(),
                com.example.rpgmod.entity.CoralTurtleEntity.createAttributes().build());
        event.put(ModEntities.ANCIENT_TORTOISE.get(),
                com.example.rpgmod.entity.AncientTortoiseEntity.createAttributes().build());
        event.put(ModEntities.LUMINOUS_BEE.get(),
                com.example.rpgmod.entity.LuminousBeeEntity.createAttributes().build());
        event.put(ModEntities.STAR_PARROT.get(),
                com.example.rpgmod.entity.StarParrotEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(VoidWraithModel.LAYER_LOCATION, VoidWraithModel::createBodyLayer);
        event.registerLayerDefinition(CrystalGolemModel.LAYER_LOCATION, CrystalGolemModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.VOID_WRAITH.get(), VoidWraithRenderer::new);
        event.registerEntityRenderer(ModEntities.CRYSTAL_GOLEM.get(), CrystalGolemRenderer::new);

        // ==================== RPG Mod ek canlılar ====================
        event.registerEntityRenderer(ModEntities.EMBER_GHOUL.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgZombieRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/ember_ghoul.png")));
        event.registerEntityRenderer(ModEntities.FROST_FIEND.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgZombieRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/frost_fiend.png")));
        event.registerEntityRenderer(ModEntities.BOG_ZOMBIE.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgZombieRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/bog_zombie.png")));
        event.registerEntityRenderer(ModEntities.SHADOW_STALKER.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgZombieRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/shadow_stalker.png")));
        event.registerEntityRenderer(ModEntities.WITHER_ACOLYTE.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgZombieRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/wither_acolyte.png")));
        event.registerEntityRenderer(ModEntities.CURSED_KNIGHT.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgZombieRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/cursed_knight.png")));
        event.registerEntityRenderer(ModEntities.BONE_REAVER.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgZombieRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/bone_reaver.png")));
        event.registerEntityRenderer(ModEntities.CORRUPTED_PIGLIN.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgZombieRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/corrupted_piglin.png")));
        event.registerEntityRenderer(ModEntities.OBSIDIAN_GOLEM.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgZombieRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/obsidian_golem.png")));
        event.registerEntityRenderer(ModEntities.VENOM_SPIDER.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgSpiderRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/venom_spider.png")));
        event.registerEntityRenderer(ModEntities.PLAGUE_RAT.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgSpiderRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/plague_rat.png")));
        event.registerEntityRenderer(ModEntities.ROT_HOUND.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgWolfRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/rot_hound.png")));
        event.registerEntityRenderer(ModEntities.SWAMP_TROLL.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgCowRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/swamp_troll.png")));
        event.registerEntityRenderer(ModEntities.CRIMSON_BOAR.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgCowRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/crimson_boar.png")));
        event.registerEntityRenderer(ModEntities.GIANT_WASP.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgBeeRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/giant_wasp.png")));
        event.registerEntityRenderer(ModEntities.NIGHT_OWL_STALKER.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgBeeRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/night_owl_stalker.png")));
        event.registerEntityRenderer(ModEntities.DEEP_CRAWLER.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgTurtleRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/deep_crawler.png")));
        event.registerEntityRenderer(ModEntities.STORM_WRAITH.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgGhastRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/storm_wraith.png")));
        event.registerEntityRenderer(ModEntities.MOLTEN_IMP.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgGhastRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/molten_imp.png")));
        event.registerEntityRenderer(ModEntities.CHAOS_SLIME.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgSlimeRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/chaos_slime.png")));
        event.registerEntityRenderer(ModEntities.WOODLAND_SPRITE.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgZombieRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/woodland_sprite.png")));
        event.registerEntityRenderer(ModEntities.GUARDIAN_SPIRIT.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgZombieRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/guardian_spirit.png")));
        event.registerEntityRenderer(ModEntities.HIGHLAND_GOAT.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgCowRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/highland_goat.png")));
        event.registerEntityRenderer(ModEntities.GENTLE_YAK.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgCowRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/gentle_yak.png")));
        event.registerEntityRenderer(ModEntities.SKY_FAWN.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgWolfRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/sky_fawn.png")));
        event.registerEntityRenderer(ModEntities.PRAIRIE_HARE.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgRabbitRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/prairie_hare.png")));
        event.registerEntityRenderer(ModEntities.SNOW_FOX_CUB.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgRabbitRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/snow_fox_cub.png")));
        event.registerEntityRenderer(ModEntities.RIVER_OTTER.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgRabbitRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/river_otter.png")));
        event.registerEntityRenderer(ModEntities.CORAL_TURTLE.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgTurtleRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/coral_turtle.png")));
        event.registerEntityRenderer(ModEntities.ANCIENT_TORTOISE.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgTurtleRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/ancient_tortoise.png")));
        event.registerEntityRenderer(ModEntities.LUMINOUS_BEE.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgBeeRenderer<>(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/luminous_bee.png")));
        event.registerEntityRenderer(ModEntities.STAR_PARROT.get(),
                ctx -> new com.example.rpgmod.client.renderer.RpgParrotRenderer(ctx,
                        new net.minecraft.resources.ResourceLocation(RpgMod.MOD_ID, "textures/entity/star_parrot.png")));
    }
}
