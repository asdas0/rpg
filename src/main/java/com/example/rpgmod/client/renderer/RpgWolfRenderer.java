package com.example.rpgmod.client.renderer;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.WolfModel;
import net.minecraft.world.entity.animal.Wolf;

/**
 * Wolf gövde ailesindeki tüm RPG mob'ları için tekrar kullanılabilir renderer.
 * Vanilla model geometrisini kullanir, sadece dokusu (texture) farklidir.
 */
public class RpgWolfRenderer<T extends Wolf> extends MobRenderer<T, WolfModel<T>> {

    private final ResourceLocation texture;

    public RpgWolfRenderer(EntityRendererProvider.Context context, ResourceLocation texture) {
        super(context, new WolfModel<>(context.bakeLayer(ModelLayers.WOLF)), 0.4F);
        this.texture = texture;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return this.texture;
    }
}
