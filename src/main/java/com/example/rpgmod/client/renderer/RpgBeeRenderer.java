package com.example.rpgmod.client.renderer;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.BeeModel;
import net.minecraft.world.entity.animal.Bee;

/**
 * Bee gövde ailesindeki tüm RPG mob'ları için tekrar kullanılabilir renderer.
 * Vanilla model geometrisini kullanir, sadece dokusu (texture) farklidir.
 */
public class RpgBeeRenderer<T extends Bee> extends MobRenderer<T, BeeModel<T>> {

    private final ResourceLocation texture;

    public RpgBeeRenderer(EntityRendererProvider.Context context, ResourceLocation texture) {
        super(context, new BeeModel<>(context.bakeLayer(ModelLayers.BEE)), 0.3F);
        this.texture = texture;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return this.texture;
    }
}
