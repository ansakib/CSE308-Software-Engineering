package EditorPackage;

import FontPackage.*;
import ParserPackage.*;

public class CFactory implements FileFactory{
    @Override
    public Parser selectParser() {
        return new CParser();
    }

    @Override
    public Font selectFont() {
        return new CourierNew();
    }
}
