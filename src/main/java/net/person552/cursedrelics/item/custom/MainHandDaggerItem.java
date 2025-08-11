package net.person552.cursedrelics.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.person552.cursedrelics.CursedRelics;
import net.person552.cursedrelics.component.ModDataComponentTypes;
import net.person552.cursedrelics.item.ModItems;

public class MainHandDaggerItem extends SwordItem {
    public MainHandDaggerItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!Boolean.TRUE.equals(user.getStackInHand(hand).get(ModDataComponentTypes.ACTIVE))) {
            if (hand == Hand.MAIN_HAND) {
                if (user.getStackInHand(Hand.OFF_HAND).isEmpty()) {
                    CursedRelics.LOGGER.info("do the dagger thing now");

                    user.getStackInHand(hand).set(ModDataComponentTypes.ACTIVE, Boolean.TRUE);

                    ItemStack offHandStack = new ItemStack(RegistryEntry.of(ModItems.OFF_HAND_DAGGER));
                    user.setStackInHand(Hand.OFF_HAND, offHandStack);

                    return TypedActionResult.success(user.getStackInHand(hand));
                } else {
                    CursedRelics.LOGGER.info("clear your offhand");
                    return TypedActionResult.fail(user.getStackInHand(hand));
                }
            } else {
                CursedRelics.LOGGER.info("use it in your main hand");
                return TypedActionResult.fail(user.getStackInHand(hand));
            }
        } else {
            CursedRelics.LOGGER.info("already active");
            return TypedActionResult.fail(user.getStackInHand(hand));
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!(entity instanceof PlayerEntity player)) {
            return;
        }
        if (Boolean.TRUE.equals(stack.get(ModDataComponentTypes.ACTIVE)) && !ItemStack.areEqual(player.getStackInHand(Hand.MAIN_HAND), stack)) {
            stack.set(ModDataComponentTypes.ACTIVE, false);
        } else if (!player.getStackInHand(Hand.OFF_HAND).isOf(ModItems.OFF_HAND_DAGGER)) {
            stack.set(ModDataComponentTypes.ACTIVE, false);
        }
    }

    @Override
    public Text getName(ItemStack stack) {
        if (Boolean.TRUE.equals(stack.get(ModDataComponentTypes.ACTIVE))) {
            return Text.translatable(this.getTranslationKey());
        } else {
            return Text.translatable("item.cursedrelics.both_daggers");
        }
    }

}