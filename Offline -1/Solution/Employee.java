import java.util.ArrayList;

public abstract class Employee {
    String empName;
    Employee(String empName){
        this.empName = empName;
    }

    static void createEmployee(String name, String empType){
        if (empType.toLowerCase().equals("md")){
            ManagingDirector mdr = new ManagingDirector(name);
            Processor.addBankEmployee(mdr);
        }
        else if (empType.toLowerCase().equals("officer")){
            Officer offcr = new Officer(name);
            Processor.addBankEmployee(offcr);
        }
        else if (empType.toLowerCase().equals("cashier")){
            Cashier cashier = new Cashier(name);
            Processor.addBankEmployee(cashier);
        }
    }

    String getEmpName(){
        return empName;
    }

    public void lookUp(String acName){
        Accounts currentAc = Processor.loginToAc(acName);
        System.out.println(currentAc.getAcName()+"'s current balance is "+currentAc.getTotalBalance()+"$");
    }

    public void approveLoan(){
        System.out.println("You don’t have permission for this operation");
    }

    public void changeInterest(String acType, double newRate){
        System.out.println("You don’t have permission for this operation");
    }

    public void seeInternalFund(){
        System.out.println("You don’t have permission for this operation");
    }

}

class ManagingDirector extends Employee{
    ManagingDirector(String empName){
        super(empName);
    }

    @Override
    public void approveLoan() {
        ArrayList<Accounts> accountsList = Processor.getAccountsList();
        for(Accounts ac : accountsList){
            if(ac.getLoanRequested()>0){
                ac.acceptApprovedLoan();
            }
        }
    }

    @Override
    public void changeInterest(String acType, double newRate) {
        if (acType.toLowerCase().equals("savings")){
            SavingsAccount.setInterestRate(newRate);
        }
        else if (acType.toLowerCase().equals("student")){
            StudentAccount.setInterestRate(newRate);
        }
        else if (acType.toLowerCase().equals("fixeddeposit")){
            FixedDepositAccount.setInterestRate(newRate);
        }
        else{
            System.out.println("Invalid Account Type!");
        }
    }

    @Override
    public void seeInternalFund() {
        System.out.println("Internal Fund: "+ Processor.getInternalFund()+"$");
    }
}

class Officer extends Employee{
    Officer(String empName){
        super(empName);
    }

    @Override
    public void approveLoan() {
        ArrayList<Accounts> accountsList = Processor.getAccountsList();
        for(Accounts ac : accountsList){
            if(ac.getLoanRequested()>0){
                ac.acceptApprovedLoan();
            }
        }
    }
}

class Cashier extends Employee{
    Cashier(String empName){
        super(empName);
    }
}