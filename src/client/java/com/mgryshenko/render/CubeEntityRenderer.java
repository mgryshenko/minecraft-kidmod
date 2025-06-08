package com.mgryshenko.render;

import com.mgryshenko.entities.CubeEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

import static com.mgryshenko.Kidmod.NAMESPACE;
import static com.mgryshenko.render.CubeEntityModel.MODEL_CUBE_LAYER;

public class CubeEntityRenderer extends MobEntityRenderer<CubeEntity, CubeEntityModel> {

    public CubeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CubeEntityModel(context.getPart(MODEL_CUBE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(CubeEntity entity) {
        return Identifier.of(NAMESPACE, "textures/entity/cube/cube.png");
    }
}
