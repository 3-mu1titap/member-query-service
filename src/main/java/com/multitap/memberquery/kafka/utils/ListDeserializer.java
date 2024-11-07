package com.multitap.memberquery.kafka.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.List;

public class ListDeserializer<T> implements Deserializer<List<T>> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Class<T> elementType;

    public ListDeserializer(Class<T> elementType) {
        this.elementType = elementType;
    }

    @Override
    public List<T> deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, objectMapper.getTypeFactory().constructCollectionType(List.class, elementType));
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize list", e);
        }
    }
}
