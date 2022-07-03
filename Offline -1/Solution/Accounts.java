public abstract class Accounts {
    private String acName;
    private String acType;

    private int acCreatedYear;
    private double totalBalance = 0;
    private double totalLoan = 0;
    private double loanInterest = 0.1;
    private double loanRequested = 0;
    private double serviceCharge = 0;


    Accounts(String acName, String acType){
        this.acName = acName;
        this.acType = acType;
        acCreatedYear = Main.getClockYear();
    }
    static boolean createAc(String acName, String acType, double depORloan){
        //ArrayList<Accounts> accountList =  new ArrayList<>();
        /*for(Accounts ac : accountList){
            if (ac.getAcName().toLowerCase().equals(acName)){
                System.out.println("Account already exist. Choose a different name!");
            }
        }*/
        boolean checker = Processor.checkAcExist(acName);
        if (checker == true){
            System.out.println("Account already exist. Choose a different name!");
            return false;
        }
        else if(depORloan<0){
            System.out.println("Invalid deposit amount. Negative deposit NOT allowed");
            return false;
        }
        else if (acType.toLowerCase().equals("savings")){
            SavingsAccount newSavAC = new SavingsAccount(acName, acType.toLowerCase());
            newSavAC.initialDeposit(depORloan);
            Processor.addBankAc(newSavAC);
            //System.out.println(newSavAC.getAcName()+" "+newSavAC.getTotalBalance()+" "+newSavAC.getTotalLoan());
        }
        else if (acType.toLowerCase().equals("student")){
            StudentAccount newStudAC = new StudentAccount(acName, acType.toLowerCase());
            newStudAC.initialDeposit(depORloan);
            Processor.addBankAc(newStudAC);
            //System.out.println(newStudAC.getAcName()+" "+newStudAC.getTotalBalance()+" "+newStudAC.getTotalLoan());
        }
        else if (acType.toLowerCase().equals("loan")){
            LoanAccount newLoanAC = new LoanAccount(acName, acType.toLowerCase());
            newLoanAC.initialLoan(depORloan);
            Processor.addBankAc(newLoanAC);
            //System.out.println(newLoanAC.getAcName()+" "+newLoanAC.getTotalBalance()+" "+newLoanAC.getTotalLoan());
        }
        else if (acType.toLowerCase().equals("fixeddeposit")){

            if (depORloan<100000){
                System.out.println("First deposit for Fixed Deposit account is at least 100000$");
                return false;
            }
            else {
                FixedDepositAccount newFDac = new FixedDepositAccount(acName, acType.toLowerCase());
                newFDac.initialDeposit(depORloan);
                Processor.addBankAc(newFDac);
                //System.out.println(newFDac.getAcName()+" "+newFDac.getTotalBalance()+" "+newFDac.getTotalLoan());
            }
        }
        return true;
    }


    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    int getAcCreatedYear(){
        return acCreatedYear;
    }
    public double getTotalBalance(){
        return totalBalance;
    }
    void setTotalBalance(double newTotalBalance){
        totalBalance = newTotalBalance;
    }
    public String getAcName(){
        return acName;
    }
    public String getAcType(){
        return acType;
    }
    public double getTotalLoan(){
        return totalLoan;
    }

    public double getLoanRequested(){
        return loanRequested;
    }

    public void setLoanRequested(double newTotalReqAmount){
        loanRequested = newTotalReqAmount;
    }

    public double getLoanInterest(){
        return loanInterest;
    }

    void initialDeposit(double amount){
        totalBalance += amount;
        Processor.updateInternalFund(Processor.getInternalFund()+amount);
        System.out.println(getAcType()+" account for "+getAcName()+" created; Initial Balance:"+getTotalBalance()+"$");
    }
    void deposit(double amount){
        totalBalance += amount;
        Processor.updateInternalFund(Processor.getInternalFund()+amount);
        System.out.println(amount+"$ deposited; current balance: "+ getTotalBalance()+"$");
    }

    void initialLoan(double amount){
        totalLoan += amount;
        Processor.updateInternalFund(Processor.getInternalFund()-amount);
        System.out.println(getAcType()+" account for "+getAcName()+" created; Initial Loan:"+getTotalLoan()+"$");
    }
    void updateLoanBalance(double amount){
        totalLoan = amount;
    }

    void withdraw(double amount){
        if (getTotalBalance()<amount){
            System.out.println("Invalid transaction; current balance: "+getTotalBalance()+"$");
        }
        else {
            totalBalance -= amount;
            Processor.updateInternalFund(Processor.getInternalFund()-amount);
            System.out.println(amount + "$ withdrawn; current balance: " + getTotalBalance() + "$");
        }
    }

    void reqLoan(double reqLoanAmount, double maxLoanAllowed){
        if (reqLoanAmount+getLoanRequested()+getTotalLoan()>maxLoanAllowed){
            System.out.println("Requested Loan amount is greater than Maxm Allowable Loan "+maxLoanAllowed+"$");
        }
        else{
            double prevLoanRequested = getLoanRequested();
            setLoanRequested(prevLoanRequested+reqLoanAmount);
            System.out.println("Loan request successful, sent for approval");
        }
    }
    abstract void reqLoan(double reqLoanAmount);

    void acceptApprovedLoan(){
        updateLoanBalance(getTotalLoan()+getLoanRequested());

        double presentBalance = getTotalBalance();
        setTotalBalance(presentBalance+getLoanRequested());

        double currentIF = Processor.getInternalFund();
        Processor.updateInternalFund(currentIF-getLoanRequested());
        setLoanRequested(0);

        System.out.println("Loan for "+ getAcName() +" approved");
    }

    public void Query(){
        System.out.println("Current Balance "+getTotalBalance()+"$, loan "+getTotalLoan()+"$");
    }

    double getInterestRate(){
        return 0;
    }
}

