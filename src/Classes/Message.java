package Classes;

public class Message {

    private int id;
    private final String sender;
    private String receiver;
    private String content;
    private String datetime;

    public Message(int id, String sender, String receiver, String content, String datetime) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.datetime = datetime;
    }

    public void sendMessage() {
        System.out.println("El mensaje ha sido enviado con éxito.");
    }

    public void deleteMessage() {
        System.out.println("El mensaje ha sido eliminado con éxito.");
    }  

    public void editMessage(String newContent) {
        System.out.println("El mensaje ha sido editado con éxito.");
        content = newContent;
    }

    public void getMessageType() {
        if (content.startsWith("http://") || content.startsWith("https://")) {
            System.out.println("El mensaje es un enlace.");
        } else if (content.startsWith("@")) {
            System.out.println("El mensaje es una mención.");
        } else {
            System.out.println("El mensaje es un texto normal.");
        }
    }       

    public String getSender(User user) {
        return sender;
    }
}