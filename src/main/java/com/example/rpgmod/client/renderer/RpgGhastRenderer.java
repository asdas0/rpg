package com.example.rpgmod.client.renderer;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.GhastModel;
import net.minecraft.world.entity.monster.Ghast;

/**
 * Ghast gövde ailesindeki tüm RPG mob'ları için tekrar kullanılabilir renderer.
 * Vanilla model geometrisini kullanir, sadece dokusu (texture) farklidir.
 */
public class RpgGhastRenderer<T extends Ghast> extends MobRenderer<T, GhastModel<T>> {

    private final ResourceLocation texture;

    public RpgGhastRenderer(EntityRendererProvider.Context context, ResourceLocation texture) {
        super(context, new GhastModel<>(context.bakeLayer(ModelLayers.GHAST)), 1.0F);
        this.texture = texture;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return this.texture;
    }
}
