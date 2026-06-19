package bikerboys.clearviews.client.mixin.fireoverlay;


import bikerboys.clearviews.client.config.*;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;
import org.joml.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScreenEffectRenderer.class)
public class ScreenEffectRendererMixin {


        @Inject(method = "submitFire", at = @At("HEAD"), cancellable = true)
    private static void stopthatrenderingplease(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, TextureAtlasSprite sprite, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().disableFireOverlay) {
            ci.cancel();
        }
    }

    @WrapOperation(method = "buildFireQuad", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/ScreenEffectRenderer;buildSpriteQuad(Lcom/mojang/blaze3d/vertex/VertexConsumer;Lorg/joml/Matrix4f;Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;FFFFFI)V"))
    private static void makeTransparent(VertexConsumer builder, Matrix4f pose, TextureAtlasSprite sprite, float x0, float y0, float x1, float y1, float z, int color, Operation<Void> original) {
        int alpha = 0x80; // 0x00 = fully transparent, 0xFF = fully opaque
        int newColor = (alpha << 24) | (color & 0x00FFFFFF);

        original.call(builder, pose, sprite, x0, y0, x1, y1, z, newColor);
    }

}
