package com.example.rpgmod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Ghast;


/**
 * RPG Mod özel canlısı: Storm Wraith (Fırtına Hayaleti).
 * Ghast gövde ailesini (vanilla model/animasyon) kullanır, kendi
 * can/hasar/hız değerleri ve dokusu ile ayrı bir canlı türüdür.
 */
public class StormWraithEntity extends Ghast {

    public StormWraithEntity(EntityType<? extends StormWraithEntity> type, Level level) {
        super(type, level);
        this.xpReward = 6;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Ghast.createAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 6.0D);
    }
}
