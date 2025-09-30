package dev.bikerboys.clearviews.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.bikerboys.clearviews.config.ClearviewsConfig;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(Gui.class)
@Debug(export = true)
public class GuiMixin  {

    @Shadow @Final private static ResourceLocation POWDER_SNOW_OUTLINE_LOCATION;

    @Inject(method = "renderSpyglassOverlay", at = @At("HEAD"), cancellable = true)
    private void stopSpyglassOverlay(GuiGraphics guiGraphics, float scopeScale, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().removeSpyglassBorder) {
            ci.cancel();
        }
    }

    @WrapOperation(method = "renderCameraOverlays", at = @At(value = "INVOKE", target = "Ljava/util/Optional;isPresent()Z", ordinal = 0))
    private boolean stoppumpkin(Optional instance, Operation<Boolean> original) {
        if (ClearviewsConfig.CONFIG.instance().removePumpkinOverlay) {
            return false;
        }
        return original.call(instance);
    }


    @Inject(method = "renderTextureOverlay", at = @At(value = "HEAD"), cancellable = true)
    private void stoppowderedsnow(GuiGraphics guiGraphics, ResourceLocation shaderLocation, float alpha, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().disablePowderedSnowOverlay) {
            if (shaderLocation.equals(POWDER_SNOW_OUTLINE_LOCATION)) {
            ci.cancel();
            }
        }

    }

    @Inject(method = "renderConfusionOverlay", at = @At("HEAD"), cancellable = true)
    private void stopNauseaOverlay(GuiGraphics guiGraphics, float intensity, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().disableNausea) {
            ci.cancel();
        }
    }

    @Inject(method = "renderPortalOverlay", at = @At("HEAD"), cancellable = true)
    private void stopPortalOverlay(GuiGraphics guiGraphics, float intensity, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().disablePortalOverlay) {
            ci.cancel();
        }
    }

    @Inject(method = "renderVignette", at = @At("HEAD"), cancellable = true)
    private void stopVignette(GuiGraphics guiGraphics, Entity entity, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().disableVignette) {
            ci.cancel();
        }
    }
}
