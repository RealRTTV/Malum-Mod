package com.sammy.malum.client.screen.codex.tasks;

import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.List;

public class AllTask extends BookTask {

    public final ArrayList<BookTask> tasks;
    public AllTask(BookTask... tasks) {
        this.tasks = new ArrayList<>(List.of(tasks));
    }

    @Override
    public boolean canComplete(Player player) {
        return tasks.stream().allMatch(t -> t.canComplete(player));
    }
}