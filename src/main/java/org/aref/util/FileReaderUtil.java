package org.aref.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aref.model.Click;
import org.aref.model.Impression;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class FileReaderUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Impression> readImpressions(String file) throws Exception {
        return objectMapper.readValue(getInputStream(file), new TypeReference<List<Impression>>() {});
    }

    public static List<Click> readClicks(String file) throws Exception {
        return objectMapper.readValue(getInputStream(file), new TypeReference<List<Click>>() {});
    }

    private static InputStream getInputStream(String file) throws FileNotFoundException {
        InputStream inputStream = FileReaderUtil.class.getClassLoader().getResourceAsStream(file);
        if (inputStream == null) {
            throw new FileNotFoundException("File not found in resources: impressions.json");
        }
        return inputStream;
    }

}
