import java.io.*;

public class Calculate {
    public void calculateSum(SpaceSeperated inputFile) throws IOException {
        File file = inputFile.getFile();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = br.readLine();
        String [] nums = s.split(" ");
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += Integer.parseInt(nums[i]);
        }

        System.out.println("Sum: "+ sum);
    }
}
