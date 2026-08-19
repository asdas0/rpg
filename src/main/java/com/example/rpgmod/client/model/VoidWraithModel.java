package com.example.rpgmod.client.model;

import com.example.rpgmod.entity.VoidWraithEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

/**
 * Zombiden/vanilla mob'lardan HİÇBİR parça almadan, sıfırdan çizilmiş model.
 * Gövde + kafa + iki kanat. Kanatlar uçarken çırpınıyor (setupAnim içinde).
 */
public class VoidWraithModel extends EntityModel<VoidWraithEntity> {

    public static final net.minecraft.client.model.geom.ModelLayerLocation LAYER_LOCATION =
            new net.minecraft.client.model.geom.ModelLayerLocation(
                    new net.minecraft.resources.ResourceLocation("rpgmod", "void_wraith"), "main");

    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart leftWing;
    private final ModelPart rightWing;

    public VoidWraithModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
        this.leftWing = this.body.getChild("left_wing");
        this.rightWing = this.body.getChild("right_wing");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        PartDefinition body = root.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, -4.0F, -3.0F, 6.0F, 8.0F, 6.0F),
                PartPose.offset(0.0F, 18.0F, 0.0F));

        body.addOrReplaceChild("head",
                CubeListBuilder.create().texOffs(0, 14)
                        .addBox(-2.5F, -4.0F, -2.5F, 5.0F, 5.0F, 5.0F),
                PartPose.offset(0.0F, -4.0F, 0.0F));

        body.addOrReplaceChild("left_wing",
                CubeListBuilder.create().texOffs(20, 0)
                        .addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 8.0F),
                PartPose.offsetAndRotation(3.0F, -2.0F, 0.0F, 0.0F, 0.3F, 0.0F));

        body.addOrReplaceChild("right_wing",
                CubeListBuilder.create().texOffs(20, 14)
                        .addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 8.0F),
                PartPose.offsetAndRotation(-3.0F, -2.0F, 0.0F, 0.0F, -0.3F, 0.0F));

        return LayerDefinition.create(mesh, 32, 32);
    }

    @Override
    public void setupAnim(VoidWraithEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.head.xRot = headPitch * ((float) Math.PI / 180F);

        // Kanat çırpma animasyonu
        float flap = (float) Math.sin(ageInTicks * 0.7F) * 0.6F;
        this.leftWing.yRot = 0.3F + flap;
        this.rightWing.yRot = -0.3F - flap;

        // Gövde hafif salınım
        this.body.yRot = (float) Math.sin(ageInTicks * 0.05F) * 0.05F;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, com.mojang.blaze3d.vertex.VertexConsumer buffer, int packedLight, int packedOverlay, float r, float g, float b, float a) {
        body.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
    }
}
