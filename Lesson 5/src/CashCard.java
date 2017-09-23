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
    //public int setBalance(int money){balance += money; return balance;}
    public int getCardNumber() { return cardNumber;}

    public CashCard(int cardNumber, String lastName, int pinCode, int balance) {
        this.cardNumber = cardNumber;
        this.lastName = lastName;
        this.pinCode = pinCode;
        this.balance = balance;
    }

    @Override
    //Переопределяем метод equals, чтобы в дальнейшем использовать метод contains в котором будем сравнивать только 3 поля мнжества
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        if (o == this)
            return true;
        CashCard that = (CashCard) o;
        return this.cardNumber == that.cardNumber && this.lastName.equals(that.lastName) && this.pinCode == that.pinCode;


    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cardNumber;
        result = prime * result + lastName.hashCode();
        result = prime * result + pinCode;

        return result;
    }
}