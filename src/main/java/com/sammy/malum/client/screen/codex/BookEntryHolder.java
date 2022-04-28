package com.sammy.malum.client.screen.codex;

import com.sammy.malum.client.screen.codex.objects.BookObject;

import java.util.function.Supplier;

import static com.sammy.malum.client.screen.codex.ProgressionBookScreen.ENTRIES;
import static com.sammy.malum.client.screen.codex.ProgressionBookScreen.HOLDERS;

public class BookEntryHolder {
    private final Supplier<BookEntry> entrySupplier;
    private BookEntry entry;
    private BookObject object;
    public BookEntryHolder(Supplier<BookEntry> entrySupplier) {
        this.entrySupplier = entrySupplier;
        HOLDERS.add(this);
    }

    public void setupEntry() {
        entry = entrySupplier.get();
        ENTRIES.put(entry.identifier, entry);
    }

    public BookEntry getEntry() {
        return entry;
    }

    public void setObject(BookObject object) {
        this.object = object;
    }
    public BookObject getObject() {
        return object;
    }
}