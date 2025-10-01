package dev.bikerboys.clearviews.mixin.darkness;




//? if >=1.21.6 {

/*import net.minecraft.client.renderer.fog.FogRenderer;
import net.minecraft.client.renderer.fog.environment.*;


 *///?}

import net.minecraft.client.renderer.*;


        import org.spongepowered.asm.mixin.Mixin;
        import org.spongepowered.asm.mixin.gen.Accessor;

        import java.util.List;

@Mixin(FogRenderer.class)
public interface FogRendererMixin {

    //? if >=1.21.6 {
    
    /*@Accessor("FOG_ENVIRONMENTS")
    List<FogEnvironment> getFogEnviroments();
    *///?}

    //? if 1.21.5 {
    

    @Accessor("MOB_EFFECT_FOG")
    List<FogRenderer.MobEffectFogFunction> getMobEffectFunction();


     //?}

}

