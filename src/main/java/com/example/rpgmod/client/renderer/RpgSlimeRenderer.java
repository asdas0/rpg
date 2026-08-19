package com.example.rpgmod.client.renderer;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.world.entity.monster.Slime;

/**
 * Slime gövde ailesindeki tüm RPG mob'ları için tekrar kullanılabilir renderer.
 * Vanilla model geometrisini kullanir, sadece dokusu (texture) farklidir.
 */
public class RpgSlimeRenderer<T extends Slime> extends MobRenderer<T, SlimeModel<T>> {

    private final ResourceLocation texture;

    public RpgSlimeRenderer(EntityRendererProvider.Context context, ResourceLocation texture) {
        super(context, new SlimeModel<>(context.bakeLayer(ModelLayers.SLIME)), 0.5F);
        this.texture = texture;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return this.texture;
    }
}
