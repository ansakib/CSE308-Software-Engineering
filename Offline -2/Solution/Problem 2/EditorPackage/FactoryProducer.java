package EditorPackage;

public class FactoryProducer {
    public static FileFactory selectFactory(String filename){
        if(filename.toLowerCase().endsWith(".c")){
            return new CFactory();
        }
        else if(filename.toLowerCase().endsWith(".cpp")){
            return new CPPFactory();
        }
        else if(filename.toLowerCase().endsWith(".py")){
            return new PythonFactory();
        }
        else {
            return null;
        }
    }
}
