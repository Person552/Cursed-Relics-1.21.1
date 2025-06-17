package net.person552.cursedrelics.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.person552.cursedrelics.CursedRelics;
import net.person552.cursedrelics.component.ModDataComponentTypes;
import net.person552.cursedrelics.effect.ModEffects;

import java.util.List;
import java.util.UUID;

public class LaceractItem extends SwordItem {
    public LaceractItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (!attacker.getWorld().isClient) {
            ServerWorld world = (ServerWorld) attacker.getWorld();
            var amplifier = 0;
            if (target.hasStatusEffect(ModEffects.CURSED_COLLAPSE)) {
                if (target.getStatusEffect(ModEffects.CURSED_COLLAPSE).getAmplifier() >= 4) {
                    amplifier = 4;
                } else {
                    amplifier = target.getStatusEffect(ModEffects.CURSED_COLLAPSE).getAmplifier() + 1;
                }
            }
            var instance = new StatusEffectInstance(ModEffects.CURSED_COLLAPSE, 40, amplifier, false, false, true);
            CursedRelics.LOGGER.info(String.valueOf(amplifier));
            target.setStatusEffect(instance, attacker);

            world.playSoundFromEntity(null, target, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 2.0f, 0.8f + amplifier*0.3f);
            stack.set(ModDataComponentTypes.LATEST_TARGET_ID, target.getUuidAsString());
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && stack.get(ModDataComponentTypes.LATEST_TARGET_ID) != null) {
            ServerWorld serverWorld = (ServerWorld) world;
            LivingEntity targetEntity = (LivingEntity) serverWorld.getEntity(UUID.fromString(stack.get(ModDataComponentTypes.LATEST_TARGET_ID)));
            stack.set(ModDataComponentTypes.ACTIVE, targetEntity != null && targetEntity.hasStatusEffect(ModEffects.CURSED_COLLAPSE));
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.cursedrelics.laceract"));
        } else {
            tooltip.add(Text.translatable("tooltip.cursedrelics.shift_info"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
