package lt.codeacademy.lessons.fiftheen.staticFinal;

public class BlaBlaBla {
    private int amount;
    private int number;
    private static int numberOfAccounts;

    public BlaBlaBla () {
        this.number = numberOfAccounts;
        numberOfAccounts++;
    }

    public void deposit(int amount) {
        this.amount += amount;
    }

    public void withdraw(int amount) {
        this.amount -= amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getNumber() {
        return this.number;
    }

    public void setAmount(int a) {
        this.amount = a;
    }
}
