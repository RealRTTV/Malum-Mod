package com.sammy.malum.core.data.codex;

import com.google.gson.Gson;
import com.sammy.malum.core.data.codex.CodexEntryBuilder.CodexEntryResult;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

import static com.sammy.malum.MalumMod.LOGGER;

public final class MalumCodexEntries implements DataProvider {
    private final Gson gson;
    private final DataGenerator generator;
    private final PackType resourceType;
    private final String folder;
    private final Map<ResourceLocation, CodexEntryResult> entries;

    public MalumCodexEntries(Gson gson, DataGenerator generator, PackType resourceType, String folder, Map<ResourceLocation, CodexEntryResult> entries) {
        this.gson = gson;
        this.generator = generator;
        this.resourceType = resourceType;
        this.folder = folder;
        this.entries = entries;
    }

    @Override
    public void run(HashCache cache) {
        Path resourcesFolder = this.generator.getOutputFolder();
        this.entries.forEach((id, entryResult) -> {
            Path jsonLocation = resourcesFolder.resolve(String.join("/", this.resourceType.getDirectory(), id.getNamespace(), this.folder, id.getPath() + ".json"));
            try {
                DataProvider.save(this.gson, cache, entryResult.serializeEntry(), jsonLocation);
            } catch (IOException e) {
                LOGGER.error("{} {} provider failed to save {}", this.folder, this.resourceType.getDirectory(), jsonLocation, e);
            }
        });
    }

    @Override
    public String getName() {
        return String.format("%s %s provider", this.folder, this.resourceType.getDirectory());
    }
}