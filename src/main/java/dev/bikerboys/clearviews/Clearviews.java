package dev.bikerboys.clearviews;



import dev.bikerboys.clearviews.config.ClearviewsConfig;

//? if fabric {
/*import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
*///?}

import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffects;
//? if neoforge {
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
//?}


//? if neoforge {
@Mod(value = "@MODID@", dist = Dist.CLIENT)
//?} else {
/*@Entrypoint
*///?}
public class Clearviews /*? if fabric {*/ /*implements ModInitializer *//*?}*/ {
    //? if fabric {
    /*@Override
    public void onInitialize() {
        ClearviewsConfig.CONFIG.load();
    }
    *///?}



    //? if neoforge {
    public Clearviews() {
        ClearviewsConfig.CONFIG.load();
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> (client, parent) -> ClearviewsConfig.configScreen(parent));


    }





    //?}



}
