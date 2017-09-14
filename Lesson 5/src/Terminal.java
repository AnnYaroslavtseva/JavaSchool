public interface Terminal {
    int checkBalance(Object card);
    void putMoney(CacheCard card,int sum);
    void takeMoney(CacheCard card, int sum) throws NotEnoughMoneyException;

}
