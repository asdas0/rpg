package com.example.rpgmod.client.renderer;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.TurtleModel;
import net.minecraft.world.entity.animal.Turtle;

/**
 * Turtle gövde ailesindeki tüm RPG mob'ları için tekrar kullanılabilir renderer.
 * Vanilla model geometrisini kullanir, sadece dokusu (texture) farklidir.
 */
public class RpgTurtleRenderer<T extends Turtle> extends MobRenderer<T, TurtleModel<T>> {

    private final ResourceLocation texture;

    public RpgTurtleRenderer(EntityRendererProvider.Context context, ResourceLocation texture) {
        super(context, new TurtleModel<>(context.bakeLayer(ModelLayers.TURTLE)), 0.7F);
        this.texture = texture;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return this.texture;
    }
}
