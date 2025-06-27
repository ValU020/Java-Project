package Classes;

public class channel {

    public String channelName;
    private String privacyTipe;

    public channel(String channelName, String privacyTipe) {
        this.channelName = channelName;
        this.privacyTipe = privacyTipe;
    }

    public void createChannel() {
        System.out.println("El canal " + channelName + " ha sido creado con éxito.");
    }

    public void deleteChannel() {
        System.out.println("El canal " + channelName + " ha sido eliminado con éxito.");
    }

    public void editChannel(String newChannelName) {
        System.out.println("El canal " + channelName + " ha sido editado con éxito.");
        channelName = newChannelName;
    }

    public void changePrivacy(String newPrivacyTipe) {
        System.out.println("La privacidad del canal " + channelName + " ha sido cambiada con éxito.");
        privacyTipe = newPrivacyTipe;
    }

    
}