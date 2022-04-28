package com.sammy.malum.client.screen.codex.pages;

import com.mojang.blaze3d.vertex.PoseStack;
import com.sammy.malum.client.screen.codex.ProgressionBookScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.sammy.malum.client.screen.codex.EntryScreen.screen;

public class BookPage {
    public final ResourceLocation background;

    public BookPage(ResourceLocation background) {
        this.background = background;
    }

    public boolean isValid() {
        return true;
    }

    @OnlyIn(value = Dist.CLIENT)
    public void renderLeft(Minecraft minecraft, PoseStack poseStack, float xOffset, float yOffset, int mouseX, int mouseY, float partialTicks) {

    }

    @OnlyIn(value = Dist.CLIENT)
    public void renderRight(Minecraft minecraft, PoseStack poseStack, float xOffset, float yOffset, int mouseX, int mouseY, float partialTicks) {

    }

    @OnlyIn(value = Dist.CLIENT)
    public void renderBackgroundLeft(Minecraft minecraft, PoseStack poseStack, float xOffset, float yOffset, int mouseX, int mouseY, float partialTicks) {
        int guiLeft = guiLeft();
        int guiTop = guiTop();
        ProgressionBookScreen.renderTexture(background, poseStack, guiLeft, guiTop, 1, 1, screen.bookWidth - 147, screen.bookHeight, 512, 512);
    }

    @OnlyIn(value = Dist.CLIENT)
    public void renderBackgroundRight(Minecraft minecraft, PoseStack poseStack, float xOffset, float yOffset, int mouseX, int mouseY, float partialTicks) {
        int guiLeft = guiLeft();
        int guiTop = guiTop();
        ProgressionBookScreen.renderTexture(background, poseStack, guiLeft + 147, guiTop, 148, 1, screen.bookWidth - 147, screen.bookHeight, 512, 512);
    }

    @OnlyIn(value = Dist.CLIENT)
    public int guiLeft() {
        return (screen.width - screen.bookWidth) / 2;
    }

    @OnlyIn(value = Dist.CLIENT)
    public int guiTop() {
        return (screen.height - screen.bookHeight) / 2;
    }
}