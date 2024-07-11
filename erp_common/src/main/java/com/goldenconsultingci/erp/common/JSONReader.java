package com.goldenconsultingci.erp.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONReader {
    private ObjectMapper mapper;
    private JsonNode rootNode;

    public JSONReader(String jsonString) {
        this.init(jsonString);
    }

    public String stringValue(String aKey) {
        if (this.rootNode.has(aKey)) {
            return this.rootNode.get(aKey).asText();
        }
        throw new IllegalArgumentException(aKey + "does not exists.");
    }

    private void init(String jsonString) {
        this.mapper =  new ObjectMapper();
        try {
            this.rootNode = this.mapper.readTree(jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
