package com.pouffydev.krystal_core.foundation;

import com.pouffydev.krystal_core.KrystalCore;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.minecraft.client.renderer.entity.FoxRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.core.Registry;

import java.util.Collections;

public class KrystalCoreTags {
    public static <T> TagKey<T> optionalTag(Registry<T> registry,
                                            ResourceLocation id) {
        return TagKey.create(registry.key(), id);
    }
    
    public static <T> TagKey<T> forgeTag(Registry<T> registry, String path) {
        return optionalTag(registry, new ResourceLocation("c", path));
    }
    public static <T> TagKey<T> modTag(Registry<T> registry, String namespace, String path) {
        return optionalTag(registry, new ResourceLocation(namespace, path));
    }
    public static TagKey<Block> forgeBlockTag(String path) {
        return forgeTag(Registry.BLOCK, path);
    }
    
    public static TagKey<Item> forgeItemTag(String path) {
        return forgeTag(Registry.ITEM, path);
    }
    
    public static TagKey<Fluid> forgeFluidTag(String path) {
        return forgeTag(Registry.FLUID, path);
    }
    
    public static TagKey<Block> modBlockTag(String namespace, String path) {
        return modTag(Registry.BLOCK, namespace, path);
    }
    
    public static TagKey<Item> modItemTag(String namespace, String path) {
        return modTag(Registry.ITEM, namespace, path);
    }
    
    public static TagKey<Fluid> modFluidTag(String namespace, String path) {
        return modTag(Registry.FLUID, namespace, path);
    }
    
    @Deprecated(forRemoval = true)
    public static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> axeOrPickaxe() {
        return KrystalCoreTagGen.axeOrPickaxe();
    }
    
    @Deprecated(forRemoval = true)
    public static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> axeOnly() {
        return KrystalCoreTagGen.axeOnly();
    }
    
    @Deprecated(forRemoval = true)
    public static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> pickaxeOnly() {
        return KrystalCoreTagGen.pickaxeOnly();
    }
    
    @Deprecated(forRemoval = true)
    public static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, ItemBuilder<BlockItem, BlockBuilder<T, P>>> tagBlockAndItem(
            String... path) {
        return KrystalCoreTagGen.tagBlockAndItem(path);
    }
    public enum NameSpace {
        MOD(KrystalCore.ID, false, true),
        FORGE("forge"),
        TIC("tconstruct"),
        CREATE(KrystalCoreMods.create.getId())
        
        ;
        
        public final String id;
        public final boolean optionalDefault;
        public final boolean alwaysDatagenDefault;
        
        NameSpace(String id) {
            this(id, true, false);
        }
        
        NameSpace(String id, boolean optionalDefault, boolean alwaysDatagenDefault) {
            this.id = id;
            this.optionalDefault = optionalDefault;
            this.alwaysDatagenDefault = alwaysDatagenDefault;
        }
    }
}
