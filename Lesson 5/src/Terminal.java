public interface Terminal {
    int checkBalance(CashCard card);
    int putMoney(CashCard card,int sum);
    int takeMoney(CashCard card, int sum) throws NotEnoughMoneyException;

}
