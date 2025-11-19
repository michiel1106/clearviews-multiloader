package dev.bikerboys.clearviews.mixin.endflash;


import com.llamalad7.mixinextras.injector.wrapoperation.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

@Mixin(SkyRenderer.class)
public class SkyRendererMixin {

    @Inject(method = "renderEndFlash", at = @At("HEAD"), cancellable = true)
    private void renderEndFlashMixin(PoseStack poseStack, float intensity, float xAngle, float yAngle, CallbackInfo ci) {


    }

}
