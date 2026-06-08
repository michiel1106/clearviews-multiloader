package bikerboys.clearviews.client.screen.components;

import net.minecraft.client.gui.*;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.*;
import net.minecraft.client.renderer.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.*;
import org.jspecify.annotations.*;

public abstract class AbstractConfigWidget extends AbstractWidget {
    Identifier image;

    public AbstractConfigWidget(int x, int y, int width, int height, Identifier image) {
        super(x, y, width, height, Component.empty());
        this.image = image;
    }

    @Override
    protected void extractWidgetRenderState(@NonNull GuiGraphicsExtractor graphics, int mouseX, int mouseY, float deltaTime) {

        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, image, getX(), getY(), getWidth(), getHeight());


    }

    @Override
    protected void updateWidgetNarration(@NonNull NarrationElementOutput output) {
    }

}
