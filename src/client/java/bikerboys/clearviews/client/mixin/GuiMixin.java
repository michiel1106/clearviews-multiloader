package bikerboys.clearviews.client.mixin;

import bikerboys.clearviews.client.config.*;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.gui.*;
import net.minecraft.resources.*;
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

    @Shadow @Final private static Identifier POWDER_SNOW_OUTLINE_LOCATION;

    @Inject(method = "extractSpyglassOverlay", at = @At("HEAD"), cancellable = true)
    private void stopSpyglassOverlay(GuiGraphicsExtractor guiGraphics, float scopeScale, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().removeSpyglassBorder) {
            ci.cancel();
        }
    }


    @WrapOperation(method = "extractCameraOverlays", at = @At(value = "INVOKE", target = "Ljava/util/Optional;isPresent()Z", ordinal = 0))
    private boolean stoppumpkin(Optional instance, Operation<Boolean> original) {
        if (ClearviewsConfig.CONFIG.instance().removePumpkinOverlay) {
            return false;
        }
        return original.call(instance);
    }
    


    @Inject(method = "extractTextureOverlay", at = @At(value = "HEAD"), cancellable = true)
    private void stoppowderedsnow(GuiGraphicsExtractor guiGraphics, Identifier shaderLocation, float alpha, CallbackInfo ci) {

        if (ClearviewsConfig.CONFIG.instance().disablePowderedSnowOverlay) {
            if (shaderLocation.equals(POWDER_SNOW_OUTLINE_LOCATION)) {
            ci.cancel();
            }
        }

    }


    @Inject(method = "extractConfusionOverlay", at = @At("HEAD"), cancellable = true)
    private void stopNauseaOverlay(GuiGraphicsExtractor guiGraphics, float intensity, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().disableNausea) {
            ci.cancel();
        }
    }


    @Inject(method = "extractPortalOverlay", at = @At("HEAD"), cancellable = true)
    private void stopPortalOverlay(GuiGraphicsExtractor guiGraphics, float intensity, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().disablePortalOverlay) {
            ci.cancel();
        }
    }

    @Inject(method = "extractVignette", at = @At("HEAD"), cancellable = true)
    private void stopVignette(GuiGraphicsExtractor guiGraphics, Entity entity, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().disableVignette) {
            ci.cancel();
        }
    }
}
