package GraderPackage;

public class Grader {

    Grader() {}
    private String getThreeCrGrade(int totalMark){

        if(totalMark<180)
            return "F";
        else if(totalMark<210)
            return "C";
        else if(totalMark<240)
            return "B";
        else
            return "A";
    }

    private String getFourCrGrade(int totalMark){
        if(totalMark<240)
            return "F";
        else if(totalMark<280)
            return "C";
        else if(totalMark<320)
            return "B";
        else
            return "A";
    }

    public String getGrade(String totalMarkString, int credit){
        float totalMarkFloat;
        try {
            totalMarkFloat = Float.parseFloat(totalMarkString);
            int totalMark = (int) Math.ceil(totalMarkFloat);

            //System.out.println(totalMark);
            if(totalMarkFloat<0)
                throw new IllegalArgumentException("Total Marks cannot be Negative!");
            else if(totalMarkFloat>400)
                throw new IllegalArgumentException("Total Marks cannot be more than 400 for a 3-credit Subject!");


            if(credit==3){
                return getThreeCrGrade(totalMark);
            }
            else{
                return getFourCrGrade(totalMark);
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Non-Number Input");
        }

    }
}
