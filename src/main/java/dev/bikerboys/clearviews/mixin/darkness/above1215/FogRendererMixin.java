package dev.bikerboys.clearviews.mixin.darkness.above1215;




import com.google.common.collect.Lists;
import dev.bikerboys.clearviews.config.ClearviewsConfig;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.multiplayer.ClientLevel;


//? if >=1.21.6 {
/*
import net.minecraft.client.renderer.fog.FogRenderer;
import net.minecraft.client.renderer.fog.environment.*;



import net.minecraft.client.renderer.*;


import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;
import java.util.List;

@Mixin(FogRenderer.class)
public interface FogRendererMixin {


    @Accessor("FOG_ENVIRONMENTS")
    List<FogEnvironment> getFogEnviroments();


}

 *///?}