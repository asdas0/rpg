package com.example.rpgmod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.animal.Parrot;


/**
 * RPG Mod özel canlısı: Star Parrot (Yıldız Papağanı).
 * Parrot gövde ailesini (vanilla model/animasyon) kullanır, kendi
 * can/hasar/hız değerleri ve dokusu ile ayrı bir canlı türüdür.
 */
public class StarParrotEntity extends Parrot {

    public StarParrotEntity(EntityType<? extends StarParrotEntity> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Parrot.createAttributes()
                .add(Attributes.MAX_HEALTH, 6.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.30D);
    }
}
