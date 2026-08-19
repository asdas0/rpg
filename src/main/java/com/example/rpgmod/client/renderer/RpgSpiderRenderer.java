package com.example.rpgmod.client.renderer;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.world.entity.monster.Spider;

/**
 * Spider gövde ailesindeki tüm RPG mob'ları için tekrar kullanılabilir renderer.
 * Vanilla model geometrisini kullanir, sadece dokusu (texture) farklidir.
 */
public class RpgSpiderRenderer<T extends Spider> extends MobRenderer<T, SpiderModel<T>> {

    private final ResourceLocation texture;

    public RpgSpiderRenderer(EntityRendererProvider.Context context, ResourceLocation texture) {
        super(context, new SpiderModel<>(context.bakeLayer(ModelLayers.SPIDER)), 0.7F);
        this.texture = texture;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return this.texture;
    }
}
