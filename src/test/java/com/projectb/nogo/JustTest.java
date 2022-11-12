package com.projectb.nogo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class JustTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void objectToJsonString() throws JsonProcessingException {
        User user = new User("donpark", 30);
        String userJson = objectMapper.writeValueAsString(user);
        System.out.println("userJson = " + userJson);
    }

    @Test
    void objectToJsonFile() throws IOException {
        User user = new User("donpark", 30);
        objectMapper.writeValue(new File("user.json"), user);
    }

    @Test
    void jsonStrToObject() throws JsonProcessingException {
        String jsonStr = "{\"name\":\"donpark\",\"age\":30}";
        User user = objectMapper.readValue(jsonStr, User.class);
    }

    @Test
    void jsonFileToObject() throws IOException {
        User user = objectMapper.readValue(new File("user.json"), User.class);
        System.out.println("user = " + user);
    }

    @Test
    void jsonUrlToObject() throws IOException {
        User user = objectMapper.readValue(new URL("file:user.json"), User.class);
    }

    @Test
    void jsonArrToObjArr() throws JsonProcessingException {
//        {"name":"donpark","age":30},{"name":"joonpark","age":28}
        String jsonArr = "[{\"name\":\"donpark\",\"age\":30},{\"name\":\"joonpark\",\"age\":28}]";
        List<User> userList = objectMapper.readValue(jsonArr, new TypeReference<>(){});
        for (User user : userList) {
            System.out.println("user = " + user);
        }
//        Map<Integer, User> userData = new HashMap<>();
//        userData.put(1, new User("donpark", 30));
//        userData.put(2, new User("joonpark", 28));
//        String jsonMap = objectMapper.writeValueAsString(userData);
//        System.out.println("jsonMap = " + jsonMap);
        String jsonMap = "{\"1\":{\"name\":\"donpark\",\"age\":30}," +
                          "\"2\":{\"name\":\"joonpark\",\"age\":28}}";
        Map<Integer, User> userMap = objectMapper.readValue(jsonMap, new TypeReference<>(){});
        for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
            System.out.println("entry.getKey() = " + entry.getKey());
            System.out.println("entry.getValue().getName() = " + entry.getValue().getName());
            System.out.println("entry.getValue().getAge() = " + entry.getValue().getAge());
        }
    }

    @Getter
    @Setter
    @ToString
    static class User {
        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
