package net.person552.cursedrelics.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class HolyFireParticle extends SpriteBillboardParticle {
    public HolyFireParticle(ClientWorld clientWorld, double x, double y, double z,
                            SpriteProvider spriteProvider, double xSpeed, double ySpeed, double zSpeed) {
        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed);

        this.setSpriteForAge(spriteProvider);
        this.gravityStrength = 0.35F;
        this.velocityMultiplier = 0.999F;
        this.velocityX *= 1.0F;
        this.velocityZ *= 1.0F;
        this.velocityY = this.random.nextFloat() * 0.15F + 0.05F;
        this.scale = this.scale * (this.random.nextFloat() * 2.0F + 0.2F);
        this.maxAge = (int)(16.0 / (Math.random() * 0.8 + 0.2));
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        @Nullable
        public Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z,
                                       double velocityX, double velocityY, double velocityZ) {
            return new HolyFireParticle(world, x, y, z, this.spriteProvider, velocityX, velocityY, velocityZ);
        }
    }
}
