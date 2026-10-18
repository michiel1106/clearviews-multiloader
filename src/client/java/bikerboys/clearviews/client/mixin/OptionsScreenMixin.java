package bikerboys.clearviews.client.mixin;

import bikerboys.clearviews.*;
import bikerboys.clearviews.client.config.*;
import bikerboys.clearviews.client.screen.*;
import com.llamalad7.mixinextras.sugar.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.layouts.*;
import net.minecraft.client.gui.screens.*;
import net.minecraft.client.gui.screens.options.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.rule.blockentity.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

import java.util.function.*;

@Mixin(OptionsScreen.class)
public abstract class OptionsScreenMixin {

    @Unique
    private static final int CLEARVIEWS_BUTTON_SIZE = 20;

    @Shadow
    protected abstract Button openScreenButton(Component message, Supplier<Screen> screenToScreen);

    @Inject(
            method = "init",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/layouts/LinearLayout;addChild(Lnet/minecraft/client/gui/layouts/LayoutElement;)Lnet/minecraft/client/gui/layouts/LayoutElement;",
                    ordinal = 1,
                    shift = At.Shift.BEFORE
            )
    )
    private void clearviews$addLeftSpacer(CallbackInfo ci, @Local(name = "subHeader") LinearLayout subHeader) {
        subHeader.addChild(new SpacerElement(CLEARVIEWS_BUTTON_SIZE, CLEARVIEWS_BUTTON_SIZE));
    }

    @Inject(
            method = "init",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/layouts/HeaderAndFooterLayout;addToContents(Lnet/minecraft/client/gui/layouts/LayoutElement;)Lnet/minecraft/client/gui/layouts/LayoutElement;",
                    shift = At.Shift.BEFORE
            )
    )
    private void clearviews$addButton(CallbackInfo ci, @Local(name = "subHeader") LinearLayout subHeader) {
        Screen screen = (Screen) (Object) this;

        Button button = new ClearviewsButton(CLEARVIEWS_BUTTON_SIZE, (press) -> Minecraft.getInstance().setScreenAndShow(ClearviewsConfig.configScreen(screen)));
        button.setWidth(CLEARVIEWS_BUTTON_SIZE);
        button.setTooltip(Tooltip.create(Component.literal("Clearviews")));

        subHeader.addChild(button);
    }
}