class SavingsAccount extends Accounts{
    double maxLoanAllowed = 10000;
    static double interestRate = 0.1;

    static void setInterestRate(double newRate){
        SavingsAccount.interestRate = newRate;
    }
    double getInterestRate(){
        return interestRate;
    }

    SavingsAccount(String acName, String acType){
        super(acName, acType);
        setServiceCharge(500);
    }

    @Override
    void withdraw(double amount) {
        double currentBalance = getTotalBalance();
        if(currentBalance-amount < 1000){
            System.out.println("Invalid transaction; current balance: "+currentBalance+"$");
        }
        else {
            super.withdraw(amount);
        }
    }

    @Override
    void reqLoan(double reqLoanAmount) {
        super.reqLoan(reqLoanAmount, maxLoanAllowed);
    }
}

class StudentAccount extends Accounts{
    double maxLoanAllowed = 1000;

    static double interestRate = 0.05;

    static void setInterestRate(double newRate){
        StudentAccount.interestRate = newRate;
    }
    double getInterestRate(){
        return interestRate;
    }
    StudentAccount(String acName, String acType){
        super(acName, acType);
        setServiceCharge(500);
    }

    @Override
    void withdraw(double amount) {
        double currentBalance = getTotalBalance();
        if(amount>10000){
            System.out.println("Invalid transaction; current balance: "+currentBalance+"$");
        }
        else{
            super.withdraw(amount);
        }
    }

    void reqLoan(double reqLoanAmount) {
        super.reqLoan(reqLoanAmount, maxLoanAllowed);
    }
}

class LoanAccount extends Accounts{
    double maxLoanAllowedPerc = 0.05;
    LoanAccount(String acName, String acType){
        super(acName, acType);
    }

    @Override
    void deposit(double amount) {
        updateLoanBalance(getTotalLoan()-amount);
        Processor.updateInternalFund(Processor.getInternalFund()+amount);
        System.out.println(amount+"$ loan paid; current loan balance: "+getTotalLoan()+"$");
    }

    @Override
    void withdraw(double amount) {
        System.out.println("Invalid Transaction! A loan account cannot withdraw.  current loan balance: "+getTotalLoan()+"$");
    }

    void reqLoan(double reqLoanAmount) {
        double maxLoanAllowed =getTotalLoan() + getTotalLoan()*maxLoanAllowedPerc;
        super.reqLoan(reqLoanAmount, maxLoanAllowed);
    }

    @Override
    void acceptApprovedLoan() {
        updateLoanBalance(getTotalLoan()+getLoanRequested());

        double currentIF = Processor.getInternalFund();
        Processor.updateInternalFund(currentIF-getLoanRequested());
        setLoanRequested(0);

        System.out.println("Loan for "+ getAcName() +" approved");
    }
}

class FixedDepositAccount extends Accounts{
    double maxLoanAllowed = 100000;
    static double interestRate = 0.15;

    static void setInterestRate(double newRate){
        FixedDepositAccount.interestRate = newRate;
    }
    double getInterestRate(){
        return interestRate;
    }
    FixedDepositAccount(String acName, String acType){
        super(acName, acType);
        setServiceCharge(500);
    }

    @Override
    void deposit(double amount) {
        if (amount<50000){
            System.out.println("Deposit amount must not be less than 50,000$ for Fixed Deposit account");
        }
        else {
            super.deposit(amount);
        }
    }

    @Override
    void withdraw(double amount) {
        int currentYear = Main.getClockYear();
        int acCreatedY = getAcCreatedYear();
        //System.out.println(currentYear+" "+acCreatedY);
        if(currentYear-acCreatedY < 1){
            System.out.println("Your Fixed Deposit account has not reached maturity period");
        }
        else {
            super.withdraw(amount);
        }
    }
    void reqLoan(double reqLoanAmount) {
        super.reqLoan(reqLoanAmount, maxLoanAllowed);
    }
}