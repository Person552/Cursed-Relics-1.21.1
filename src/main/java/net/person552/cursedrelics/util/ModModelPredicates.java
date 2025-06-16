package net.person552.cursedrelics.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.person552.cursedrelics.CursedRelics;
import net.person552.cursedrelics.component.ModDataComponentTypes;
import net.person552.cursedrelics.effect.ModEffects;
import net.person552.cursedrelics.item.ModItems;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(
                ModItems.XIPHANOX,
                Identifier.of(CursedRelics.MOD_ID, "blocking"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F);

        ModelPredicateProviderRegistry.register(
                ModItems.LACERACT,
                Identifier.of(CursedRelics.MOD_ID, "collapsing"),
                (stack, world, entity, seed) ->
                                stack.get(ModDataComponentTypes.LATEST_TARGET_ID) != null &&
                                        world.getEntityById(stack.get(ModDataComponentTypes.LATEST_TARGET_ID)) instanceof LivingEntity &&
                                        ((LivingEntity) world.getEntityById(stack.get(ModDataComponentTypes.LATEST_TARGET_ID))).hasStatusEffect(ModEffects.CURSED_COLLAPSE) ? 1.0F : 0.0F);
    }
}
