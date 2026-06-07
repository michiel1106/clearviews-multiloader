package bikerboys.clearviews.client.mixin.fireoverlay;


import bikerboys.clearviews.client.config.*;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.minecraft.client.renderer.texture.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScreenEffectRenderer.class)
public class ScreenEffectRendererMixin {


        @Inject(method = "renderFire", at = @At("HEAD"), cancellable = true)
    private static void stopthatrenderingplease(PoseStack poseStack, MultiBufferSource bufferSource, TextureAtlasSprite sprite, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().disableFireOverlay) {
            ci.cancel();
        }
    }

    @WrapOperation(method = "renderFire", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/VertexConsumer;setColor(FFFF)Lcom/mojang/blaze3d/vertex/VertexConsumer;"))
    private static VertexConsumer makeTransparent(VertexConsumer instance, float red, float green, float blue, float alpha, Operation<VertexConsumer> original) {
        return original.call(instance, red, green, blue, ClearviewsConfig.CONFIG.instance().fireOpacity);
    }

}
