package Classes;

public class Call {

    private String callid;
    private String duration;
    private String startTime;
    private String endTime;
    private String caller;
    private String receiver;

    public Call(String callid, String duration, String startTime, String endTime, String caller, String receiver) {
        this.callid = callid;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.caller = caller;
        this.receiver = receiver;
    }

    public void startCall() {
        System.out.println("La llamada ha comenzado entre " + caller + " y " + receiver + ".");
    }
    
    public void endCall() {
        System.out.println("La llamada ha terminado entre " + caller + " y " + receiver + ".");
    }

    public void calculateDuration() {
        System.out.println("La duración de la llamada es: " + duration);
    }

    public void getCallDuration() {
        System.out.println("La duración de la llamada es: " + duration);
    }

    


}
