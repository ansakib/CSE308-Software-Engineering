package CommunicationPackage;

public class CommFactory {
    public CommunicationChannel getCommChannel(String commType){
        if(commType.equalsIgnoreCase("wifi")){
            return new WiFi();
        }
        else if(commType.equalsIgnoreCase("sim")){
            return new Sim();
        }
        else{
            return null;
        }
    }
}
