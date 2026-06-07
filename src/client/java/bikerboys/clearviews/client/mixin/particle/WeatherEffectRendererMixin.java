package bikerboys.clearviews.client.mixin.particle;

import bikerboys.clearviews.client.config.*;
import com.llamalad7.mixinextras.injector.wrapoperation.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;


@Mixin(WeatherEffectRenderer.class)
public class WeatherEffectRendererMixin {

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

}
