package com.goldenconsultingci.erp.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ObjectSerializer {

    private static ObjectMapper mapper = null;
    private static ObjectSerializer instance = null;

    private ObjectSerializer() {
        super();
        ObjectSerializer.mapper =
                new ObjectMapper()
                        .registerModule(new JavaTimeModule())
                        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                        .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                        .setVisibility(
                                VisibilityChecker
                                        .Std.defaultInstance()
                                        .withFieldVisibility(JsonAutoDetect.Visibility.ANY));
    }

    public static ObjectSerializer instance() {
        if (ObjectSerializer.instance == null) {
            synchronized (ObjectSerializer.class) {
                if (ObjectSerializer.instance == null) {
                    ObjectSerializer.instance = new ObjectSerializer();
                }
            }
        }

        return ObjectSerializer.instance;
    }

    public  String serialize(Object anObject) {
        try {
            return ObjectSerializer.mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(anObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends Object> T deserialize(String aJson, Class<T> aType) {
        try {
            T typedObject = ObjectSerializer.mapper.readValue(aJson, aType);
            return typedObject;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
