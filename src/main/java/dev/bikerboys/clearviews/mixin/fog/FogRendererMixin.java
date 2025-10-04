package dev.bikerboys.clearviews.mixin.fog;


//? if >=1.21.6 {

/*import net.minecraft.client.renderer.fog.FogRenderer;
import com.mojang.blaze3d.buffers.Std140Builder;
 *///?}

//? if <=1.21.5 {

import com.llamalad7.mixinextras.injector.wrapoperation.*;
import com.mojang.blaze3d.shaders.*;

import net.minecraft.client.*;
import net.minecraft.client.renderer.*;

 //?}


//? if 1.21.1 {
import com.mojang.blaze3d.systems.*;

//?}

//? if neoforge && 1.21.1 {
/*import net.neoforged.neoforge.client.*;

*///?}

import java.nio.*;

import dev.bikerboys.clearviews.config.ClearviewsConfig;


import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.material.*;


import org.joml.Vector4f;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.*;


import java.util.*;
import java.util.function.*;
import java.util.stream.*;

@Mixin(FogRenderer.class)
public class FogRendererMixin {

    //? if >=1.21.6 {


     //?}


//? if >=1.21.6 {


    /*@Inject(method = "updateBuffer", at = @At(value = "HEAD"), cancellable = true)
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

//? if <=1.21.5 && >=1.21.3 {


    /*@Shadow @Final private static List<FogRenderer.MobEffectFogFunction> MOB_EFFECT_FOG;

    @Inject(method = "setupFog", at = @At("HEAD"), cancellable = true)
    private static void alwaysSpectatorFog(Camera camera, FogRenderer.FogMode fogMode, Vector4f color, float renderDistance, boolean isFoggy, float partialTick, CallbackInfoReturnable<FogParameters> cir) {
        // Force spectator fog settings


        FogShape fogShape = FogShape.CYLINDER;
        FogType fogType = camera.getFluidInCamera();


        if (ClearviewsConfig.CONFIG.instance().useRenderDistanceFog) {
            if (fogType.equals(FogType.NONE)) {
                if (fogMode.equals(FogRenderer.FogMode.FOG_SKY) || fogMode.equals(FogRenderer.FogMode.FOG_TERRAIN)) {

                    if (!(Minecraft.getInstance().player.hasEffect(MobEffects.DARKNESS) || Minecraft.getInstance().player.hasEffect(MobEffects.BLINDNESS))) {
                        cir.setReturnValue(new FogParameters(getInstance().renderDistanceFogStart, getInstance().renderDistanceFogEnd, fogShape, color.x, color.y, color.z, color.w));
                    }
                }
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


 *///?}



//? if 1.21.1 {

    @Shadow @Final private static List<FogRenderer.MobEffectFogFunction> MOB_EFFECT_FOG;

    @Inject(method = "setupFog", at = @At("HEAD"), cancellable = true)
    private static void alwaysSpectatorFog(Camera camera, FogRenderer.FogMode fogMode, float farPlaneDistance, boolean shouldCreateFog, float partialTick, CallbackInfo cir) {
        // Force spectator fog settings


        FogShape fogShape = FogShape.CYLINDER;
        FogType fogType = camera.getFluidInCamera();


        if (ClearviewsConfig.CONFIG.instance().useRenderDistanceFog) {
            if (fogType.equals(FogType.NONE)) {
                if (fogMode.equals(FogRenderer.FogMode.FOG_SKY) || fogMode.equals(FogRenderer.FogMode.FOG_TERRAIN)) {

                    if (!(Minecraft.getInstance().player.hasEffect(MobEffects.DARKNESS) || Minecraft.getInstance().player.hasEffect(MobEffects.BLINDNESS))) {

                        RenderSystem.setShaderFogStart(getInstance().renderDistanceFogStart);
                        RenderSystem.setShaderFogEnd(getInstance().renderDistanceFogEnd);
                        RenderSystem.setShaderFogShape(fogShape);

                        //? if neoforge && 1.21.1 {
                        /*ClientHooks.onFogRender(fogMode, fogType, camera, partialTick, farPlaneDistance, getInstance().renderDistanceFogStart, getInstance().renderDistanceFogEnd, fogShape);
                        *///?}

                        cir.cancel();

                    }
                }
            }
        }

        if (ClearviewsConfig.CONFIG.instance().usePowderSnowFog) {
            if (fogType.equals(FogType.POWDER_SNOW)) {

                RenderSystem.setShaderFogStart(getInstance().powderSnowFogStart);
                RenderSystem.setShaderFogEnd(getInstance().powderSnowFogEnd);
                RenderSystem.setShaderFogShape(fogShape);

                //? if neoforge && 1.21.1 {
                /*ClientHooks.onFogRender(fogMode, fogType, camera, partialTick, farPlaneDistance, getInstance().powderSnowFogStart, getInstance().powderSnowFogEnd, fogShape);
                *///?}

                cir.cancel();
            }
        }

        if (ClearviewsConfig.CONFIG.instance().useLavaFog) {
            if (fogType.equals(FogType.LAVA)) {

                RenderSystem.setShaderFogStart(getInstance().lavaFogStart);
                RenderSystem.setShaderFogEnd(getInstance().lavaFogEnd);
                RenderSystem.setShaderFogShape(fogShape);

                //? if neoforge && 1.21.1 {
                /*ClientHooks.onFogRender(fogMode, fogType, camera, partialTick, farPlaneDistance, getInstance().lavaFogStart, getInstance().lavaFogEnd, fogShape);
                *///?}

                cir.cancel();
            }
        }

        if (ClearviewsConfig.CONFIG.instance().useWaterFog) {
            if (fogType.equals(FogType.WATER)) {

                RenderSystem.setShaderFogStart(getInstance().waterFogStart);
                RenderSystem.setShaderFogEnd(getInstance().waterFogEnd);
                RenderSystem.setShaderFogShape(fogShape);

                //? if neoforge && 1.21.1 {
                /*ClientHooks.onFogRender(fogMode, fogType, camera, partialTick, farPlaneDistance, getInstance().waterFogStart, getInstance().waterFogEnd, fogShape);
                *///?}

                cir.cancel();
            }
        }

    }

    private static ClearviewsConfig getInstance() {
        return ClearviewsConfig.CONFIG.instance();
    }


         

    //?}


    //? if <=1.21.5 {


    @WrapOperation(method = "getPriorityFogFunction", at = @At(value = "INVOKE", target = "Ljava/util/stream/Stream;filter(Ljava/util/function/Predicate;)Ljava/util/stream/Stream;"))
    private static Stream<FogRenderer.MobEffectFogFunction> clearviews$filterMobEffects(
            Stream<FogRenderer.MobEffectFogFunction> original,
            Predicate<FogRenderer.MobEffectFogFunction> predicate,
            Operation<Stream<FogRenderer.MobEffectFogFunction>> operation,
            Entity entity, float partialTick
    ) {


        Stream<FogRenderer.MobEffectFogFunction> base = operation.call(original, predicate);

        // Now apply our Clearviews filtering
        ClearviewsConfig cfg = (ClearviewsConfig) ClearviewsConfig.CONFIG.instance();
        return base.filter(fog -> {
            if (fog instanceof FogRenderer.DarknessFogFunction && cfg.disableDarkness) return false;
            if (fog instanceof FogRenderer.BlindnessFogFunction && cfg.disableBlindness) return false;
            return true;
        });
    }


    //?}


}

