public class App {

    Client client;
    ConsoleEventLogger eventLogger;

    private void logEvent(String msg){
        String message = msg.replaceAll(client.getId(),client.getFullName());
        eventLogger.logEvent(message);

    }


    public static void main(String[] args) {
        App app = new App();

        app.client = new Client("1" ,"Jonn Smit");
        app.eventLogger = new ConsoleEventLogger();

        app.logEvent("Some event for user 1");
    }


}
