package com.example.rpgmod.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

/**
 * TAMAMEN ÖZGÜN bir mob: Monster'dan türer, zombiden hiçbir kod almaz.
 * Uçar, yerçekiminden etkilenmez, oyuncuyu havada takip eder.
 * Modeli de kendi yazdığımız VoidWraithModel (bkz. client/model paketi).
 */
public class VoidWraithEntity extends Monster {

    public VoidWraithEntity(EntityType<? extends VoidWraithEntity> type, Level level) {
        super(type, level);
        this.moveControl = new WraithMoveControl(this);
        this.setNoGravity(true);
        this.xpReward = 8;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 18.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.35D)
                .add(Attributes.FLYING_SPEED, 0.6D)
                .add(Attributes.ATTACK_DAMAGE, 5.0D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation navigation = new FlyingPathNavigation(this, level);
        navigation.setCanOpenDoors(false);
        navigation.setCanFloat(true);
        navigation.setCanPassDoors(true);
        return navigation;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(2, new WraithWanderGoal(this));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 10.0F));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public boolean isFlapping() {
        return this.getDeltaMovement().y > 0.0D || this.walkAnimation.isMoving();
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    // --- Uçuş hareket kontrolü (Vex/Phantom mantığına benzer, sıfırdan yazıldı) ---
    static class WraithMoveControl extends MoveControl {
        private final VoidWraithEntity wraith;

        public WraithMoveControl(VoidWraithEntity wraith) {
            super(wraith);
            this.wraith = wraith;
        }

        @Override
        public void tick() {
            if (this.operation == Operation.MOVE_TO) {
                Vec3 target = new Vec3(this.wantedX - wraith.getX(), this.wantedY - wraith.getY(), this.wantedZ - wraith.getZ());
                double distance = target.length();
                if (distance < 0.25D) {
                    this.operation = Operation.WAIT;
                    wraith.setDeltaMovement(wraith.getDeltaMovement().scale(0.5D));
                } else {
                    wraith.setDeltaMovement(wraith.getDeltaMovement().add(
                            target.scale(this.speedModifier * 0.05D / distance)));

                    if (this.wraith.getTarget() == null) {
                        Vec3 look = wraith.getDeltaMovement();
                        wraith.setYRot(-((float) Mth_atan2(look.x, look.z)) * (180F / (float) Math.PI));
                    } else {
                        double dx = this.wraith.getTarget().getX() - wraith.getX();
                        double dz = this.wraith.getTarget().getZ() - wraith.getZ();
                        wraith.setYRot(-((float) Mth_atan2(dx, dz)) * (180F / (float) Math.PI));
                    }
                    wraith.yBodyRot = wraith.getYRot();
                }
            }
        }

        private static double Mth_atan2(double x, double z) {
            return Math.atan2(x, z);
        }
    }

    // --- Rastgele havada süzülme davranışı ---
    static class WraithWanderGoal extends Goal {
        private final VoidWraithEntity wraith;

        public WraithWanderGoal(VoidWraithEntity wraith) {
            this.wraith = wraith;
            this.setFlags(java.util.EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return wraith.getMoveControl().hasWanted() == false && wraith.getRandom().nextInt(30) == 0;
        }

        @Override
        public boolean canContinueToUse() {
            return false;
        }

        @Override
        public void start() {
            Vec3 pos = wraith.position();
            double x = pos.x + (wraith.getRandom().nextDouble() * 2.0D - 1.0D) * 8.0D;
            double y = pos.y + (wraith.getRandom().nextDouble() * 2.0D - 1.0D) * 4.0D;
            double z = pos.z + (wraith.getRandom().nextDouble() * 2.0D - 1.0D) * 8.0D;
            wraith.getMoveControl().setWantedPosition(x, y, z, 0.6D);
        }
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(net.minecraft.world.level.ServerLevelAccessor level,
                                         net.minecraft.world.DifficultyInstance difficulty,
                                         MobSpawnType spawnType,
                                         @Nullable SpawnGroupData spawnData,
                                         @Nullable net.minecraft.nbt.CompoundTag tag) {
        return super.finalizeSpawn(level, difficulty, spawnType, spawnData, tag);
    }

    @Override
    protected net.minecraft.resources.ResourceLocation getDefaultLootTable() {
        return new net.minecraft.resources.ResourceLocation("rpgmod", "entities/void_wraith");
    }
}
