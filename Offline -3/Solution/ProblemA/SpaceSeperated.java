import java.io.File;

public class SpaceSeperated {
    private File file;

    SpaceSeperated(File inputFile){
        this.file = inputFile;
    }

    public void setFile(File inputFile){
        this.file = inputFile;
    }

    public File getFile(){
        return file;
    }
}
