interface Notifier {
    void sendMessage(String message);
}

class EmailSystem implements Notifier {
    @Override
    public void sendMessage(String message) {
        System.out.println("Mengirim Email: " + message);
    }
}

class WhatsAppSystem implements Notifier {
    @Override
    public void sendMessage(String message) {
        System.out.println("Mengirim WhatsApp: " + message);
    }
}