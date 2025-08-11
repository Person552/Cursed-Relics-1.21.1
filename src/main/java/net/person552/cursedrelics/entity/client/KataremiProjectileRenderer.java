package net.person552.cursedrelics.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Identifier;
import net.person552.cursedrelics.entity.custom.KataremiProjectileEntity;

public class KataremiProjectileRenderer extends EntityRenderer<KataremiProjectileEntity> {
    public KataremiProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    public void render(KataremiProjectileEntity kataremiProjectileEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        kataremiProjectileEntity.getWorld().addImportantParticle( (ParticleEffect) ParticleTypes.BUBBLE,
                kataremiProjectileEntity.getX(), kataremiProjectileEntity.getY(), kataremiProjectileEntity.getZ(),
                0, 0 ,0);
    }

    @Override
    public Identifier getTexture(KataremiProjectileEntity entity) {
        return null;
    }
}
