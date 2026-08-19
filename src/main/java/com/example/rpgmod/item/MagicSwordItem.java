package com.example.rpgmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * Normal kılıç gibi davranır ama vurduğunda düşmana kısa süreli Zayıflık efekti verir.
 * RPG mod'larda "özel silah" mantığının en basit örneği budur: hitEntity metodunu override et.
 */
public class MagicSwordItem extends SwordItem {

    public MagicSwordItem(Tier tier, int attackDamageModifier, float attackSpeedModifier, Item.Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

    @Override
    public boolean hurtEnemy(net.minecraft.world.item.ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.hurtEnemy(stack, target, attacker);
        if (!target.level().isClientSide) {
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 1)); // 5 saniye, seviye 2
            target.level().playSound(null, target.blockPosition(), net.minecraft.sounds.SoundEvents.ENCHANTMENT_TABLE_USE,
                    net.minecraft.sounds.SoundSource.PLAYERS, 0.5F, 1.4F);
        }
        return result;
    }
}
