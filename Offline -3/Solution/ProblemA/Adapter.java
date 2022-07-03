import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Adapter extends SpaceSeperated{

    Adapter(File inputFile) throws IOException {
        super(inputFile);
        setFile(converter(inputFile));
    }

    @Override
    public void setFile(File inputFile) {
        super.setFile(inputFile);
    }

    private File converter(File inputFile) throws IOException {
        Path projectPath = Paths.get(System.getProperty("user.dir"));
        Path path = Paths.get(projectPath.toString(), "ConvertedInput.txt");
        File convFile = new File(path.toString());


        BufferedWriter bw = new BufferedWriter(new FileWriter(convFile));

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String s = br.readLine();
        String [] nums = s.split("~");

        for(int i = 0; i<nums.length; i++){
            int n = Integer.parseInt(nums[i]);
            bw.write(Integer.toString(n));
            bw.write(" ");
        }
        bw.close();
        return convFile;
    }
}
