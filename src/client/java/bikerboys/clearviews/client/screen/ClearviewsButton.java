package bikerboys.clearviews.client.screen;

import bikerboys.clearviews.Clearviews;
import bikerboys.clearviews.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.components.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.*;
import org.jspecify.annotations.*;

public class ClearviewsButton extends SpriteIconButton.CenteredIcon {
    private static final Component MESSAGE = Component.translatable("gui.friends.open");
    private static final Button.CreateNarration NARRATION = var0 -> Component.literal("Clearviews Configuration Screen");

    public ClearviewsButton(int width, OnPress onPress) {
        super(
                width,
                20,
                MESSAGE,
                16,
                16,
                0,
                0,
                new WidgetSprites(Identifier.fromNamespaceAndPath(Clearviews.MOD_ID, "icon")),
                onPress,
                null,
                NARRATION,
                false
        );
    }

    @Override
    protected void extractSprite(GuiGraphicsExtractor graphics, int x, int y) {
        super.extractSprite(graphics, x, y);
    }

    @Override
    protected void extractDefaultLabel(ActiveTextCollector output) {
        super.extractDefaultLabel(output);
    }

    @Override
    public void extractContents(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractContents(graphics, mouseX, mouseY, a);
    }
}
