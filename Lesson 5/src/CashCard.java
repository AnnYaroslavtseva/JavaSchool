public class CashCard {
    private int cardNumber;
    private String lastName;
    private int pinCode;
    private int balance;




    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getPinCode() {
        return pinCode;
    }

    public int getBalance() {
        return balance;
    }

    public CashCard (int cardNumber, String lastName, int pinCode, int balance){
        this.lastName = lastName;
        this.pinCode = pinCode;
        this.balance = balance;
    }





}