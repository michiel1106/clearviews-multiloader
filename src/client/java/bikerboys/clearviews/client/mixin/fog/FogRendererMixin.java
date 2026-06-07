package bikerboys.clearviews.client.mixin.fog;


import bikerboys.clearviews.client.config.*;
import net.minecraft.client.renderer.fog.FogRenderer;
import com.mojang.blaze3d.buffers.Std140Builder;

import java.nio.*;



import org.joml.Vector4f;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.*;

@Mixin(FogRenderer.class)
public class FogRendererMixin {




    @Inject(method = "updateBuffer(Ljava/nio/ByteBuffer;ILorg/joml/Vector4f;FFFFFF)V", at = @At(value = "HEAD"), cancellable = true)
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

