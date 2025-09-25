package net.andreasdarsa.throne_mod.entity;

import net.andreasdarsa.throne_mod.ThroneMod;
import net.andreasdarsa.throne_mod.entity.custom.ThroneEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntity {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ThroneMod.MOD_ID);

    public static final RegistryObject<EntityType<ThroneEntity>> THRONE =
            ENTITY_TYPES.register("throne_entity", () -> EntityType.Builder.of(ThroneEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("throne_entity"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
