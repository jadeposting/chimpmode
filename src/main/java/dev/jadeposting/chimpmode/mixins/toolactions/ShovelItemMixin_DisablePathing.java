package dev.jadeposting.chimpmode.mixins.toolactions;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.jadeposting.chimpmode.config.ChimpConfig;
import net.minecraft.world.item.ShovelItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ShovelItem.class)
public class ShovelItemMixin_DisablePathing {
    @ModifyExpressionValue(
        method = "useOn",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/block/state/BlockState;isAir()Z"
        )
    )
    private boolean stopPathing(boolean original) {
        return original && !ChimpConfig.instance().disableShovelPathing;
    }
}
