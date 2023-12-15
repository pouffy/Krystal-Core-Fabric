package com.pouffydev.krystal_core;

import com.mojang.authlib.EnvironmentParser;
import com.pouffydev.krystal_core.foundation.KrystalCoreRegistrate;
import com.pouffydev.krystal_core.foundation.data.KCRegistrateTags;
import com.pouffydev.krystal_core.init.KCDebugItems;
import com.tterrag.registrate.Registrate;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.profiling.jfr.Environment;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KrystalCore implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	
	public static final String ID = "krystal_core";
    public static final Logger LOGGER = LoggerFactory.getLogger("krystal_core");
	public static final KrystalCoreRegistrate registrate = KrystalCoreRegistrate.create(ID);
	private static final boolean isDevelopmentEnvironment = FabricLoader.getInstance().isDevelopmentEnvironment();
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		if(isDevelopmentEnvironment) {
			KCDebugItems.register();
		}
		registrate.register();
		LOGGER.info("Hello Fabric world!");
	}
	public static void gatherData(FabricDataGenerator gen, ExistingFileHelper helper) {
		KCRegistrateTags.datagen();
	}
	@Contract("_ -> new")
	public static @NotNull ResourceLocation asResource(String path) {
		return new ResourceLocation(ID, path);
	}
	public static @NotNull KrystalCoreRegistrate registrate() {
		return registrate;
	}
}