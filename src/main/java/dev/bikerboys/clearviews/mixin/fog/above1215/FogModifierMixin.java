package dev.bikerboys.clearviews.mixin.fog.above1215;




import dev.bikerboys.clearviews.config.ClearviewsConfig;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.multiplayer.ClientLevel;

//? if >=1.21.6 {
/*
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.environment.*;
*///?}

import net.minecraft.client.renderer.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//? if >=1.21.6 {
/*
@Mixin(value = {WaterFogEnvironment.class,
        LavaFogEnvironment.class,
        BlindnessFogEnvironment.class,
        DarknessFogEnvironment.class,
        AtmosphericFogEnvironment.class,
        DimensionOrBossFogEnvironment.class,
        PowderedSnowFogEnvironment.class})
*///?}


public class FogModifierMixin {



//? if >=1.21.6 {
/*

    @Inject(method = "setupFog", at = @At("TAIL"))
    private void modifyFog(FogData fogData, Entity entity, BlockPos pos, ClientLevel level, float renderDistance, DeltaTracker deltaTracker, CallbackInfo ci) {
        FogEnvironment fogEnvironment = (FogEnvironment)(Object)this;


        if (fogEnvironment instanceof WaterFogEnvironment) {
            if (getInstance().useWaterFog) {
                fogData.environmentalStart = getInstance().waterFogStart;
                fogData.environmentalEnd = getInstance().waterFogEnd;

                fogData.skyEnd = fogData.environmentalEnd;
                fogData.cloudEnd = fogData.environmentalEnd;
            }
        }

        if (fogEnvironment instanceof LavaFogEnvironment) {
            if (getInstance().useLavaFog) {
                fogData.environmentalStart = getInstance().lavaFogStart;
                fogData.environmentalEnd = getInstance().lavaFogEnd;

                fogData.skyEnd = fogData.environmentalEnd;
                fogData.cloudEnd = fogData.environmentalEnd;
            }
        }

        if (fogEnvironment instanceof DarknessFogEnvironment) {
            if (getInstance().useDarknessFog) {
                fogData.environmentalStart = getInstance().darknessFogStart;
                fogData.environmentalEnd = getInstance().darknessFogEnd;

                fogData.skyEnd = fogData.environmentalEnd;
                fogData.cloudEnd = fogData.environmentalEnd;
            }
        }

        if (fogEnvironment instanceof BlindnessFogEnvironment) {
            if (getInstance().useBlindnessFog) {
                fogData.environmentalStart = getInstance().blindnessFogStart;
                fogData.environmentalEnd = getInstance().blindnessFogEnd;

                fogData.skyEnd = fogData.environmentalEnd;
                fogData.cloudEnd = fogData.environmentalEnd;
            }
        }

        if (fogEnvironment instanceof AtmosphericFogEnvironment) {
            if (getInstance().useAtmosphericFog) {
                fogData.environmentalStart = getInstance().atmosphericFogStart;
                fogData.environmentalEnd = getInstance().atmosphericFogEnd;

                fogData.skyEnd = fogData.environmentalEnd;
                fogData.cloudEnd = fogData.environmentalEnd;
            }
        }

        if (fogEnvironment instanceof DimensionOrBossFogEnvironment) {
            if (getInstance().useDimensionOrBossFog) {
                fogData.environmentalStart = getInstance().dimensionOrBossFogStart;
                fogData.environmentalEnd = getInstance().dimensionOrBossFogEnd;

                fogData.skyEnd = fogData.environmentalEnd;
                fogData.cloudEnd = fogData.environmentalEnd;
            }
        }

        if (fogEnvironment instanceof PowderedSnowFogEnvironment) {
            if (getInstance().usePowderSnowFog) {
                fogData.environmentalStart = getInstance().powderSnowFogStart;
                fogData.environmentalEnd = getInstance().powderSnowFogEnd;

                fogData.skyEnd = fogData.environmentalEnd;
                fogData.cloudEnd = fogData.environmentalEnd;
            }
        }


    }



*///?}


    private ClearviewsConfig getInstance() {
        return ClearviewsConfig.CONFIG.instance();
    }

}

