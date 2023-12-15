package com.pouffydev.krystal_core;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class KrystalCoreClient implements ClientModInitializer {
    public static void registerModelPredicates() {
        ItemProperties.registerGeneric(new ResourceLocation(KrystalCore.ID, "count"), (pStack, pLevel, pEntity, pSeed) -> ((float) pStack.getCount()) / pStack.getMaxStackSize());
    }
    
    @Override
    public void onInitializeClient() {
        registerModelPredicates();
    }
}
