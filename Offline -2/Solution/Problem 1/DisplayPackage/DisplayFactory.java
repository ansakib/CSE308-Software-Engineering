package DisplayPackage;

public class DisplayFactory {
    public Display getDisplay(String displayType){
        if(displayType.equalsIgnoreCase("lcd")){
            return new LCDPanel();
        }
        else if(displayType.equalsIgnoreCase("led")){
            return new LEDMatrix();
        }
        return null;
    }
}
