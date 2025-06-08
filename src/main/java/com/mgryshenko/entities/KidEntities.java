package com.mgryshenko.entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.mgryshenko.Kidmod.NAMESPACE;
import static com.mgryshenko.entities.CubeEntity.CUBE_NAME;

public class KidEntities {

    /*
     * Registers our Cube Entity under the ID "entitytesting:cube".
     *
     * The entity is registered under the SpawnGroup#CREATURE category, which is what most animals and passive/neutral mobs use.
     * It has a hitbox size of .75x.75, or 12 "pixels" wide (3/4ths of a block).
     */
    public static final EntityType<CubeEntity> CUBE = EntityType.Builder
            .create(CubeEntity::new, SpawnGroup.CREATURE)
            .setDimensions(0.75f, 0.75f)
            .build(CUBE_NAME);

    public static void registerAll() {
        register(CUBE_NAME, CUBE, CubeEntity.createMobAttributes());
    }

    private static void register(String path, EntityType<CubeEntity> entityType, DefaultAttributeContainer.Builder attributes) {
        EntityType<CubeEntity> registered = Registry.register(
                Registries.ENTITY_TYPE,
                Identifier.of(NAMESPACE, path),
                entityType
        );
        FabricDefaultAttributeRegistry.register(registered, attributes);
    }
}
