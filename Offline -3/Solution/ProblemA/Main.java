import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Path projectPath = Paths.get(System.getProperty("user.dir"));
        Path path = Paths.get(projectPath.toString(), "input.txt");
        File inpFile = new File(path.toString());

        System.out.println("Choose Option No:");
        System.out.println("1. Space Seperated Integer");
        System.out.println("2. Tilde(~) Seperated Integer");

        SpaceSeperated spaceSeperated = null;

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        if(option==1){
            spaceSeperated = new SpaceSeperated(inpFile);
        }
        else if(option==2){
            spaceSeperated = new Adapter(inpFile);
        }

        Calculate calculate = new Calculate();
        calculate.calculateSum(spaceSeperated);
    }
}