package com.example.rpgmod.client.renderer;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.ParrotModel;
import net.minecraft.world.entity.animal.Parrot;

/**
 * Parrot gövde ailesindeki tüm RPG mob'ları için tekrar kullanılabilir renderer.
 * Vanilla model geometrisini kullanir, sadece dokusu (texture) farklidir.
 * (ParrotModel generic olmadigi icin ikinci tip parametresi sabittir.)
 */
public class RpgParrotRenderer extends MobRenderer<Parrot, ParrotModel> {

    private final ResourceLocation texture;

    public RpgParrotRenderer(EntityRendererProvider.Context context, ResourceLocation texture) {
        super(context, new ParrotModel(context.bakeLayer(ModelLayers.PARROT)), 0.1F);
        this.texture = texture;
    }

    @Override
    public ResourceLocation getTextureLocation(Parrot entity) {
        return this.texture;
    }
}
