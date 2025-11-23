package dev.bikerboys.clearviews.mixin.particle;

import com.llamalad7.mixinextras.injector.wrapoperation.*;
import com.mojang.blaze3d.vertex.*;
import dev.bikerboys.clearviews.config.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;

//? if >= 1.21.2 {
@Mixin(WeatherEffectRenderer.class)
//?} else if <= 1.21.1 {
/*@Mixin(LevelRenderer.class)
*///?}
public class WeatherEffectRendererMixin {

    //? if >= 1.21.2 {
    @WrapOperation(method = "renderInstances", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/VertexConsumer;setColor(I)Lcom/mojang/blaze3d/vertex/VertexConsumer;"))
    private VertexConsumer setColor(VertexConsumer instance, int color, Operation<VertexConsumer> original) {

        int a = (color >> 24) & 0xFF;
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;

        int newA = (int)(a * ClearviewsConfig.CONFIG.instance().weatherOpacityMultiplier);

        int newColor = (newA << 24) | (r << 16) | (g << 8) | b;

        return original.call(instance, newColor);


    }
    //?}

    //? if <= 1.21.1 {

    /*@WrapOperation(method = "renderSnowAndRain", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/VertexConsumer;setColor(FFFF)Lcom/mojang/blaze3d/vertex/VertexConsumer;"))
    private VertexConsumer setColorMixin(VertexConsumer instance, float red, float green, float blue, float alpha, Operation<VertexConsumer> original) {

        float b = alpha * ClearviewsConfig.CONFIG.instance().weatherOpacityMultiplier;


        return original.call(instance, red, green, blue, b);
    }


    *///?}

}
