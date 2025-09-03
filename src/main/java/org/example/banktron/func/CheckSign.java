package org.example.banktron.func;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CheckSign {

    private final String FILE_NAME = "banktron.json";
    private boolean flag;

    public boolean signIn(String username, String password) {

        List<User> users;
        try {
            String data_file = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            users = new Gson().fromJson(data_file, new TypeToken<List<User>>(){}.getType());
            if (users == null) users = new ArrayList<>();
            for (User user : users) {
                if (user.getName().equals(username) && user.getPassword().equals(password)) {
                    flag = true;
                    break;
                }
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public boolean signUp(String username, String password) {
        List<User> users;
        try {
            String data_file = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            users = new Gson().fromJson(data_file, new TypeToken<List<User>>(){}.getType());
            if (users == null) users = new ArrayList<>();
            for (User user : users) {
                if (user.getName().equals(username)) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
            if (flag) {
                users.add(new User(username, password, 0));
                String json = new Gson().toJson(users);
                Files.write(Paths.get(FILE_NAME), json.getBytes());
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
