package com.sammy.malum.client.screen.codex;

import com.sammy.malum.client.screen.codex.objects.EntryObject;
import com.sammy.malum.client.screen.codex.pages.BookPage;
import com.sammy.malum.client.screen.codex.tasks.BookTask;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.sammy.malum.client.screen.codex.ProgressionBookScreen.ENTRIES;

public class BookEntry {
    public final ItemStack iconStack;
    public final String identifier;
    public final int xOffset;
    public final int yOffset;
    public HashMap<String, BookPage> pages = new HashMap<>();
    public HashMap<String, BookTask> tasks = new HashMap<>();
    public ArrayList<BookEntryState> states = new ArrayList<>();

    public EntryObjectSupplier objectSupplier = EntryObject::new;

    private final ArrayList<Supplier<BookEntry>> relatedEntrySuppliers = new ArrayList<>();
    private final ArrayList<BookEntry> relatedEntries = new ArrayList<>();

    public BookEntry(String identifier, Item item, int xOffset, int yOffset) {
        this.iconStack = item.getDefaultInstance();
        this.identifier = identifier;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public String translationKey() {
        return "malum.gui.book.entry." + identifier;
    }

    public String descriptionTranslationKey() {
        return "malum.gui.book.entry." + identifier + ".description";
    }

    @Deprecated
    public BookEntry addPage(BookPage page) {
        return this;
    }

    public BookEntry addTask(String id, BookTask task) {
        tasks.put(id, task);
        return this;
    }

    public BookEntry addPage(String id, BookPage page) {
        pages.put(id, page);
        return this;
    }

    public BookEntry addPage(String id, Function<String, BookPage> page) {
        pages.put(id, page.apply(id));
        return this;
    }

    public BookEntry addPages(String id, Function<String, BookPage>... pages) {
        for (int i = 0, pagesLength = pages.length; i < pagesLength; i++) {
            String pageId = id + "_" + i;
            this.pages.put(pageId, pages[i].apply(pageId));
        }
        return this;
    }

    public BookEntry addState(BookEntryState state) {
        this.states.add(state);
        return this;
    }

    public BookEntry addRelatedEntry(String identifier) {
        return addRelatedEntry(() -> ENTRIES.get(identifier));
    }

    public BookEntry addRelatedEntry(Supplier<BookEntry> supplier) {
        relatedEntrySuppliers.add(supplier);
        return this;
    }

    public BookEntry cacheRelatedEntries() {
        relatedEntrySuppliers.forEach(s -> relatedEntries.add(s.get()));
        return this;
    }

    public BookEntry addModCompatPage(BookPage page, String modId) {
        return this;
    }

    public BookEntry setObjectSupplier(EntryObjectSupplier objectSupplier) {
        this.objectSupplier = objectSupplier;
        return this;
    }

    public static class BookEntryState {
        public final String stateId;
        public final ArrayList<String> pages = new ArrayList<>();
        public final ArrayList<String> tasks = new ArrayList<>();

        public BookEntryState(String stateId) {
            this.stateId = stateId;
        }

        public BookEntryState addPages(String... pages) {
            this.pages.addAll(List.of(pages));
            return this;
        }

        public BookEntryState addTasks(String... tasks) {
            this.tasks.addAll(List.of(tasks));
            return this;
        }
    }

    public interface EntryObjectSupplier {
        EntryObject getBookObject(BookEntry entry, int x, int y);
    }
}