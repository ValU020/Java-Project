package Classes;

public class User {

    private final int id;
    private String name;
    private String email;
    private String password;
    public String profilePicture;
    public String message;
	
	public User(int id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
    
    
    }
	
	public void register() {
        System.out.println("El usuario " + name + " ha sido registrado con éxito.");
    }
    
    public boolean login(String email, String password) {
        if (this.email.equals(email) && this.password.equals(password)) {
            System.out.println("Inicio de sesión exitoso para " + name);
            return true;
        } else {
            System.out.println("Error de inicio de sesión. Correo electrónico o contraseña incorrectos.");
            return false;
        }
    }

    public void logout() {
        System.out.println("El usuario " + name + " ha cerrado sesión.");
    }

    public void editProfile(String newName, String newEmail, String newPassword) {
        System.out.println("Editando perfil de usuario " + name);
        name = newName;
        email = newEmail;
        password = newPassword;
    }

    public void changePassword(String newPassword) {
        System.out.println("Cambiando contraseña de usuario " + name);
        password = newPassword;
    }

    public void changeEmail(String newEmail) {
        System.out.println("Cambiando correo electrónico de usuario " + name);
        email = newEmail;
    }

    public void changeName(String newName) {
        System.out.println("Cambiando nombre de usuario " + name);
        name = newName;
    }

    public void sendMessage(String message) {
        System.out.println(name + " ha enviado un mensaje: " + message);
    }

    public void uploadFile(String filePath) {
        System.out.println(name + " ha subido un archivo desde: " + filePath);
    }
}