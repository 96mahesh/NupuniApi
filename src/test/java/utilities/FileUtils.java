package utilities;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;

import models.User;
import exceptions.CustomExceptions;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {

	public static String readJson(String pathToFileFromResources) {
        try {
            return new String(Files.readAllBytes(Paths.get(Constants.pathToResources + pathToFileFromResources)));
        } catch (IOException e) {
            throw new CustomExceptions("Exception occurred during json read: " + e.getMessage());
        }
    }

    public static Object getObject(String response, TypeReference<?> c) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response, c);
        } catch (IOException e) {
            throw new CustomExceptions("Exception occurred during object mapping: " + e.getMessage());
        }
    }

    public static List<User> getUsers() {

        List<User> userList = (List<User>)getObject(readJson("users.json"),new TypeReference<List<User>>() {});

        return userList;
    }
    
    public static List<User> getMultiuserUsers() {

        List<User> userList = (List<User>)getObject(readJson("user.json"),new TypeReference<List<User>>() {});

        return userList;
    }



}

