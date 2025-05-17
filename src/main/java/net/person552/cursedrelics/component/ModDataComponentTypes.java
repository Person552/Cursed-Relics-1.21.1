package net.person552.cursedrelics.component;

import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.person552.cursedrelics.CursedRelics;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    //public static final ComponentType<Boolean> BLOCKING = register("blocking", builder -> builder.codec(Codec.BOOL));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(CursedRelics.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        CursedRelics.LOGGER.info("Registering Data Component Types for " + CursedRelics.MOD_ID);
    }
}
