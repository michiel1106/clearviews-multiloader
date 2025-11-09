package dev.bikerboys.clearviews.mixin.particle;

import com.llamalad7.mixinextras.injector.wrapoperation.*;
import dev.bikerboys.clearviews.config.*;
import net.fabricmc.fabric.impl.client.indigo.renderer.helper.*;
import net.minecraft.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.state.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.commands.arguments.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

@Mixin(QuadParticleRenderState.class)
public abstract class ParticleMixin {


    @WrapOperation(method = "add", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/state/QuadParticleRenderState$Storage;add(FFFFFFFFFFFFII)V"))
    private void addmixin(QuadParticleRenderState.Storage instance, float x, float y, float z, float xRot, float yRot, float zRot, float wRot, float quadSize, float u0, float u1, float v0, float v1, int color, int packedLight, Operation<Void> original) {

        int a = (color >> 24) & 0xFF;
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;

        int newA = (int)(a * ClearviewsConfig.CONFIG.instance().particleOpacityMultiplier);

        int newColor = (newA << 24) | (r << 16) | (g << 8) | b;

        original.call(instance, x, y, z, xRot, yRot, zRot, wRot, quadSize, u0, u1, v0, v1, newColor, packedLight);





    }


}
