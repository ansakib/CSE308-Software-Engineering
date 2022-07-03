package EditorPackage;

import FontPackage.Font;
import ParserPackage.Parser;

public interface FileFactory {
    public Parser selectParser();
    public Font selectFont();
}
