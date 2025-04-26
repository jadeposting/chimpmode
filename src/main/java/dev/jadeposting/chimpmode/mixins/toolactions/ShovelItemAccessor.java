package dev.jadeposting.chimpmode.mixins.toolactions;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(ShovelItem.class)
public interface ShovelItemAccessor {
    @Accessor("FLATTENABLES")
    static Map<Block, Block> getFlattenableBlocks() {
        return null;
    }
}
