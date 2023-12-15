package com.pouffydev.krystal_core;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class KrystalCoreDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
			ExistingFileHelper helper = ExistingFileHelper.withResourcesFromArg();
			KrystalCore.registrate.setupDatagen(generator, helper);
			KrystalCore.gatherData(generator, helper);
	}
}
