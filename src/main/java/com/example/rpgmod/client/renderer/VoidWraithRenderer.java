package com.example.rpgmod.client.renderer;

import com.example.rpgmod.RpgMod;
import com.example.rpgmod.client.model.VoidWraithModel;
import com.example.rpgmod.entity.VoidWraithEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class VoidWraithRenderer extends MobRenderer<VoidWraithEntity, VoidWraithModel> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(RpgMod.MOD_ID, "textures/entity/void_wraith.png");

    public VoidWraithRenderer(EntityRendererProvider.Context context) {
        super(context, new VoidWraithModel(context.bakeLayer(VoidWraithModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(VoidWraithEntity entity) {
        return TEXTURE;
    }
}
