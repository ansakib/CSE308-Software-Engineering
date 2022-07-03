package ParserPackage;

public class PythonParser implements Parser{
    public PythonParser(){
        System.out.println("Parser For Python created");
    }

    @Override
    public void parserMethod() {
        System.out.println("Running Parsing Method using Python Parser");
    }
}
