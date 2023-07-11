package com.miribit.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JsonMapper {
    static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public static <T> String convert(T t) {
        String s = "";
        try {
            s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(t);
        } catch (JsonProcessingException e) {
            log.error("", s);
        }
        return s;
    }

    public static <T> List<String> convert(List<T> t) {
        List<String> list = new ArrayList<>();
        for (T t1 : t) {
            String convert = convert(t1);
            list.add(convert);
        }
        return list;
    }

    public static <T> T convert(String str, Class<T> valueType) {
        T result = null;
        try {
            result = mapper.readValue(str, valueType);
        } catch (JsonProcessingException e) {
            log.error("", e);
        }
        return result;
    }
}
