package project;

public class Transaction extends Displayable {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void display() {
        System.out.println("Type: " + type + " Amount: " + amount);
    }
}