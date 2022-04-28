package com.sammy.malum.client.screen.codex.serializers;

import com.google.gson.JsonObject;
import com.sammy.malum.client.screen.codex.pages.BookPage;
import net.minecraft.resources.ResourceLocation;

public abstract class PageSerializer {

    abstract String getKey();

    abstract BookPage fromJson(ResourceLocation pRecipeId, JsonObject object);
}