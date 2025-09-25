package net.andreasdarsa.throne_mod.entity.client;

import net.andreasdarsa.throne_mod.entity.custom.ThroneEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class ThroneRenderer extends EntityRenderer<ThroneEntity> {
    public ThroneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(ThroneEntity pEntity) {
        return null;
    }

    @Override
    public boolean shouldRender(ThroneEntity pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
        return true;
    }
}
