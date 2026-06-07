package bikerboys.clearviews.client.mixin.bossbar;

import bikerboys.clearviews.client.config.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.components.BossHealthOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BossHealthOverlay.class)
public class BossHealthOverlayMixin {

    @Inject(method = "extractRenderState", at = @At("HEAD"), cancellable = true)
    private void stopthatbarovathere(GuiGraphicsExtractor graphics, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().disableBossBar) {
            ci.cancel();
        }
    }


}
