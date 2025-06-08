package com.mgryshenko.items.eggs;

import com.mgryshenko.entities.KidEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SpawnEggItem;

public class CubeSpawnEgg extends SpawnEggItem {

    public CubeSpawnEgg() {
        super(KidEntities.CUBE,
                0x241a16,
                0x964b00,
                new FabricItemSettings());
    }
}
