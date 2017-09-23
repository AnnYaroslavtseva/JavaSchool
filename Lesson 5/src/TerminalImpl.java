
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TerminalImpl implements Terminal {

    @Override
    public int checkBalance(CashCard card) {
        return card.getBalance();
    }

    @Override
    public int putMoney(CashCard card, int money) {
        int balance = card.getBalance();
        balance += money;
        return balance;

    }

  /*  @Override
    public int takeMoney(CashCard card, int money) throws NotEnoughMoneyException {
        if (card.getBalance() > money) {
            int balance = card.getBalance();
            balance -= money;
            return balance;
        } else { throw new NotEnoughMoneyException("На вашем счету недостаточно денег");
        }


        }*/

    @Override
    public int takeMoney(CashCard card, int money) throws NotEnoughMoneyException {
        if (card.getBalance() < money)  throw new NotEnoughMoneyException("На вашем счету недостаточно денег");
            int balance = card.getBalance();
            balance -= money;
            return balance;

    }



    public void run() throws NotEnoughMoneyException {
        int cardNumber = 0;
        String lastName = null;
        int pinCode = 0;

        Scanner scan = new Scanner(System.in);
        CashCard card1 = new CashCard(123456, "Ivanov", 1111, 9000);
        CashCard card2 = new CashCard(123457, "Petrov", 1234, 100);
        CashCard card3 = new CashCard(123458, "Sidorov", 6969, 1000000);
        Set<CashCard> cashCards = new HashSet();
        cashCards.add(card1);
        cashCards.add(card2);
        cashCards.add(card3);

        System.out.println("Вставьте карту(Введите номер и фамилию латиницей):");
        cardNumber = scan.nextInt();
        scan.nextLine();
        lastName = scan.nextLine();
        System.out.println("Введите пинкод:");
        pinCode = scan.nextInt();
        CashCard card = new CashCard(cardNumber, lastName, pinCode, 0);
        if (!cashCards.contains(card)) {
            System.out.println("Карта не читается, вставьте другую карту");
        } else {
            for (CashCard cashCard : cashCards) { //foreach
                if (cashCard.equals(card)) {
                    System.out.println("/.................Введите код операции, которую хотите выполнить............../");
                    System.out.println("/..................1: проверить баланс карты................................../");
                    System.out.println("/..................2: пополнить баланс карты................................../");
                    System.out.println("/..................3: снять деньги с карты..................................../");
                    int i = scan.nextInt();
                    switch (i) {
                        case 1:
                            System.out.println(checkBalance(cashCard));
                            break;
                        case 2:
                            System.out.println("Введите сумму, на которую хотите пополнить баланс");
                            int putMoney = scan.nextInt();
                            System.out.println("Успешно выпонено. Ваш баланс: " + putMoney(cashCard, putMoney));
                            break;
                        case 3:
                            System.out.println("Введите сумму, которую хотите снять");
                            int takeMoney = scan.nextInt();
                            try {System.out.println("Успешно выпонено. Ваш баланс: " + takeMoney(cashCard, takeMoney));

                            } catch (NotEnoughMoneyException e) {

                                System.out.println(e.getMessage());
                                throw e;
                            }
                            break;
                    }

                }

            }

        }


    }
}

