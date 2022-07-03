import java.util.ArrayList;

public class Processor {
    private static ArrayList<Accounts> accountsList = new ArrayList<>();
    private static ArrayList<Employee> employeesList = new ArrayList<>();

    private static double internalFund;

    Processor(){
        internalFund = 1000000;

        Employee.createEmployee("MD", "md");
        for (int i = 0; i < 2; i++) {
            String name = "S"+(i+1);
            Employee.createEmployee(name, "officer");
        }
        for (int i = 0; i < 5; i++) {
            String name = "C"+(i+1);
            Employee.createEmployee(name, "cashier");
        }
        System.out.println("Bank Created; MD, S1, S2, C1, C2, C3, C4, C5 created");
        //showEmpList();
    }

    public static void updateInternalFund(double newInternalFund){
        internalFund = newInternalFund;
    }

    public static double getInternalFund() {
        return internalFund;
    }

    public static void addBankAc(Accounts newAc){
        accountsList.add(newAc);
    }

    public static void addBankEmployee(Employee newEmp){
        employeesList.add(newEmp);
    }

    public static ArrayList<Accounts> getAccountsList() {
        return accountsList;
    }

    public static ArrayList<Employee> getEmployeesList() {
        return employeesList;
    }

    public static void showAccountList(){
        for(Accounts ac : accountsList){
            System.out.println(ac.getAcName()+" "+ac.getAcType()+" "+ac.getTotalBalance()+" "+ac.getTotalLoan());
        }
    }
    public static void showEmpList(){
        for(Employee emp : employeesList){
            System.out.println(emp.getEmpName());
        }
    }
    public static boolean checkAcExist(String acName){
        for(Accounts ac : accountsList){
            if(ac.getAcName().toLowerCase().equals(acName)){
                return true;
            }
        }
        return false;
    }

    static boolean checkLoanPending(){
        for(Accounts ac : accountsList){
            if (ac.getLoanRequested()>0){
                return true;
            }
        }
        return false;
    }
    public static Accounts loginToAc(String acName){
        for(Accounts ac : accountsList){
            if(ac.getAcName().equalsIgnoreCase(acName)){
                return ac;
            }
        }
        return null;
    }

    public static Employee empLogin(String empName){
        for(Employee emp : employeesList){
            if(emp.getEmpName().equalsIgnoreCase(empName)){
                return emp;
            }
        }
        return null;
    }

    public static void HappyNewYear(){
        //give yearly interest to account
        for(Accounts ac : accountsList){
            double amount = ac.getTotalBalance();
            double loanAmount = ac.getTotalLoan();
            double interest = (amount-loanAmount)*ac.getInterestRate();
            amount = amount + interest;
            ac.setTotalBalance(amount);
            updateInternalFund(getInternalFund()-interest);
        }

        //deduct yearly loan interest
        for(Accounts ac : accountsList){
            double loanAmount = ac.getTotalLoan();
            double interest = loanAmount*ac.getLoanInterest();
            double balance = ac.getTotalBalance();
            updateInternalFund(getInternalFund()+interest);
            if(balance>=interest){
                balance = balance - interest;
            }
            else{
                interest -= balance;
                balance = 0;
                loanAmount += interest;
            }
            ac.setTotalBalance(balance);
            ac.updateLoanBalance(loanAmount);
        }

        //deduct service charge
        for (Accounts ac : accountsList){
            double serviceCharge = ac.getServiceCharge();
            double loanAmount = ac.getTotalLoan();
            double balance = ac.getTotalBalance();
            updateInternalFund(getInternalFund()+serviceCharge);
            if(balance>=serviceCharge){
                balance = balance - serviceCharge;
            }
            else{
                serviceCharge -= balance;
                balance = 0;
                loanAmount += serviceCharge;
            }
            ac.setTotalBalance(balance);
            ac.updateLoanBalance(loanAmount);
        }
    }
}
