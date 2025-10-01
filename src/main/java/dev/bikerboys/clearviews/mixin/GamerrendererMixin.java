package dev.bikerboys.clearviews.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.bikerboys.clearviews.config.ClearviewsConfig;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.*;
//? if >=1.21.6 {

/*import net.minecraft.client.renderer.fog.FogRenderer;
import net.minecraft.client.renderer.fog.environment.BlindnessFogEnvironment;
import net.minecraft.client.renderer.fog.environment.DarknessFogEnvironment;
 *///?}

import dev.bikerboys.clearviews.mixin.darkness.FogRendererMixin;

import net.minecraft.util.Mth;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
@Debug(export = true)
public abstract class GamerrendererMixin {

    @Shadow private float spinningEffectTime;

    @Shadow private float spinningEffectSpeed;

    @Shadow private float darkenWorldAmountO;


    //? if >=1.21.6 {
    
    /*@Shadow @Final private FogRenderer fogRenderer;
   *///?}


    @Shadow public abstract void renderLevel(DeltaTracker deltaTracker);

    @WrapOperation(method = "renderLevel", at = @At(value = "INVOKE", target = "Lorg/joml/Matrix4f;rotate(FLorg/joml/Vector3fc;)Lorg/joml/Matrix4f;", ordinal = 0))
    private Matrix4f stopNauseaOverlayRotate(Matrix4f instance, float angle, Vector3fc axis, Operation<Matrix4f> original) {

        if (ClearviewsConfig.CONFIG.instance().disableNausea) {
            return instance;
        }
        return original.call(instance, angle, axis);
    }


    @WrapOperation(method = "renderLevel", at = @At(value = "INVOKE", target = "Lorg/joml/Matrix4f;rotate(FLorg/joml/Vector3fc;)Lorg/joml/Matrix4f;", ordinal = 1))
    private Matrix4f stopNauseaOverlayRotatesecondone(Matrix4f instance, float angle, Vector3fc axis, Operation<Matrix4f> original) {
        if (ClearviewsConfig.CONFIG.instance().disableNausea) {
            return instance;
        }
        return original.call(instance, angle, axis);
    }

    @WrapOperation(method = "renderLevel", at = @At(value = "INVOKE", target = "Lorg/joml/Matrix4f;scale(FFF)Lorg/joml/Matrix4f;"))
    private Matrix4f stopNauseaOverlayScale(Matrix4f instance, float x, float y, float z, Operation<Matrix4f> original) {
        if (ClearviewsConfig.CONFIG.instance().disableNausea) {
            return instance;
        }

        return original.call(instance, x, y, z);
    }

//? if >=1.21.6 {
    
     //?}


    //? if >=1.21.6 {
    
    /*@Inject(method = "renderLevel", at = @At("HEAD"))
    private void changethedarknessandyeahjustremovetheblindnessanddarkness(DeltaTracker deltaTracker, CallbackInfo ci) {

        if (ClearviewsConfig.CONFIG.instance().disableDarkness) {
            ((FogRendererMixin) fogRenderer).getFogEnviroments().removeIf((env -> env instanceof DarknessFogEnvironment));
        }
        if (ClearviewsConfig.CONFIG.instance().disableBlindness) {
            ((FogRendererMixin) fogRenderer).getFogEnviroments().removeIf((env -> env instanceof BlindnessFogEnvironment));
        }


    }
   *///?}








}
