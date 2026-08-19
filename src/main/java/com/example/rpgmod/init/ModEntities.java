package com.example.rpgmod.init;

import com.example.rpgmod.RpgMod;
import com.example.rpgmod.entity.CrystalGolemEntity;
import com.example.rpgmod.entity.VoidWraithEntity;
import com.example.rpgmod.entity.EmberGhoulEntity;
import com.example.rpgmod.entity.FrostFiendEntity;
import com.example.rpgmod.entity.BogZombieEntity;
import com.example.rpgmod.entity.ShadowStalkerEntity;
import com.example.rpgmod.entity.WitherAcolyteEntity;
import com.example.rpgmod.entity.CursedKnightEntity;
import com.example.rpgmod.entity.BoneReaverEntity;
import com.example.rpgmod.entity.CorruptedPiglinEntity;
import com.example.rpgmod.entity.ObsidianGolemEntity;
import com.example.rpgmod.entity.VenomSpiderEntity;
import com.example.rpgmod.entity.PlagueRatEntity;
import com.example.rpgmod.entity.RotHoundEntity;
import com.example.rpgmod.entity.SwampTrollEntity;
import com.example.rpgmod.entity.CrimsonBoarEntity;
import com.example.rpgmod.entity.GiantWaspEntity;
import com.example.rpgmod.entity.NightOwlStalkerEntity;
import com.example.rpgmod.entity.DeepCrawlerEntity;
import com.example.rpgmod.entity.StormWraithEntity;
import com.example.rpgmod.entity.MoltenImpEntity;
import com.example.rpgmod.entity.ChaosSlimeEntity;
import com.example.rpgmod.entity.WoodlandSpriteEntity;
import com.example.rpgmod.entity.GuardianSpiritEntity;
import com.example.rpgmod.entity.HighlandGoatEntity;
import com.example.rpgmod.entity.GentleYakEntity;
import com.example.rpgmod.entity.SkyFawnEntity;
import com.example.rpgmod.entity.PrairieHareEntity;
import com.example.rpgmod.entity.SnowFoxCubEntity;
import com.example.rpgmod.entity.RiverOtterEntity;
import com.example.rpgmod.entity.CoralTurtleEntity;
import com.example.rpgmod.entity.AncientTortoiseEntity;
import com.example.rpgmod.entity.LuminousBeeEntity;
import com.example.rpgmod.entity.StarParrotEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RpgMod.MOD_ID);

    public static final RegistryObject<EntityType<VoidWraithEntity>> VOID_WRAITH =
            ENTITY_TYPES.register("void_wraith", () -> EntityType.Builder.of(VoidWraithEntity::new, MobCategory.MONSTER)
                    .sized(0.7F, 0.9F)
                    .clientTrackingRange(8)
                    .build("void_wraith"));

    public static final RegistryObject<EntityType<CrystalGolemEntity>> CRYSTAL_GOLEM =
            ENTITY_TYPES.register("crystal_golem", () -> EntityType.Builder.of(CrystalGolemEntity::new, MobCategory.MONSTER)
                    .sized(1.1F, 2.6F)
                    .clientTrackingRange(10)
                    .build("crystal_golem"));

    // ==================== RPG Mod ek canlılar (30+ yeni mob) ====================
    public static final RegistryObject<EntityType<EmberGhoulEntity>> EMBER_GHOUL =
            ENTITY_TYPES.register("ember_ghoul", () -> EntityType.Builder.of(EmberGhoulEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(10)
                    .build("ember_ghoul"));
    public static final RegistryObject<EntityType<FrostFiendEntity>> FROST_FIEND =
            ENTITY_TYPES.register("frost_fiend", () -> EntityType.Builder.of(FrostFiendEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(10)
                    .build("frost_fiend"));
    public static final RegistryObject<EntityType<BogZombieEntity>> BOG_ZOMBIE =
            ENTITY_TYPES.register("bog_zombie", () -> EntityType.Builder.of(BogZombieEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(10)
                    .build("bog_zombie"));
    public static final RegistryObject<EntityType<ShadowStalkerEntity>> SHADOW_STALKER =
            ENTITY_TYPES.register("shadow_stalker", () -> EntityType.Builder.of(ShadowStalkerEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(10)
                    .build("shadow_stalker"));
    public static final RegistryObject<EntityType<WitherAcolyteEntity>> WITHER_ACOLYTE =
            ENTITY_TYPES.register("wither_acolyte", () -> EntityType.Builder.of(WitherAcolyteEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(10)
                    .build("wither_acolyte"));
    public static final RegistryObject<EntityType<CursedKnightEntity>> CURSED_KNIGHT =
            ENTITY_TYPES.register("cursed_knight", () -> EntityType.Builder.of(CursedKnightEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(10)
                    .build("cursed_knight"));
    public static final RegistryObject<EntityType<BoneReaverEntity>> BONE_REAVER =
            ENTITY_TYPES.register("bone_reaver", () -> EntityType.Builder.of(BoneReaverEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(10)
                    .build("bone_reaver"));
    public static final RegistryObject<EntityType<CorruptedPiglinEntity>> CORRUPTED_PIGLIN =
            ENTITY_TYPES.register("corrupted_piglin", () -> EntityType.Builder.of(CorruptedPiglinEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(10)
                    .build("corrupted_piglin"));
    public static final RegistryObject<EntityType<ObsidianGolemEntity>> OBSIDIAN_GOLEM =
            ENTITY_TYPES.register("obsidian_golem", () -> EntityType.Builder.of(ObsidianGolemEntity::new, MobCategory.MONSTER)
                    .sized(0.9F, 2.6F)
                    .clientTrackingRange(10)
                    .build("obsidian_golem"));
    public static final RegistryObject<EntityType<VenomSpiderEntity>> VENOM_SPIDER =
            ENTITY_TYPES.register("venom_spider", () -> EntityType.Builder.of(VenomSpiderEntity::new, MobCategory.MONSTER)
                    .sized(1.4F, 0.9F)
                    .clientTrackingRange(10)
                    .build("venom_spider"));
    public static final RegistryObject<EntityType<PlagueRatEntity>> PLAGUE_RAT =
            ENTITY_TYPES.register("plague_rat", () -> EntityType.Builder.of(PlagueRatEntity::new, MobCategory.MONSTER)
                    .sized(0.9F, 0.6F)
                    .clientTrackingRange(10)
                    .build("plague_rat"));
    public static final RegistryObject<EntityType<RotHoundEntity>> ROT_HOUND =
            ENTITY_TYPES.register("rot_hound", () -> EntityType.Builder.of(RotHoundEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 0.85F)
                    .clientTrackingRange(10)
                    .build("rot_hound"));
    public static final RegistryObject<EntityType<SwampTrollEntity>> SWAMP_TROLL =
            ENTITY_TYPES.register("swamp_troll", () -> EntityType.Builder.of(SwampTrollEntity::new, MobCategory.MONSTER)
                    .sized(1.2F, 2.0F)
                    .clientTrackingRange(10)
                    .build("swamp_troll"));
    public static final RegistryObject<EntityType<CrimsonBoarEntity>> CRIMSON_BOAR =
            ENTITY_TYPES.register("crimson_boar", () -> EntityType.Builder.of(CrimsonBoarEntity::new, MobCategory.MONSTER)
                    .sized(0.95F, 1.5F)
                    .clientTrackingRange(10)
                    .build("crimson_boar"));
    public static final RegistryObject<EntityType<GiantWaspEntity>> GIANT_WASP =
            ENTITY_TYPES.register("giant_wasp", () -> EntityType.Builder.of(GiantWaspEntity::new, MobCategory.MONSTER)
                    .sized(0.7F, 0.6F)
                    .clientTrackingRange(10)
                    .build("giant_wasp"));
    public static final RegistryObject<EntityType<NightOwlStalkerEntity>> NIGHT_OWL_STALKER =
            ENTITY_TYPES.register("night_owl_stalker", () -> EntityType.Builder.of(NightOwlStalkerEntity::new, MobCategory.MONSTER)
                    .sized(0.7F, 0.7F)
                    .clientTrackingRange(10)
                    .build("night_owl_stalker"));
    public static final RegistryObject<EntityType<DeepCrawlerEntity>> DEEP_CRAWLER =
            ENTITY_TYPES.register("deep_crawler", () -> EntityType.Builder.of(DeepCrawlerEntity::new, MobCategory.MONSTER)
                    .sized(1.2F, 0.5F)
                    .clientTrackingRange(10)
                    .build("deep_crawler"));
    public static final RegistryObject<EntityType<StormWraithEntity>> STORM_WRAITH =
            ENTITY_TYPES.register("storm_wraith", () -> EntityType.Builder.of(StormWraithEntity::new, MobCategory.MONSTER)
                    .sized(4.0F, 4.0F)
                    .clientTrackingRange(10)
                    .build("storm_wraith"));
    public static final RegistryObject<EntityType<MoltenImpEntity>> MOLTEN_IMP =
            ENTITY_TYPES.register("molten_imp", () -> EntityType.Builder.of(MoltenImpEntity::new, MobCategory.MONSTER)
                    .sized(3.0F, 3.0F)
                    .clientTrackingRange(10)
                    .build("molten_imp"));
    public static final RegistryObject<EntityType<ChaosSlimeEntity>> CHAOS_SLIME =
            ENTITY_TYPES.register("chaos_slime", () -> EntityType.Builder.of(ChaosSlimeEntity::new, MobCategory.MONSTER)
                    .sized(1.02F, 1.02F)
                    .clientTrackingRange(10)
                    .build("chaos_slime"));
    public static final RegistryObject<EntityType<WoodlandSpriteEntity>> WOODLAND_SPRITE =
            ENTITY_TYPES.register("woodland_sprite", () -> EntityType.Builder.of(WoodlandSpriteEntity::new, MobCategory.CREATURE)
                    .sized(0.5F, 1.5F)
                    .clientTrackingRange(10)
                    .build("woodland_sprite"));
    public static final RegistryObject<EntityType<GuardianSpiritEntity>> GUARDIAN_SPIRIT =
            ENTITY_TYPES.register("guardian_spirit", () -> EntityType.Builder.of(GuardianSpiritEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.9F)
                    .clientTrackingRange(10)
                    .build("guardian_spirit"));
    public static final RegistryObject<EntityType<HighlandGoatEntity>> HIGHLAND_GOAT =
            ENTITY_TYPES.register("highland_goat", () -> EntityType.Builder.of(HighlandGoatEntity::new, MobCategory.CREATURE)
                    .sized(0.9F, 1.3F)
                    .clientTrackingRange(10)
                    .build("highland_goat"));
    public static final RegistryObject<EntityType<GentleYakEntity>> GENTLE_YAK =
            ENTITY_TYPES.register("gentle_yak", () -> EntityType.Builder.of(GentleYakEntity::new, MobCategory.CREATURE)
                    .sized(1.0F, 1.5F)
                    .clientTrackingRange(10)
                    .build("gentle_yak"));
    public static final RegistryObject<EntityType<SkyFawnEntity>> SKY_FAWN =
            ENTITY_TYPES.register("sky_fawn", () -> EntityType.Builder.of(SkyFawnEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 0.85F)
                    .clientTrackingRange(10)
                    .build("sky_fawn"));
    public static final RegistryObject<EntityType<PrairieHareEntity>> PRAIRIE_HARE =
            ENTITY_TYPES.register("prairie_hare", () -> EntityType.Builder.of(PrairieHareEntity::new, MobCategory.CREATURE)
                    .sized(0.4F, 0.5F)
                    .clientTrackingRange(10)
                    .build("prairie_hare"));
    public static final RegistryObject<EntityType<SnowFoxCubEntity>> SNOW_FOX_CUB =
            ENTITY_TYPES.register("snow_fox_cub", () -> EntityType.Builder.of(SnowFoxCubEntity::new, MobCategory.CREATURE)
                    .sized(0.4F, 0.5F)
                    .clientTrackingRange(10)
                    .build("snow_fox_cub"));
    public static final RegistryObject<EntityType<RiverOtterEntity>> RIVER_OTTER =
            ENTITY_TYPES.register("river_otter", () -> EntityType.Builder.of(RiverOtterEntity::new, MobCategory.CREATURE)
                    .sized(0.4F, 0.5F)
                    .clientTrackingRange(10)
                    .build("river_otter"));
    public static final RegistryObject<EntityType<CoralTurtleEntity>> CORAL_TURTLE =
            ENTITY_TYPES.register("coral_turtle", () -> EntityType.Builder.of(CoralTurtleEntity::new, MobCategory.CREATURE)
                    .sized(1.2F, 0.4F)
                    .clientTrackingRange(10)
                    .build("coral_turtle"));
    public static final RegistryObject<EntityType<AncientTortoiseEntity>> ANCIENT_TORTOISE =
            ENTITY_TYPES.register("ancient_tortoise", () -> EntityType.Builder.of(AncientTortoiseEntity::new, MobCategory.CREATURE)
                    .sized(1.6F, 0.6F)
                    .clientTrackingRange(10)
                    .build("ancient_tortoise"));
    public static final RegistryObject<EntityType<LuminousBeeEntity>> LUMINOUS_BEE =
            ENTITY_TYPES.register("luminous_bee", () -> EntityType.Builder.of(LuminousBeeEntity::new, MobCategory.CREATURE)
                    .sized(0.7F, 0.6F)
                    .clientTrackingRange(10)
                    .build("luminous_bee"));
    public static final RegistryObject<EntityType<StarParrotEntity>> STAR_PARROT =
            ENTITY_TYPES.register("star_parrot", () -> EntityType.Builder.of(StarParrotEntity::new, MobCategory.CREATURE)
                    .sized(0.5F, 0.9F)
                    .clientTrackingRange(10)
                    .build("star_parrot"));
}
