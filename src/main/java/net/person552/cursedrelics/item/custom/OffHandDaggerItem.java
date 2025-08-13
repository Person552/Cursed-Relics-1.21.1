package net.person552.cursedrelics.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.person552.cursedrelics.component.ModDataComponentTypes;
import net.person552.cursedrelics.entity.ModEntities;
import net.person552.cursedrelics.entity.custom.KataremiProjectileEntity;
import net.person552.cursedrelics.item.ModItems;
import net.person552.cursedrelics.sound.ModSounds;

public class OffHandDaggerItem extends Item {
    public OffHandDaggerItem(Settings settings) {
        super(settings);
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
        Integer charges = user.getStackInHand(hand).get(ModDataComponentTypes.CHARGES) == null ? 0 : user.getStackInHand(hand).get(ModDataComponentTypes.CHARGES);
            if (charges > 0) {
                if (!world.isClient) {
                    KataremiProjectileEntity projectileEntity = new KataremiProjectileEntity(ModEntities.KATAREMI_PROJECTILE, user, world, 4f * charges);
                    projectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
                    world.spawnEntity(projectileEntity);

                    world.playSound(null, user.getBlockPos(), charges == 3 ? ModSounds.KATAREMI_SHOOT_BIG : ModSounds.KATAREMI_SHOOT, SoundCategory.PLAYERS);
                }

                user.getStackInHand(hand).set(ModDataComponentTypes.CHARGES, 0);
                user.getItemCooldownManager().set(this, 10);
            }
            return TypedActionResult.fail(user.getStackInHand(hand));
    }
}
