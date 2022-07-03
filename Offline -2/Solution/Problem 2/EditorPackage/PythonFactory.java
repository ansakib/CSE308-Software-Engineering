package EditorPackage;

import FontPackage.*;
import ParserPackage.*;

public class PythonFactory implements FileFactory{
    @Override
    public Parser selectParser() {
        return new PythonParser();
    }

    @Override
    public Font selectFont() {
        return new Consolas();
    }
}
