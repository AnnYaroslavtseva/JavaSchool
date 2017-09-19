public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException (String message){
        super(message);
    }
    public NotEnoughMoneyException(String message, Exception e) {
        super(message,e);
    }
}

