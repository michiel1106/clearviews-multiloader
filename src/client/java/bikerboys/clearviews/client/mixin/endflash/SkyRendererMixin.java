package bikerboys.clearviews.client.mixin.endflash;


import bikerboys.clearviews.client.config.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;


@Mixin(SkyRenderer.class)
public class SkyRendererMixin {


    @Inject(method = "renderEndFlash", at = @At("HEAD"), cancellable = true)
    private void renderEndFlashMixin(PoseStack poseStack, float intensity, float xAngle, float yAngle, CallbackInfo ci) {
        if (ClearviewsConfig.CONFIG.instance().disableEndFlashes) {
            ci.cancel();
        }
    }

}
