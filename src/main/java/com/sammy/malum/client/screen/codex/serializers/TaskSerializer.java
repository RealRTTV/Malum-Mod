package com.sammy.malum.client.screen.codex.serializers;

import com.google.gson.JsonObject;
import com.sammy.malum.client.screen.codex.tasks.BookTask;
import net.minecraft.resources.ResourceLocation;

public abstract class TaskSerializer {

    abstract String getKey();

    abstract BookTask fromJson(ResourceLocation pRecipeId, JsonObject object);
}