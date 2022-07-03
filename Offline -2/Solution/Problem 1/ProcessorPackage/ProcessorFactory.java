package ProcessorPackage;

public class ProcessorFactory {
    public Processor getProcessor(String processorType){

        if(processorType.equalsIgnoreCase("atmega"))
        {
            return new ATMega();
        }
        else if(processorType.equalsIgnoreCase("arduinomega"))
        {
            return new ArduinoMega();
        }
        else if(processorType.equalsIgnoreCase("raspberrypi"))
        {
            return new RaspberryPi();
        }

        return null;
    }
}
