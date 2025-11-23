package dev.bikerboys.clearviews.mixin.particle;

import com.llamalad7.mixinextras.injector.wrapoperation.*;
import com.mojang.blaze3d.vertex.*;
import dev.bikerboys.clearviews.config.*;
import net.minecraft.client.particle.*;

//? if >= 1.21.9 {
import net.minecraft.client.renderer.state.*;
//?}

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;

//? if >= 1.21.9 {
@Mixin(QuadParticleRenderState.class)
//?} else if <= 1.21.8 {
/*@Mixin(SingleQuadParticle.class)
*///?}
public abstract class ParticleMixin {


    //? if >= 1.21.9 {

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
    //?} else if <= 1.21.8 {

    /*@WrapOperation(method = "renderVertex", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/VertexConsumer;setColor(FFFF)Lcom/mojang/blaze3d/vertex/VertexConsumer;"))
    private VertexConsumer args(VertexConsumer instance, float red, float green, float blue, float alpha, Operation<VertexConsumer> original) {

        float newA = (alpha * ClearviewsConfig.CONFIG.instance().particleOpacityMultiplier);

        return original.call(instance, red, green, blue, newA);
    }




    *///?}


}
