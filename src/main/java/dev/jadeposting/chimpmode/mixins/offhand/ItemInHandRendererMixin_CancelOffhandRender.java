package dev.jadeposting.chimpmode.mixins.offhand;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.jadeposting.chimpmode.config.ChimpConfig;
import net.minecraft.client.renderer.ItemInHandRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemInHandRenderer.class)
public class ItemInHandRendererMixin_CancelOffhandRender {
    @ModifyExpressionValue(
        method = "renderHandsWithItems",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/client/renderer/ItemInHandRenderer$HandRenderSelection;renderOffHand:Z"
        )
    )
    private boolean stopOffhandRendering(boolean original) {
        return !ChimpConfig.instance().hideOffhandItems;
    }
}
