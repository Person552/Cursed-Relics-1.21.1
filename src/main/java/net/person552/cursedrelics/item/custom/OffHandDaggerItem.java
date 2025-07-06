package net.person552.cursedrelics.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.person552.cursedrelics.component.ModDataComponentTypes;
import net.person552.cursedrelics.entity.ModEntities;
import net.person552.cursedrelics.entity.custom.KataremiProjectileEntity;
import net.person552.cursedrelics.item.ModItems;

public class OffHandDaggerItem extends SwordItem {
    public OffHandDaggerItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!(entity instanceof PlayerEntity player)) {
            return;
        }
        if (!Boolean.TRUE.equals(player.getStackInHand(Hand.MAIN_HAND).get(ModDataComponentTypes.ACTIVE)) || !player.getStackInHand(Hand.MAIN_HAND).isOf(ModItems.MAIN_HAND_DAGGER) || !player.getStackInHand(Hand.OFF_HAND).isOf(ModItems.OFF_HAND_DAGGER)) {
            stack.decrement(1);
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            KataremiProjectileEntity projectileEntity = new KataremiProjectileEntity(ModEntities.KATAREMI_PROJECTILE, user, world);
            projectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(projectileEntity);
        }

        user.getItemCooldownManager().set(this, 30);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
