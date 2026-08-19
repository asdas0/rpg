package com.example.rpgmod.client.renderer;

import com.example.rpgmod.RpgMod;
import com.example.rpgmod.client.model.CrystalGolemModel;
import com.example.rpgmod.entity.CrystalGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CrystalGolemRenderer extends MobRenderer<CrystalGolemEntity, CrystalGolemModel> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(RpgMod.MOD_ID, "textures/entity/crystal_golem.png");

    public CrystalGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new CrystalGolemModel(context.bakeLayer(CrystalGolemModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalGolemEntity entity) {
        return TEXTURE;
    }
}
