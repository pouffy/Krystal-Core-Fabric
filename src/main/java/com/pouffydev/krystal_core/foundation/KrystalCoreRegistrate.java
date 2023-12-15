package com.pouffydev.krystal_core.foundation;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.fabric.SimpleFlowableFluid;
import net.minecraft.resources.ResourceLocation;

public class KrystalCoreRegistrate extends AbstractRegistrate<KrystalCoreRegistrate> {
    /**
     * Construct a new Registrate for the given mod ID.
     *
     * @param modid The mod ID for which objects will be registered
     */
    protected KrystalCoreRegistrate(String modid) {
        super(modid);
    }
    public static KrystalCoreRegistrate create(String modid) {
        return new KrystalCoreRegistrate(modid);
    }
    
    
    public FluidBuilder<SimpleFlowableFluid.Flowing, KrystalCoreRegistrate> standardMWFluid(String name, String ID) {
        return fluid(name, new ResourceLocation(ID, "fluid/" + name + "/still"), new ResourceLocation(ID, "fluid/" + name + "/flowing"));
    }
}
