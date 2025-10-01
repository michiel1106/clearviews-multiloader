package dev.bikerboys.clearviews.mixin.fog.equalto1215;


import net.minecraft.client.renderer.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

@Mixin(targets = "net.minecraft.client.renderer.FogRenderer$DarknessFogFunction")
public class DarknessMobEffectMixin {


    @Inject(method = "setupFog", at = @At("HEAD"), cancellable = true)
    private void yayplasework(FogRenderer.FogData fogData, LivingEntity entity, MobEffectInstance effectInstance, float farPlaneDistance, float partialTick, CallbackInfo ci) {
        fogData

        ci.cancel();
    }


}
