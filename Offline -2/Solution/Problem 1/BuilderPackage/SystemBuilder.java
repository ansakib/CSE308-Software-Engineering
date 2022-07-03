package BuilderPackage;

import SystemPackage.QMSystem;

public interface SystemBuilder {
    void buildProcessor();
    void buildDisplay();
    void installApp();
    void setCommChannel();

    void setConnectionType(String commType);



    QMSystem getSystem();
}
