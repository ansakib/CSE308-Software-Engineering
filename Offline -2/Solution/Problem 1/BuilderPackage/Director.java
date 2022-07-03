package BuilderPackage;

public class Director {
    private SystemBuilder myBuilder;
    private String commType;

    public void construct(SystemBuilder tempBuilder){
        myBuilder = tempBuilder;
        myBuilder.buildProcessor();
        myBuilder.buildDisplay();
        myBuilder.installApp();
        myBuilder.setCommChannel();
    }
}
