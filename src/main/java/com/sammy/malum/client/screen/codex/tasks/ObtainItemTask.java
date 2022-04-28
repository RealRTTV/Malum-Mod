package com.sammy.malum.client.screen.codex.tasks;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

public class ObtainItemTask extends BookTask {

    public ObtainItemTask(Item... items) {

    }
    public ObtainItemTask(TagKey<Item> tag) {

    }

    @Override
    public boolean canComplete(Player player) {
        return true;
    }
}
