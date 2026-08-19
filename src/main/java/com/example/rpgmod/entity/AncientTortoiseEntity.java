package com.example.rpgmod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.animal.Turtle;


/**
 * RPG Mod özel canlısı: Ancient Tortoise (Kadim Kaplumbağa).
 * Turtle gövde ailesini (vanilla model/animasyon) kullanır, kendi
 * can/hasar/hız değerleri ve dokusu ile ayrı bir canlı türüdür.
 */
public class AncientTortoiseEntity extends Turtle {

    public AncientTortoiseEntity(EntityType<? extends AncientTortoiseEntity> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Turtle.createAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.10D)
                .add(Attributes.FOLLOW_RANGE, 28.0D);
    }
}
