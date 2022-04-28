package com.sammy.malum.client.screen.codex.tasks;

import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.List;

public class AnyTask extends BookTask {

    public final ArrayList<BookTask> tasks;
    public AnyTask(BookTask... tasks) {
        this.tasks = new ArrayList<>(List.of(tasks));
    }

    @Override
    public boolean canComplete(Player player) {
        return tasks.stream().anyMatch(t -> t.canComplete(player));
    }
}