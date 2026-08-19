package com.example.rpgmod;

import com.example.rpgmod.init.ModCreativeTabs;
import com.example.rpgmod.init.ModEntities;
import com.example.rpgmod.init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RpgMod.MOD_ID)
public class RpgMod {

    public static final String MOD_ID = "rpgmod";

    public RpgMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Kayıt (registry) sistemlerini mod event bus'a bağla
        ModItems.ITEMS.register(modEventBus);
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModCreativeTabs.CREATIVE_TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
