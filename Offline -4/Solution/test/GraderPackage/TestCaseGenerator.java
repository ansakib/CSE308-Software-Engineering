package GraderPackage;

import java.util.Random;

public class TestCaseGenerator {

    TestCaseGenerator(){}

    //normal mark for three credit
    public String threeGradeA(){
        return "280";
    }
    public String threeGradeB(){
        return "220";
    }
    public String threeGradeC(){
        return "200";
    }
    public String threeGradeF(){
        return "100";
    }

    //normal mark for four credit
    public String fourGradeA(){
        return "350";
    }
    public String fourGradeB(){
        return "300";
    }
    public String fourGradeC(){
        return "260";
    }
    public String fourGradeF(){
        return "200";
    }

    //Upper bound mark for three credit
    public String upThreeGradeA(){
        return "399.9";
    }
    public String upThreeGradeB(){
        return "238.9";
    }
    public String upThreeGradeC(){
        return "208.9";
    }
    public String upThreeGradeF(){
        return "178.9";
    }

    //lower bound mark for three credit
    public String downThreeGradeA(){
        return "239.1";
    }
    public String downThreeGradeB(){
        return "209.1";
    }
    public String downThreeGradeC(){
        return "179.1";
    }
    public String downThreeGradeF(){
        return "0";
    }

    //upper bound mark for four credit
    public String upFourGradeA(){
        return "399.9";
    }
    public String upFourGradeB(){
        return "318.9";
    }
    public String upFourGradeC(){
        return "278.9";
    }
    public String upFourGradeF(){
        return "238.9";
    }

    //lower bound mark for four credit
    public String downFourGradeA(){
        return "319.1";
    }
    public String downFourGradeB(){
        return "279.1";
    }
    public String downFourGradeC(){
        return "239.1";
    }
    public String downFourGradeF(){
        return "0";
    }

    public String downInvalidNumbers(){
        return "-0.1";
    }
    public String upInvalidNumbers(){
        return "400.1";
    }

    public String non_Number(){
        return "abc";
    }
}
