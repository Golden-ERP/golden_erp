package com.goldenconsultingci.erp.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.function.Function;
import java.util.function.Supplier;


public interface JSONReader2 {
    String get();
    public static JSONReader2 create(String jsonString, String aKey, Function<String, JsonNode> mapper2) {
        return () -> {
            JsonNode node = mapper2.apply(jsonString);
            return stringValue(aKey, node);
        };
    }

    private static String stringValue(String aKey, JsonNode node) {
        if (node.has(aKey)) {
            return node.get(aKey).asText();
        }
        throw new IllegalArgumentException(aKey + "does not exists.");
    }
}
