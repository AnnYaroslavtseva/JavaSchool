public class TerminalImpl implements Terminal {

    @Override
    public int checkBalance(CacheCard card) {
        return card.getBalance();
    }

    @Override
    public void putMoney(CacheCard card, int sum) {
        System.out.println("Вы положили "+sum+" денег."+ "Баланс = "+card.getBalance()+sum);

    }

    @Override
    public void takeMoney(CacheCard card, int sum) throws NotEnoughMoneyException {
        try {
            if (card.getBalance() < sum){
                System.out.println("Вы положили " + sum + " денег." + "Баланс = " + card.getBalance() + sum);}
                else{
                new NotEnoughMoneyException("На вашем счету недостаточно денег");
            }
        } catch (NotEnoughMoneyException e) {
            e.getMessage();
        };
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
