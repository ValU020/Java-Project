package Classes;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserStorage {
    private static final String FILE_PATH = "usuarios.json"; // archivo en la raíz del proyecto

    // Método para guardar un nuevo usuario
    public static void saveUser(String nombre, String correo, String contraseña) {
        JSONArray users = loadUsers(); // Cargar usuarios actuales

        // Crear objeto JSON del nuevo usuario
        JSONObject user = new JSONObject();
        user.put("nombre", nombre);
        user.put("correo", correo);
        user.put("contraseña", contraseña);

        users.put(user); // Agregarlo al arreglo

        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(users.toString(4)); // Guardar con indentación bonita
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar usuarios ya registrados
    public static JSONArray loadUsers() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            return new JSONArray(content);
        } catch (IOException e) {
            return new JSONArray(); // Si el archivo no existe, retorna uno vacío
        }
    }

    // Buscar usuario por correo
    public static JSONObject findUserByEmail(String correo) {
        JSONArray users = loadUsers();
        for (int i = 0; i < users.length(); i++) {
            JSONObject user = users.getJSONObject(i);
            if (user.getString("correo").equalsIgnoreCase(correo)) {
                return user;
            }
        }
        return null;
    }
}

