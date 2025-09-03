package org.example.banktron.func;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CheckSign {

    private final String FILE_NAME = "banktron.json";

    public boolean signIn(String username, String password) {
        if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {
            return false;
        }

        List<User> users = loadUsers();

        for (User user : users) {
            if (user.getName().equals(username.trim()) &&
                    user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean signUp(String username, String password) throws Exception {
        if (username == null || username.trim().isEmpty()) {
            throw new Exception("Kullanıcı adı boş olamaz!");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new Exception("Şifre boş olamaz!");
        }
        if (password.length() < 4) {
            throw new Exception("Şifre en az 4 karakter olmalıdır!");
        }

        username = username.trim();
        List<User> users = loadUsers();

        for (User user : users) {
            if (user.getName().equals(username)) {
                throw new Exception("Bu kullanıcı adı zaten mevcut!");
            }
        }

        users.add(new User(username, password, 0));
        saveUsers(users);
        return true;
    }

    private List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return users;
        }

        try {
            String data_file = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            if (!data_file.trim().isEmpty()) {
                users = new Gson().fromJson(data_file, new TypeToken<List<User>>(){}.getType());
                if (users == null) {
                    users = new ArrayList<>();
                }
            }
        } catch (Exception e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
            users = new ArrayList<>();
        }
        return users;
    }

    private void saveUsers(List<User> users) throws Exception {
        try {
            String json = new Gson().toJson(users);
            Files.write(Paths.get(FILE_NAME), json.getBytes());
        } catch (Exception e) {
            throw new Exception("Dosya okuma hatası " + e.getMessage());
        }
    }
}
