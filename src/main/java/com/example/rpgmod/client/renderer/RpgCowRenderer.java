package com.example.rpgmod.client.renderer;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.CowModel;
import net.minecraft.world.entity.animal.Cow;

/**
 * Cow gövde ailesindeki tüm RPG mob'ları için tekrar kullanılabilir renderer.
 * Vanilla model geometrisini kullanir, sadece dokusu (texture) farklidir.
 */
public class RpgCowRenderer<T extends Cow> extends MobRenderer<T, CowModel<T>> {

    private final ResourceLocation texture;

    public RpgCowRenderer(EntityRendererProvider.Context context, ResourceLocation texture) {
        super(context, new CowModel<>(context.bakeLayer(ModelLayers.COW)), 0.7F);
        this.texture = texture;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return this.texture;
    }
}
