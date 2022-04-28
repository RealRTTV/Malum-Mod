package com.sammy.malum.core.setup.client;

import com.sammy.malum.client.screen.codex.serializers.PageSerializer;
import com.sammy.malum.client.screen.codex.serializers.TaskSerializer;

import java.util.HashMap;

public class CodexRegistries {

    public static final HashMap<String, PageSerializer> PAGE_SERIALIZERS = new HashMap<>();
    public static final HashMap<String, TaskSerializer> TASK_SERIALIZERS = new HashMap<>();

    static PageSerializer registerObjectSerializer(String key, PageSerializer serializer) {
        return PAGE_SERIALIZERS.put(key, serializer);
    }

    static TaskSerializer registerObjectSerializer(String key, TaskSerializer serializer) {
        return TASK_SERIALIZERS.put(key, serializer);
    }
}