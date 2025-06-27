package Classes;

public class File {

    private String id;
    private String name;
    private String type;
    private String size;

    public File(String id, String name,String type, String size) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public void uploadFile() {
        System.out.println("El archivo " + name + " ha sido subido con éxito.");
    }

    public void downloadFile() {
        System.out.println("El archivo " + name + " ha sido descargado con exito.");
    }

    public void deleteFile() {
        System.out.println("El archivo " + name + " ha sido eliminado con éxito.");
    }

    public void renameFile(String newName) {
        System.out.println("El archivo " + name + " ha sido renombrado con éxito.");
        name = newName;
    }
}    