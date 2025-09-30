package dev.bikerboys.clearviews.mixin.fog;


import com.mojang.blaze3d.buffers.Std140Builder;
import dev.bikerboys.clearviews.config.ClearviewsConfig;
import net.minecraft.client.renderer.fog.FogRenderer;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.ByteBuffer;

@Mixin(FogRenderer.class)
public class FogRendererMixin {




    @Inject(method = "updateBuffer", at = @At(value = "HEAD"), cancellable = true)
    private void alwaysSpectatorFog(ByteBuffer buffer, int position, Vector4f fogColor, float environmentalStart, float environmentalEnd, float renderDistanceStart, float renderDistanceEnd, float skyEnd, float cloudEnd, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().useRenderDistanceFog) {


            buffer.position(position);
            Std140Builder.intoBuffer(buffer)
                    .putVec4(fogColor)
                    .putFloat(environmentalStart)
                    .putFloat(environmentalEnd)
                    .putFloat(ClearviewsConfig.CONFIG.instance().renderDistanceFogStart)
                    .putFloat(ClearviewsConfig.CONFIG.instance().renderDistanceFogEnd)
                    .putFloat(skyEnd)
                    .putFloat(cloudEnd);




            ci.cancel();
        }
    }



}
