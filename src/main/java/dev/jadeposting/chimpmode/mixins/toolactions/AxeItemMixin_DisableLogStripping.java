package dev.jadeposting.chimpmode.mixins.toolactions;

import dev.jadeposting.chimpmode.config.ChimpConfig;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(AxeItem.class)
public class AxeItemMixin_DisableLogStripping {
    @Inject(
        method = "getStripped",
        at = @At("HEAD"),
        cancellable = true
    )
    private void stopLogStripping(CallbackInfoReturnable<Optional<BlockState>> cir) {
        if (ChimpConfig.instance().disableLogStripping) cir.setReturnValue(Optional.empty());
    }
}
