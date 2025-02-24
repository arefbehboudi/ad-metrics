package org.aref.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> void writeToJsonFile(String file, List<T> data) throws Exception {
        FileOutputStream fout = new FileOutputStream(file);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(fout, data);
    }

}
