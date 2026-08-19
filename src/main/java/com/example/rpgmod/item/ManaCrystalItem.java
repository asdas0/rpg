package com.example.rpgmod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * Basit bir crafting materyali. Tooltip (fare üzerine gelince açıklama) eklemek
 * için Item sınıfını override etmenin en kolay yolu budur.
 */
public class ManaCrystalItem extends Item {

    public ManaCrystalItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("item.rpgmod.mana_crystal.tooltip"));
        super.appendHoverText(stack, level, tooltip, flag);
    }
}
