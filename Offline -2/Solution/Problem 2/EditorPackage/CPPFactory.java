package EditorPackage;

import FontPackage.*;
import ParserPackage.*;

public class CPPFactory implements FileFactory{
    @Override
    public Parser selectParser() {
        return new CPP_Parser();
    }

    @Override
    public Font selectFont() {
        return new Monaco();
    }
}
