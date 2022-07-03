package BuilderPackage;

import CommunicationPackage.CommFactory;
import DisplayPackage.DisplayFactory;
import ProcessorPackage.ProcessorFactory;
import SystemPackage.*;

public class OptimalBuilder implements SystemBuilder{

    private QMSystem qmSystem ;

    private String connectionType;

    private int displayUnitCount;
    public OptimalBuilder(String connectionType, int displayUnitCount)
    {
        qmSystem = new QMSystem();
        setConnectionType(connectionType);
        qmSystem.setDisplayUnitCount(displayUnitCount);
    }

    @Override
    public void buildProcessor() {
        ProcessorFactory processorFactory = new ProcessorFactory();
        Components processor = processorFactory.getProcessor("arduinomega");
        qmSystem.addComp(processor);
    }

    @Override
    public void buildDisplay() {
        DisplayFactory displayFactory = new DisplayFactory();
        Components display = displayFactory.getDisplay("led");
        qmSystem.addComp(display);
    }

    @Override
    public void installApp() {
        Components application = new Application();
        qmSystem.addComp(application);
    }

    @Override
    public void setCommChannel() {
        CommFactory commFactory = new CommFactory();
        Components commCH = commFactory.getCommChannel(connectionType);
        qmSystem.addComp(commCH);
    }

    @Override
    public void setConnectionType(String commType) {
        connectionType = commType;
    }




    @Override
    public QMSystem getSystem() {
        return qmSystem;
    }
}
