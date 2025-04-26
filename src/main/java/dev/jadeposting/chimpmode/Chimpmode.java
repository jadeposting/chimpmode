package dev.jadeposting.chimpmode;

import dev.jadeposting.chimpmode.config.ChimpConfig;
import dev.jadeposting.chimpmode.mixins.toolactions.AxeItemAccessor;
import dev.jadeposting.chimpmode.mixins.toolactions.ShovelItemAccessor;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.block.Block;

public class Chimpmode implements ClientModInitializer {
    @SuppressWarnings("DataFlowIssue")
    @Override
    public void onInitializeClient() {
        ChimpConfig.register();

        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (world.isClientSide) {
                Item item = player.getItemInHand(hand).getItem();
                Block block = world.getBlockState(hitResult.getBlockPos()).getBlock();
                if (ChimpConfig.instance().disableLogStripping && item instanceof AxeItem) {
                    if (AxeItemAccessor.getStrippableBlocks().containsKey(block)) return InteractionResult.FAIL;
                }

                if (ChimpConfig.instance().disableShovelPathing && item instanceof ShovelItem) {
                    if (ShovelItemAccessor.getFlattenableBlocks().containsKey(block)) return InteractionResult.FAIL;
                }
            }

            return InteractionResult.PASS;
        });
    }
}
