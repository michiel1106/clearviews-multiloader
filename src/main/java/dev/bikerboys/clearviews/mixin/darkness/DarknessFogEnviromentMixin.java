package dev.bikerboys.clearviews.mixin.darkness;


import dev.bikerboys.clearviews.config.ClearviewsConfig;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.environment.DarknessFogEnvironment;
import net.minecraft.client.renderer.fog.environment.MobEffectFogEnvironment;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DarknessFogEnvironment.class)
public abstract class DarknessFogEnviromentMixin extends MobEffectFogEnvironment {


    /*
    @Override
    public boolean providesColor() {
        return false;
    }

    @Override
    public boolean modifiesDarkness() {
        return false;
    }

    @Inject(method = "getModifiedDarkness", at = @At("HEAD"), cancellable = true)
    private void cancelfogbutsecondone(LivingEntity entity, float darkness, float partialTick, CallbackInfoReturnable<Float> cir) {
        if (ClearviewsConfig.CONFIG.instance().disableDarkness) {
            cir.cancel();
        }
    }

    @Inject(method = "setupFog", at = @At("HEAD"), cancellable = true)
    private void scancelfogpelase(FogData fogData, Entity entity, BlockPos pos, ClientLevel level, float renderDistance, DeltaTracker deltaTracker, CallbackInfo ci) {
        ci.cancel();
    }

     */

}
