package com.pouffydev.krystal_core.compatabilities;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;

public abstract class CompatibleMod {
    private boolean isLoaded;
    public abstract String getModID();
    public void tryLoad() {
        if (FabricLoader.getInstance().isModLoaded(this.getModID())) {
            this.isLoaded = true;
            this.onLoad();
        }
    }
    protected abstract void onLoad();
    public boolean isLoaded() {
        return this.isLoaded;
    }
    public ResourceLocation getLocation(String path) {
        return new ResourceLocation(this.getModID(), path);
    }
}
