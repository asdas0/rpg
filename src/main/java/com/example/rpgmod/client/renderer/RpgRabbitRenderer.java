package com.example.rpgmod.client.renderer;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.RabbitModel;
import net.minecraft.world.entity.animal.Rabbit;

/**
 * Rabbit gövde ailesindeki tüm RPG mob'ları için tekrar kullanılabilir renderer.
 * Vanilla model geometrisini kullanir, sadece dokusu (texture) farklidir.
 */
public class RpgRabbitRenderer<T extends Rabbit> extends MobRenderer<T, RabbitModel<T>> {

    private final ResourceLocation texture;

    public RpgRabbitRenderer(EntityRendererProvider.Context context, ResourceLocation texture) {
        super(context, new RabbitModel<>(context.bakeLayer(ModelLayers.RABBIT)), 0.3F);
        this.texture = texture;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return this.texture;
    }
}
