package dev.bikerboys.clearviews.mixin.darkness;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.bikerboys.clearviews.config.ClearviewsConfig;
import net.minecraft.client.renderer.LightTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LightTexture.class)
public class LightTextureMixin {



    @WrapOperation(method = "updateLightTexture", at = @At(value = "INVOKE", target = "Ljava/lang/Double;floatValue()F"))
    private float getthatdarknesouttahere(Double instance, Operation<Float> original) {

        if (ClearviewsConfig.CONFIG.instance().disableDarkness) {
            return 0.0f;
        }


        return original.call(instance);
    }


}
