package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.egit.github.core.client.GsonUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

public class JSONLoader {

    public static JsonNode getJSONMessage(File input) {
        try {
            return new ObjectMapper().readTree(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T jsonToGson(File input, Class<T> clazz) {
        try {
            return GsonUtils.fromJson(new FileReader(input), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T jsonToGson(File input, Type clazz) {
        try {
            return GsonUtils.fromJson(new FileReader(input), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
