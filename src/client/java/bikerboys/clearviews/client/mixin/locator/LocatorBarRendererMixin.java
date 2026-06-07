package bikerboys.clearviews.client.mixin.locator;


import bikerboys.clearviews.client.config.*;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.gui.Gui;

import net.minecraft.client.waypoints.ClientWaypointManager;



import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Gui.class)
public class LocatorBarRendererMixin {

    @WrapOperation(method = "nextContextualInfoState", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/waypoints/ClientWaypointManager;hasWaypoints()Z"))
    private boolean stopthatpldease(ClientWaypointManager instance, Operation<Boolean> original) {
        if (ClearviewsConfig.CONFIG.instance().disableLocatorBar) {
            return false;
        }
        return original.call(instance);
    }



}
