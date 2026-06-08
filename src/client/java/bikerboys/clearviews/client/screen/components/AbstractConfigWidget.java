package bikerboys.clearviews.client.screen.components;

import net.fabricmc.loader.api.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.*;
import net.minecraft.client.input.*;
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
        int offset = 18;

        // background + image
        graphics.fill(getX() + getWidth(), getY() + getHeight() + 13, getX(), getY(), 0xBA_43_43_43);
        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, image, getX() + offset/2, getY() + offset/2 + 16, getWidth() - offset, getHeight() - offset);

        // scale the title and position it.
        graphics.pose().pushMatrix();
        float scale = 1.66f;
        graphics.pose().scale(scale, scale);
        graphics.text(Minecraft.getInstance().font, "TITLE TITLE", (int) (getX() / scale + 5), (int) ((getY() + 5) / scale), 0xFFFFFFFF);
        graphics.pose().popMatrix();

        // line between bottom of text and top of image.
        graphics.horizontalLine(getX(), getX() + getWidth() - 1, getY() + 20, 0xFFFFFFFF);


        // borders around the entire widget.
        graphics.outline(getX(), getY(), getWidth(), getHeight() + 13, 0xFF696969);


    }

    @Override
    protected void updateWidgetNarration(@NonNull NarrationElementOutput output) {
    }

    @Override
    public boolean mouseDragged(MouseButtonEvent event, double dx, double dy) {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            if (isHovered) {
                setX((int) event.x());
                setY((int) event.y());
            }
        }

        return super.mouseDragged(event, dx, dy);
    }
}
