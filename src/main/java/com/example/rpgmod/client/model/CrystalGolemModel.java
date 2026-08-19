package com.example.rpgmod.client.model;

import com.example.rpgmod.entity.CrystalGolemEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

/**
 * Sıfırdan çizilmiş iri golem modeli: gövde, kafa, 2 kol, 2 bacak.
 * Zombiden hiçbir kod/parça almıyor — kendi iskeleti, kendi oranları.
 */
public class CrystalGolemModel extends EntityModel<CrystalGolemEntity> {

    public static final net.minecraft.client.model.geom.ModelLayerLocation LAYER_LOCATION =
            new net.minecraft.client.model.geom.ModelLayerLocation(
                    new net.minecraft.resources.ResourceLocation("rpgmod", "crystal_golem"), "main");

    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart leftArm;
    private final ModelPart rightArm;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;

    public CrystalGolemModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.leftArm = root.getChild("left_arm");
        this.rightArm = root.getChild("right_arm");
        this.leftLeg = root.getChild("left_leg");
        this.rightLeg = root.getChild("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        root.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.0F, -12.0F, -3.0F, 10.0F, 12.0F, 6.0F),
                PartPose.offset(0.0F, 12.0F, 0.0F));

        root.addOrReplaceChild("head",
                CubeListBuilder.create().texOffs(0, 20)
                        .addBox(-3.5F, -7.0F, -3.5F, 7.0F, 7.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        root.addOrReplaceChild("left_arm",
                CubeListBuilder.create().texOffs(32, 0)
                        .addBox(-2.0F, -1.0F, -2.0F, 4.0F, 14.0F, 4.0F),
                PartPose.offset(7.0F, 2.0F, 0.0F));

        root.addOrReplaceChild("right_arm",
                CubeListBuilder.create().texOffs(48, 0)
                        .addBox(-2.0F, -1.0F, -2.0F, 4.0F, 14.0F, 4.0F),
                PartPose.offset(-7.0F, 2.0F, 0.0F));

        root.addOrReplaceChild("left_leg",
                CubeListBuilder.create().texOffs(32, 20)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(3.0F, 12.0F, 0.0F));

        root.addOrReplaceChild("right_leg",
                CubeListBuilder.create().texOffs(48, 20)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(-3.0F, 12.0F, 0.0F));

        return LayerDefinition.create(mesh, 64, 40);
    }

    @Override
    public void setupAnim(CrystalGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.head.xRot = headPitch * ((float) Math.PI / 180F);

        // Ağır yürüyüş animasyonu: kollar ve bacaklar zıt yönde sallanır
        this.rightArm.xRot = (float) Math.cos(limbSwing * 0.5F) * 1.2F * limbSwingAmount;
        this.leftArm.xRot = (float) Math.cos(limbSwing * 0.5F + Math.PI) * 1.2F * limbSwingAmount;
        this.rightLeg.xRot = (float) Math.cos(limbSwing * 0.5F + Math.PI) * 1.0F * limbSwingAmount;
        this.leftLeg.xRot = (float) Math.cos(limbSwing * 0.5F) * 1.0F * limbSwingAmount;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float r, float g, float b, float a) {
        body.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        head.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        leftArm.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        rightArm.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        leftLeg.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        rightLeg.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
    }
}
