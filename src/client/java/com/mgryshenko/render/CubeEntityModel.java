package com.mgryshenko.render;

import com.google.common.collect.ImmutableList;
import com.mgryshenko.entities.CubeEntity;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import static com.mgryshenko.Kidmod.NAMESPACE;
import static com.mgryshenko.entities.CubeEntity.CUBE_NAME;

public class CubeEntityModel extends EntityModel<CubeEntity> {

    public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(
            Identifier.of(NAMESPACE, CUBE_NAME),
            "main"
    );

    private final ModelPart base;

    public CubeEntityModel(ModelPart part) {
        this.base = part.getChild(CUBE_NAME);
    }


    @Override
    public void setAngles(CubeEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        ImmutableList<ModelPart> parts = ImmutableList.of(base);
        parts.forEach(part -> part.render(matrices, vertices, light, overlay, red, green, blue, alpha));
    }

    /**
     * Use BlockBench, make your model and export it to get this method for your entity model.
     */
    public static TexturedModelData getTexturedModelData() {
        ModelPartBuilder locationOffsetSize = ModelPartBuilder.create()
                .uv(0, 0)
                .cuboid(-6F, 12F, -6F, 12F, 12F, 12F);
        ModelTransform pivot = ModelTransform.pivot(0F, 0F, 0F);

        ModelData modelData = new ModelData();
        modelData.getRoot().addChild(CUBE_NAME, locationOffsetSize, pivot);
        return TexturedModelData.of(modelData, 64, 64);
    }
}
