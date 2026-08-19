package com.example.rpgmod.client.renderer;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.world.entity.monster.Zombie;

/**
 * Zombie gövde ailesindeki tüm RPG mob'ları için tekrar kullanılabilir renderer.
 * Vanilla model geometrisini kullanir, sadece dokusu (texture) farklidir.
 */
public class RpgZombieRenderer<T extends Zombie> extends MobRenderer<T, ZombieModel<T>> {

    private final ResourceLocation texture;

    public RpgZombieRenderer(EntityRendererProvider.Context context, ResourceLocation texture) {
        super(context, new ZombieModel<>(context.bakeLayer(ModelLayers.ZOMBIE)), 0.5F);
        this.texture = texture;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return this.texture;
    }
}
