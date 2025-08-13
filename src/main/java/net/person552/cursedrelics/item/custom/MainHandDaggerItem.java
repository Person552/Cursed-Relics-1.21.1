package net.person552.cursedrelics.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.person552.cursedrelics.component.ModDataComponentTypes;
import net.person552.cursedrelics.item.ModItems;

import java.util.List;

public class MainHandDaggerItem extends Item {
    public MainHandDaggerItem(Settings settings) {
        super(settings);
    }

    public static ToolComponent createToolComponent() {
        return new ToolComponent(List.of(), 1.0F, 2);
    }

    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) { return !miner.isCreative(); }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!Boolean.TRUE.equals(user.getStackInHand(hand).get(ModDataComponentTypes.ACTIVE))) {
            if (hand == Hand.MAIN_HAND) {
                if (user.getStackInHand(Hand.OFF_HAND).isEmpty()) {
                    //do the dagger thing now

                    user.getStackInHand(hand).set(ModDataComponentTypes.ACTIVE, Boolean.TRUE);

                    ItemStack offHandStack = new ItemStack(RegistryEntry.of(ModItems.OFF_HAND_DAGGER));
                    user.setStackInHand(Hand.OFF_HAND, offHandStack);

                    return TypedActionResult.success(user.getStackInHand(hand));
                } else {
                    //clear your offhand
                    return TypedActionResult.fail(user.getStackInHand(hand));
                }
            } else {
                //use it in your main hand
                return TypedActionResult.fail(user.getStackInHand(hand));
            }
        } else {
            //already active
            return TypedActionResult.fail(user.getStackInHand(hand));
        }
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (Boolean.TRUE.equals(stack.get(ModDataComponentTypes.ACTIVE))) {
            ItemStack offHandStack = attacker.getOffHandStack();
            Integer stackCharges = offHandStack.get(ModDataComponentTypes.CHARGES) == null ? 0 : offHandStack.get(ModDataComponentTypes.CHARGES);
            if (stackCharges < 3) {
                offHandStack.set(ModDataComponentTypes.CHARGES, stackCharges + 1);
            }
        }
        return false;
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