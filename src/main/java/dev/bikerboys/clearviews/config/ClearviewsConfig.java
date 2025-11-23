package dev.bikerboys.clearviews.config;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.FloatFieldControllerBuilder;
import dev.isxander.yacl3.api.controller.FloatSliderControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import dev.isxander.yacl3.api.controller.ValueFormattableController;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.autogen.FloatSlider;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.gui.ValueFormatters;
import dev.isxander.yacl3.gui.controllers.slider.FloatSliderController;
import dev.isxander.yacl3.platform.YACLPlatform;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ClearviewsConfig {
    public static final ConfigClassHandler<ClearviewsConfig> CONFIG = ConfigClassHandler.createBuilder(ClearviewsConfig.class)
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(YACLPlatform.getConfigDir().resolve("clearviews.json"))
                    .build())
            .build();

    @SerialEntry public boolean disableNausea = true;
    @SerialEntry public boolean disableBlindness = true;
    @SerialEntry public boolean disableDarkness = true;

    @SerialEntry public boolean disablePortalOverlay = true;
    @SerialEntry public boolean removeSpyglassBorder = true;
    @SerialEntry public boolean removePumpkinOverlay = true;


    //? if >=1.21.6
    @SerialEntry public boolean disableLocatorBar = true;

    @SerialEntry public boolean disableVignette = true;
    @SerialEntry public boolean disableBossBar = false;
    @SerialEntry public boolean disablePowderedSnowOverlay = true;

    @SerialEntry public float particleOpacityMultiplier = 1.0f;
    @SerialEntry public float weatherOpacityMultiplier = 1.0f;

    @SerialEntry public boolean disableFireOverlay = false;
    @SerialEntry public float fireOpacity = 0.9f;

    @SerialEntry public boolean useWaterFog = true;
    @SerialEntry public float waterFogStart = 1000f;
    @SerialEntry public float waterFogEnd = 1000f;

    @SerialEntry public boolean useLavaFog = true;
    @SerialEntry public float lavaFogStart = 1000f;
    @SerialEntry public float lavaFogEnd = 1000f;

    //? if >=1.21.6 {
                        
    @SerialEntry public boolean useBlindnessFog = true;
    @SerialEntry public float blindnessFogStart = 1000f;
    @SerialEntry public float blindnessFogEnd = 1000f;

    @SerialEntry public boolean useDarknessFog = true;
    @SerialEntry public float darknessFogStart = 1000f;
    @SerialEntry public float darknessFogEnd = 1000f;


    //?} else {
    
    /*@SerialEntry public boolean useBlindnessFog = true;
    @SerialEntry public float blindnessFogStart = 1000f;
    @SerialEntry public float blindnessFogEnd = 1000f;

    @SerialEntry public boolean useDarknessFog = true;
    @SerialEntry public float darknessFogStart = 1000f;
    @SerialEntry public float darknessFogEnd = 1000f;


          *///?}

    //? if >= 1.21.9 {
    @SerialEntry public boolean disableEndFlashes = false;
    //?}

    @SerialEntry public boolean useAtmosphericFog = true;
    @SerialEntry public float atmosphericFogStart = 1000f;
    @SerialEntry public float atmosphericFogEnd = 1000f;

    @SerialEntry public boolean useDimensionOrBossFog = true;
    @SerialEntry public float dimensionOrBossFogStart = 1000f;
    @SerialEntry public float dimensionOrBossFogEnd = 1000f;

    @SerialEntry public boolean usePowderSnowFog = true;
    @SerialEntry public float powderSnowFogStart = 1000f;
    @SerialEntry public float powderSnowFogEnd = 1000f;

    @SerialEntry public boolean useRenderDistanceFog = true;
    @SerialEntry public float renderDistanceFogStart = 1000f;
    @SerialEntry public float renderDistanceFogEnd = 1000f;


    public static Screen configScreen(Screen parent) {
        return YetAnotherConfigLib.create(CONFIG, ((defaults, config, builder) -> builder
                .title(Component.literal("Clearviews"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("Clearviews"))
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Disable Nausea"))
                                .description(OptionDescription.of(Component.literal("Disables the nausea effect")))
                                .binding(defaults.disableNausea, () -> config.disableNausea, newVal -> config.disableNausea = newVal)

                                .controller(TickBoxControllerBuilder::create)
                                .build())

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Disable Blindness"))
                                .description(OptionDescription.of(Component.literal("Disables the blindness effect")))
                                .binding(defaults.disableBlindness, () -> config.disableBlindness, newVal -> config.disableBlindness = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())


                        .group(OptionGroup.createBuilder()
                                .name(Component.literal("Particles"))

                                .option(Option.<Float>createBuilder()
                                        .name(Component.literal("Set Particle Opacity"))
                                        .description(OptionDescription.of(Component.literal("Sets the particle opacity of all particles that support it.")))
                                        .binding(defaults.particleOpacityMultiplier, () -> config.particleOpacityMultiplier, newVal -> config.particleOpacityMultiplier = newVal)
                                        .controller((floatOption -> FloatSliderControllerBuilder.create(floatOption)
                                                .range(0.0f, 1.0f)
                                                .step(0.01f)
                                                .formatValue(ValueFormatters.percent(0))))
                                        .build())

                                .option(Option.<Float>createBuilder()
                                        .name(Component.literal("Set Weather Opacity"))
                                        .description(OptionDescription.of(Component.literal("Sets the particle opacity of all weather types.")))
                                        .binding(defaults.weatherOpacityMultiplier, () -> config.weatherOpacityMultiplier, newVal -> config.weatherOpacityMultiplier = newVal)
                                        .controller((floatOption -> FloatSliderControllerBuilder.create(floatOption)
                                                .range(0.0f, 1.0f)
                                                .step(0.01f)
                                                .formatValue(ValueFormatters.percent(0))))
                                        .build())



                                .build())

                        //? if >= 1.21.9 {

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Disable End Flashes"))
                                .description(OptionDescription.of(Component.literal("Disables the end flashes")))
                                .binding(defaults.disableEndFlashes, () -> config.disableEndFlashes, newVal -> config.disableEndFlashes = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        //?}

                        .group(OptionGroup.createBuilder()
                                .name(Component.literal("Fire"))

                                .option(Option.<Boolean>createBuilder()
                                        .name(Component.literal("Disable Fire Overlay"))
                                        .description(OptionDescription.of(Component.literal("Disables the fire overlay")))
                                        .binding(defaults.disableFireOverlay, () -> config.disableFireOverlay, newVal -> config.disableFireOverlay = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())


                                .option(Option.<Float>createBuilder()
                                        .name(Component.literal("Fire Opacity"))
                                        .description(OptionDescription.of(Component.literal("Sets the fire opacity")))
                                        .binding(defaults.fireOpacity, () -> config.fireOpacity, newVal -> config.fireOpacity = newVal)
                                        .controller((floatOption -> FloatSliderControllerBuilder.create(floatOption)
                                                .range(0.0f, 1.0f)
                                                .step(0.05f)
                                                .formatValue(ValueFormatters.percent(0))))
                                        .build())


                                .build())

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Disable Darkness"))
                                .description(OptionDescription.of(Component.literal("Disables the darkness effect")))
                                .binding(defaults.disableDarkness, () -> config.disableDarkness, newVal -> config.disableDarkness = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())


                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Disable Portal Overlay"))
                                .description(OptionDescription.of(Component.literal("Disables the portal overlay")))
                                .binding(defaults.disablePortalOverlay, () -> config.disablePortalOverlay, newVal -> config.disablePortalOverlay = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Remove Spyglass Border"))
                                .description(OptionDescription.of(Component.literal("Removes the spyglass border")))
                                .binding(defaults.removeSpyglassBorder, () -> config.removeSpyglassBorder, newVal -> config.removeSpyglassBorder = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Remove Pumpkin Overlay"))
                                .description(OptionDescription.of(Component.literal("Removes the pumpkin overlay")))
                                .binding(defaults.removePumpkinOverlay, () -> config.removePumpkinOverlay, newVal -> config.removePumpkinOverlay = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())



                        //? if >=1.21.6 {
                        
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Disable Locator Bar"))
                                .description(OptionDescription.of(Component.literal("Disables the locator bar")))
                                .binding(defaults.disableLocatorBar, () -> config.disableLocatorBar, newVal -> config.disableLocatorBar = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        //?}

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Disable Vignette"))
                                .description(OptionDescription.of(Component.literal("Disables the vignette effect when you're close to the border")))
                                .binding(defaults.disableVignette, () -> config.disableVignette, newVal -> config.disableVignette = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Disable Bossbar"))
                                .description(OptionDescription.of(Component.literal("Disables the bossbar")))
                                .binding(defaults.disableBossBar, () -> config.disableBossBar, newVal -> config.disableBossBar = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())


                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Disable Powdered Snow Overlay"))
                                .description(OptionDescription.of(Component.literal("Disables the powdered snow overlay")))
                                .binding(defaults.disablePowderedSnowOverlay, () -> config.disablePowderedSnowOverlay, newVal -> config.disablePowderedSnowOverlay = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())





                        .group(makeFogGroup("Water Fog", defaults.useWaterFog, () -> config.useWaterFog, v -> config.useWaterFog = v,
                                defaults.waterFogStart, () -> config.waterFogStart, v -> config.waterFogStart = v,
                                defaults.waterFogEnd, () -> config.waterFogEnd, v -> config.waterFogEnd = v))

                        .group(makeFogGroup("Lava Fog", defaults.useLavaFog, () -> config.useLavaFog, v -> config.useLavaFog = v,
                                defaults.lavaFogStart, () -> config.lavaFogStart, v -> config.lavaFogStart = v,
                                defaults.lavaFogEnd, () -> config.lavaFogEnd, v -> config.lavaFogEnd = v))


                        //? if >=1.21.6 {
                        
                        .group(makeFogGroup("Blindness Fog", defaults.useBlindnessFog, () -> config.useBlindnessFog, v -> config.useBlindnessFog = v,
                                defaults.blindnessFogStart, () -> config.blindnessFogStart, v -> config.blindnessFogStart = v,
                                defaults.blindnessFogEnd, () -> config.blindnessFogEnd, v -> config.blindnessFogEnd = v))

                        .group(makeFogGroup("Darkness Fog", defaults.useDarknessFog, () -> config.useDarknessFog, v -> config.useDarknessFog = v,
                                defaults.darknessFogStart, () -> config.darknessFogStart, v -> config.darknessFogStart = v,
                                defaults.darknessFogEnd, () -> config.darknessFogEnd, v -> config.darknessFogEnd = v))
                        //?}

                        .group(makeFogGroup("Atmospheric Fog", defaults.useAtmosphericFog, () -> config.useAtmosphericFog, v -> config.useAtmosphericFog = v,
                                defaults.atmosphericFogStart, () -> config.atmosphericFogStart, v -> config.atmosphericFogStart = v,
                                defaults.atmosphericFogEnd, () -> config.atmosphericFogEnd, v -> config.atmosphericFogEnd = v))

                        .group(makeFogGroup("Dimension/Boss Fog", defaults.useDimensionOrBossFog, () -> config.useDimensionOrBossFog, v -> config.useDimensionOrBossFog = v,
                                defaults.dimensionOrBossFogStart, () -> config.dimensionOrBossFogStart, v -> config.dimensionOrBossFogStart = v,
                                defaults.dimensionOrBossFogEnd, () -> config.dimensionOrBossFogEnd, v -> config.dimensionOrBossFogEnd = v))

                        .group(makeFogGroup("Powder Snow Fog", defaults.usePowderSnowFog, () -> config.usePowderSnowFog, v -> config.usePowderSnowFog = v,
                                defaults.powderSnowFogStart, () -> config.powderSnowFogStart, v -> config.powderSnowFogStart = v,
                                defaults.powderSnowFogEnd, () -> config.powderSnowFogEnd, v -> config.powderSnowFogEnd = v))

                        .group(makeFogGroup("Render Distance Fog", defaults.useRenderDistanceFog, () -> config.useRenderDistanceFog, v -> config.useRenderDistanceFog = v,
                                defaults.renderDistanceFogStart, () -> config.renderDistanceFogStart, v -> config.renderDistanceFogStart = v,
                                defaults.renderDistanceFogEnd, () -> config.renderDistanceFogEnd, v -> config.renderDistanceFogEnd = v))




                        .build())
        )).generateScreen(parent);
    }



    private static OptionGroup makeFogGroup(String name,
                                            boolean defaultToggle, java.util.function.Supplier<Boolean> getToggle, java.util.function.Consumer<Boolean> setToggle,
                                            float defaultStart, java.util.function.Supplier<Float> getStart, java.util.function.Consumer<Float> setStart,
                                            float defaultEnd, java.util.function.Supplier<Float> getEnd, java.util.function.Consumer<Float> setEnd) {
        return OptionGroup.createBuilder()
                .name(Component.literal(name))
                .option(Option.<Boolean>createBuilder()
                        .name(Component.literal("Enable " + name))
                        .binding(defaultToggle, getToggle, setToggle)
                        .controller(TickBoxControllerBuilder::create)
                        .build())
                .option(Option.<Float>createBuilder()
                        .name(Component.literal(name + " Start"))
                        .binding(defaultStart, getStart, setStart)
                        .controller(FloatFieldControllerBuilder::create)
                        .build())
                .option(Option.<Float>createBuilder()
                        .name(Component.literal(name + " End"))
                        .binding(defaultEnd, getEnd, setEnd)
                        .controller(FloatFieldControllerBuilder::create)
                        .build())
                .build();
    }
}
