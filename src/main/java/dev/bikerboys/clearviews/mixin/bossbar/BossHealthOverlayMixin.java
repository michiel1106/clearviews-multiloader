package dev.bikerboys.clearviews.mixin.bossbar;

import dev.bikerboys.clearviews.config.ClearviewsConfig;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.BossHealthOverlay;
import net.minecraft.world.BossEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BossHealthOverlay.class)
public class BossHealthOverlayMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void stopthatbarovathere(GuiGraphics guiGraphics, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().disableBossBar) {
            ci.cancel();
        }
    }


}
