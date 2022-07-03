import java.util.Scanner;

public class Main {

    private static int clockYear = 0;

    static int getClockYear(){
        return clockYear;
    }
    static void incrementClockYear(int yearInc){
        clockYear += yearInc;
        Processor.HappyNewYear();
        System.out.println(yearInc+"year passed");
    }

    public static void main(String[] args) {

        Processor bank = new Processor();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String operation = sc.nextLine().replaceAll("\\s+", " ");
            String[] spOperation = operation.split(" ");
            if(spOperation[0].toLowerCase().equals("create")){
                String acName = spOperation[1];
                String acType = spOperation[2];
                double initDeposit = Double.parseDouble(spOperation[3]);
                //System.out.println(acName + acType + initDeposit);
                boolean confirmation = Accounts.createAc(acName, acType, initDeposit);
                if (confirmation==false){
                    System.out.println("Account creation failed!!");
                }
                else{
                    Accounts currenAC = Processor.loginToAc(acName);
                    //System.out.println("Loan balance:"+currenAC.getTotalLoan());
                    loggedInAcOptions(currenAC);
                }
            }
            else if(spOperation[0].toLowerCase().equals("open")){
                String name = spOperation[1];
                Accounts currenAC = Processor.loginToAc(name);
                Employee emp = Processor.empLogin(name);
                //System.out.println("Loan balance:"+currenAC.getTotalLoan());
                if(currenAC!=null){
                    System.out.println("Welcome back, "+currenAC.getAcName());
                    loggedInAcOptions(currenAC);
                }
                else if(emp!=null){
                    if(Processor.checkLoanPending()){
                        System.out.println(emp.getEmpName()+" active, there are loan approvals pending");
                    }
                    else{
                        System.out.println(emp.getEmpName()+" active.");
                    }
                    employeeOptions(emp);
                }
                else{
                    System.out.println("Account Not Found!");
                }
            }
            else if(spOperation[0].toLowerCase().equals("inc")){
                incrementClockYear(1);
            }
            else if(spOperation[0].toLowerCase().equals("show")){
                Processor.showAccountList();
            }
        }
    }

     static void loggedInAcOptions(Accounts currentAc){
        //System.out.println(currentAc.getAcName()+" is logged in");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String operations = sc.nextLine().replaceAll("\\s+", " ");
            String[] sOperations = operations.split(" ");
            if (sOperations[0].toLowerCase().equals("close")){
                System.out.println("Transaction Closed for "+currentAc.getAcName());
                break;
            }
            else if(sOperations[0].toLowerCase().equals("deposit")){
                double depositAmnt = Double.parseDouble(sOperations[1]);
                currentAc.deposit(depositAmnt);
            }
            else if(sOperations[0].toLowerCase().equals("withdraw")){
                double amount = Double.parseDouble(sOperations[1]);
                currentAc.withdraw(amount);
            }
            else if(sOperations[0].toLowerCase().equals("request")){
                double reqLoanAmount = Double.parseDouble(sOperations[1]);
                currentAc.reqLoan(reqLoanAmount);
            }
            else if(sOperations[0].toLowerCase().equals("query")){
                currentAc.Query();
            }
        }
    }

    static void employeeOptions(Employee currentEmp){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String operations = sc.nextLine().replaceAll("\\s+", " ");
            String[] sOperations = operations.split(" ");
            if (sOperations[0].toLowerCase().equals("close")){
                System.out.println("Operations Closed for "+currentEmp.getEmpName());
                break;
            }
            else if(operations.toLowerCase().equals("approve loan")){
                currentEmp.approveLoan();
            }
            else if (sOperations[0].toLowerCase().equals("lookup")){
                String name = sOperations[1];
                currentEmp.lookUp(name);
            }
            else if (sOperations[0].toLowerCase().equals("change")){
                String acType = sOperations[1];
                double newRate = (Double.parseDouble(sOperations[2]))/100;
                currentEmp.changeInterest(acType,newRate);
            }
            else if (sOperations[0].toLowerCase().equals("see")){
                currentEmp.seeInternalFund();
            }
        }
    }
}