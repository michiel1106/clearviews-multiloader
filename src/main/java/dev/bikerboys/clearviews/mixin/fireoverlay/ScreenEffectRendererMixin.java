package dev.bikerboys.clearviews.mixin.fireoverlay;


import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.bikerboys.clearviews.config.ClearviewsConfig;
import net.minecraft.client.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.minecraft.client.renderer.texture.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScreenEffectRenderer.class)
public class ScreenEffectRendererMixin {


    //? if >=1.21.4 && <=1.21.8 {

    @Inject(method = "renderFire", at = @At("HEAD"), cancellable = true)
    private static void stopthatrenderingplease(PoseStack poseStack, MultiBufferSource bufferSource, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().disableFireOverlay) {
            ci.cancel();
        }
    }
    //?} else if <=1.21.3 && >=1.21.0 {

    /*@Inject(method = "renderFire", at = @At("HEAD"), cancellable = true)
    private static void stopthatrenderingplease(Minecraft minecraft, PoseStack poseStack, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().disableFireOverlay) {
            ci.cancel();
        }
    }

    *///?}


    //? if >=1.21.9 {
        /*@Inject(method = "renderFire", at = @At("HEAD"), cancellable = true)
    private static void stopthatrenderingplease(PoseStack poseStack, MultiBufferSource bufferSource, TextureAtlasSprite sprite, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().disableFireOverlay) {
            ci.cancel();
        }
    }

         
    *///?}

    @WrapOperation(method = "renderFire", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/VertexConsumer;setColor(FFFF)Lcom/mojang/blaze3d/vertex/VertexConsumer;"))
    private static VertexConsumer makeTransparent(VertexConsumer instance, float red, float green, float blue, float alpha, Operation<VertexConsumer> original) {



        return original.call(instance, red, green, blue, ClearviewsConfig.CONFIG.instance().fireOpacity);
    }

}
