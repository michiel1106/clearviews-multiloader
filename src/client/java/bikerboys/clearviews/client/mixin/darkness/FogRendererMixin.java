package bikerboys.clearviews.client.mixin.darkness;


import net.minecraft.client.renderer.fog.FogRenderer;
import net.minecraft.client.renderer.fog.environment.*;





import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import java.util.List;

@Mixin(FogRenderer.class)
public interface FogRendererMixin {

    @Accessor("FOG_ENVIRONMENTS")
    List<FogEnvironment> getFogEnviroments();



}

