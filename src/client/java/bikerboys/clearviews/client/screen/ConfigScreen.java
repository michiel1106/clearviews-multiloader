package bikerboys.clearviews.client.screen;

import bikerboys.clearviews.client.screen.components.*;
import net.minecraft.client.gui.screens.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.*;

public class ConfigScreen extends Screen {


    public ConfigScreen() {
        super(Component.empty());
    }

    @Override
    protected void init() {
        super.init();
        addRenderableWidget(new AbstractConfigWidget(width/2 - 150, height/2 + 100, 150, 100, Identifier.fromNamespaceAndPath("clearviews", "hud/unknown_pack")) {


        });
    }
}
