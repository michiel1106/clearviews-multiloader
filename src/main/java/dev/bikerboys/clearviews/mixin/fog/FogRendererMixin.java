package dev.bikerboys.clearviews.mixin.fog;


//? if >=1.21.6 {
/*
import net.minecraft.client.renderer.fog.FogRenderer;
import com.mojang.blaze3d.buffers.Std140Builder;
 *///?}

//? if >=1.21.5 {

import com.mojang.blaze3d.shaders.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;

 //?}



import dev.bikerboys.clearviews.config.ClearviewsConfig;


import net.minecraft.world.level.material.*;

import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.*;

@Mixin(FogRenderer.class)
public class FogRendererMixin {

    //? if >=1.21.6 {
    /*

     *///?}


//? if >=1.21.6 {
    /*

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

 *///?}

//? if 1.21.5 {
    

    @Inject(method = "setupFog", at = @At("HEAD"), cancellable = true)
    private static void alwaysSpectatorFog(Camera camera, FogRenderer.FogMode fogMode, Vector4f color, float renderDistance, boolean isFoggy, float partialTick, CallbackInfoReturnable<FogParameters> cir) {
        // Force spectator fog settings
        FogShape fogShape = FogShape.SPHERE;
        FogType fogType = camera.getFluidInCamera();
        if (ClearviewsConfig.CONFIG.instance().useRenderDistanceFog) {
            if (fogMode.equals(FogRenderer.FogMode.FOG_SKY) || fogMode.equals(FogRenderer.FogMode.FOG_TERRAIN)) {
                cir.setReturnValue(new FogParameters(getInstance().renderDistanceFogStart, getInstance().renderDistanceFogEnd, fogShape, color.x, color.y, color.z, color.w));
            }
        }

        if (ClearviewsConfig.CONFIG.instance().usePowderSnowFog) {
            if (fogType.equals(FogType.POWDER_SNOW)) {
                cir.setReturnValue(new FogParameters(getInstance().powderSnowFogStart, getInstance().powderSnowFogEnd, fogShape, color.x, color.y, color.z, color.w));
            }
        }

        if (ClearviewsConfig.CONFIG.instance().useLavaFog) {
            if (fogType.equals(FogType.LAVA)) {
                cir.setReturnValue(new FogParameters(getInstance().lavaFogStart, getInstance().lavaFogEnd, fogShape, color.x, color.y, color.z, color.w));
            }
        }

        if (ClearviewsConfig.CONFIG.instance().useWaterFog) {
            if (fogType.equals(FogType.WATER)) {
                cir.setReturnValue(new FogParameters(getInstance().waterFogStart, getInstance().waterFogEnd, fogShape, color.x, color.y, color.z, color.w));
            }
        }

    }

    private static ClearviewsConfig getInstance() {
        return ClearviewsConfig.CONFIG.instance();
    }


 //?}


}

