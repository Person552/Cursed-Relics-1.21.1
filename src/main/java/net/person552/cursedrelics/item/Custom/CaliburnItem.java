package net.person552.cursedrelics.item.Custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.person552.cursedrelics.CursedRelics;
import net.person552.cursedrelics.effect.ModEffects;

import java.util.List;

public class CaliburnItem extends SwordItem {
    public CaliburnItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.getWorld().isClient) {
            if (attacker instanceof PlayerEntity) {
                CursedRelics.LOGGER.info(String.valueOf(((PlayerEntity) attacker).getAttackCooldownProgress(2f)));
            }
            var instance = new StatusEffectInstance(ModEffects.HOLY_FIRE, 70, 1, false, true, true);
            target.addStatusEffect(instance);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.cursedrelics.caliburn"));
        } else {
            tooltip.add(Text.translatable("tooltip.cursedrelics.shiftinfo"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
