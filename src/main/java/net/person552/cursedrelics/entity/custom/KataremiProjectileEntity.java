package net.person552.cursedrelics.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class KataremiProjectileEntity extends ProjectileEntity {
    protected Float damage;
    public KataremiProjectileEntity(EntityType<? extends ProjectileEntity> entityType, LivingEntity owner, World world, Float damage) {
        super(entityType, world);
        this.setPos(owner.getX(), owner.getEyeY() - 0.1F, owner.getZ());
        this.setOwner(owner);
        this.damage = damage;
}

    public KataremiProjectileEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }


    @Override
    public void tick() {
        super.tick();
        HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
        if (hitResult.getType() != HitResult.Type.MISS) {
            this.hitOrDeflect(hitResult);
        }

        this.checkBlockCollision();
        Vec3d vec3d = this.getVelocity();
        double d = this.getX() + vec3d.x;
        double e = this.getY() + vec3d.y;
        double f = this.getZ() + vec3d.z;
        this.updateRotation();

        this.setPosition(d, e, f);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        if (!this.getWorld().isClient()) {
            entity.damage(this.getDamageSources().thrown(this, this.getOwner()), this.damage);
            this.discard();
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult){
        super.onBlockHit(blockHitResult);
        if (!this.getWorld().isClient()) {
            this.discard();
        }
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
    }
}
