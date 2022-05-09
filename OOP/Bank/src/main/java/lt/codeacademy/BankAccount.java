package lt.codeacademy;

public class BankAccount {
    private final int accountNumber;
    private double bankAccountBalance;
    private Currency currency;
    private  Person person;

    public BankAccount(int accountNumber, double bankAccountBalance, Currency currency, Person person) {
        this.accountNumber = accountNumber;
        this.bankAccountBalance = bankAccountBalance;
        this.currency = currency;
        this.person = person;
    }

    private int getBalance() {
        return 0;
    }

    public void setBankAccountBalance(double bankAccountBalance) {
        this.bankAccountBalance = bankAccountBalance;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    private void putMoney(double money) {

    }

    private void withdrawMoney(double money) {
        //patikrinti ar pakanka pinigu
    }
}
