package bikerboys.clearviews.client.mixin.particle;

import bikerboys.clearviews.client.config.*;
import com.llamalad7.mixinextras.injector.wrapoperation.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.core.particles.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(ClientLevel.class)
public class ClientLevelMixin {


    @WrapOperation(method = "tickWeatherEffects", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ClientLevel;addParticle(Lnet/minecraft/core/particles/ParticleOptions;DDDDDD)V"))
    private void cancelRainGroundParticles(ClientLevel instance, ParticleOptions particle, double x, double y, double z, double xd, double yd, double zd, Operation<Void> original) {
        if (!ClearviewsConfig.CONFIG.instance().disableRainGroundParticles) {
            original.call(instance, particle, x, y, z, xd, yd, zd);
        }
    }

}
