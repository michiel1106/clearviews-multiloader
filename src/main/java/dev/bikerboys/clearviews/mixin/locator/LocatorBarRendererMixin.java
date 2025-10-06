package dev.bikerboys.clearviews.mixin.locator;


import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.bikerboys.clearviews.config.ClearviewsConfig;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Gui;


import net.minecraft.client.gui.GuiGraphics;
//? if >=1.21.6 {

import net.minecraft.client.gui.contextualbar.LocatorBarRenderer;
import net.minecraft.client.waypoints.ClientWaypointManager;

//?}


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class LocatorBarRendererMixin {


    //? if >=1.21.6 {

    @WrapOperation(method = "nextContextualInfoState", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/waypoints/ClientWaypointManager;hasWaypoints()Z"))
    private boolean stopthatpldease(ClientWaypointManager instance, Operation<Boolean> original) {
        if (ClearviewsConfig.CONFIG.instance().disableLocatorBar) {
            return false;
        }
        return original.call(instance);
    }

     //?}


}
