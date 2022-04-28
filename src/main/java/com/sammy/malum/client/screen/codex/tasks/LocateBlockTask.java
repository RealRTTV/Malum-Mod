package com.sammy.malum.client.screen.codex.tasks;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;

public class LocateBlockTask extends BookTask {

    public LocateBlockTask(Block... blocks) {

    }
    public LocateBlockTask(TagKey<Block> tag) {

    }

    @Override
    public boolean canComplete(Player player) {
        return true;
    }
}
