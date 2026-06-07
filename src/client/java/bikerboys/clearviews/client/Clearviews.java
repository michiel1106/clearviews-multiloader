package bikerboys.clearviews.client;



import bikerboys.clearviews.client.config.ClearviewsConfig;

import net.fabricmc.api.*;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.*;
import net.minecraft.world.effect.*;


public class Clearviews implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClearviewsConfig.CONFIG.load();

        ClientTickEvents.START_CLIENT_TICK.register(Clearviews::tick);
    }


    public static void tick(Minecraft mc) {
        if (ClearviewsConfig.CONFIG.instance().disableDarkness) {
            if (mc.player != null) {
                mc.player.removeEffectNoUpdate(MobEffects.DARKNESS);
                mc.player.removeEffect(MobEffects.DARKNESS);
            }
        }

        if (ClearviewsConfig.CONFIG.instance().disableBlindness) {
            if (mc.player != null) {
                mc.player.removeEffectNoUpdate(MobEffects.BLINDNESS);
                mc.player.removeEffect(MobEffects.BLINDNESS);

            }
        }
    }

}
