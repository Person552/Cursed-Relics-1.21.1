package net.person552.cursedrelics.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.person552.cursedrelics.CursedRelics;
import net.person552.cursedrelics.component.ModDataComponentTypes;
import net.person552.cursedrelics.effect.CursedCollapseEffect;
import net.person552.cursedrelics.effect.ModEffects;

import java.util.List;

public class LaceractItem extends SwordItem {
    public LaceractItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (!attacker.getWorld().isClient) {
            var amplifier = 0;
            if (target.hasStatusEffect(ModEffects.CURSED_COLLAPSE)) {
                if (target.getStatusEffect(ModEffects.CURSED_COLLAPSE).getAmplifier() <= 4) {
                    amplifier = 4;
                } else {
                    amplifier = target.getStatusEffect(ModEffects.CURSED_COLLAPSE).getAmplifier() + 1;
                }
            }
            var instance = new StatusEffectInstance(ModEffects.CURSED_COLLAPSE, 40, amplifier, false, false, true);
            //attacker.getWorld().playSoundFromEntity(attacker, SoundEvents.BLOCK_DECORATED_POT_SHATTER, SoundCategory.PLAYERS, 1.0f, 1.0f);
            target.addStatusEffect(instance);
            //stack.set(ModDataComponentTypes.LATEST_TARGET_ID, target.getId());
        }
        return super.postHit(stack, target, attacker);
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
