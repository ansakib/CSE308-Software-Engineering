package EditorPackage;

import FontPackage.Font;
import ParserPackage.Parser;

public class Editor {
    private static Editor editor;

    private FileFactory sFactory;

    private Parser parser;
    private Font font;

    private Editor(){

    }

    public static Editor getInstance(){
        if(editor==null){
            editor = new Editor();
        }
        return editor;
    }

    public void createEditor(String filename){
        sFactory = FactoryProducer.selectFactory(filename);
        parser = sFactory.selectParser();
        parser.parserMethod();
        font = sFactory.selectFont();
        font.printSelectedFont();
    }
}
