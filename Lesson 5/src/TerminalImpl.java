import sun.misc.Cache;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TerminalImpl implements Terminal {

    @Override
    public int checkBalance(CashCard card) {
        return card.getBalance();
    }

    @Override
    public void putMoney(CashCard card, int sum) {
        System.out.println("Вы положили "+sum+" денег."+ "Баланс = "+card.getBalance()+sum);

    }

    @Override
    public void takeMoney(CashCard card, int sum) throws NotEnoughMoneyException {
        try {
            if (card.getBalance() > sum){
                System.out.println("Вы положили " + sum + " денег." + "Баланс = " + card.getBalance() + sum);}
                else{
                new NotEnoughMoneyException("На вашем счету недостаточно денег");
            }
        } catch (NotEnoughMoneyException e) {
            e.getMessage();
        };
    }

    public  static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        CashCard card1 = new CashCard(123456,"Ivanov", 1111, 9000);
        CashCard card2 = new CashCard(123457,"Petrov", 1234, 100);
        CashCard card3 = new CashCard(123458,"Sidorov", 6969, 1000000);
        Set<CashCard> cashCards = new HashSet<CashCard>();
        cashCards.add(card1);
        cashCards.add(card2);
        cashCards.add(card3);

        System.out.println("Вставьте карту(Введите номер и фамилию:)");
        int cardNumber = scan.nextInt();
        String lastName = scan.nextLine();


    }

    /*@Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        if (o == this)
            return true;
        CashCard1 that = (CashCard1) o;
        return this.lastName.equals(that.lastName) && this.pinCode == that.pinCode;
    }

    @Override
    public int hashCode() {
        int result = 17;
        int prime = 31;

        result = result * prime + lastName.hashCode();
        result = result * prime + pinCode;

        return result;
    }*/


}
