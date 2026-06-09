interface Payable {
    void pay(double amount);
}

interface Refundable {
    void refund(double amount);
}

class CreditCard implements Payable, Refundable {
    @Override
    public void pay(double amount) {
        System.out.println("Memproses pembayaran Kartu Kredit sebesar: " + amount);
        // Logika memanggil API Bank
    }

    @Override
    public void refund(double amount) {
        System.out.println("Memproses refund Kartu Kredit sebesar: " + amount);
    }
}

class OVO implements Payable, Refundable {
    @Override
    public void pay(double amount) {
        System.out.println("Memproses pembayaran OVO sebesar: " + amount);
        // Logika memanggil API OVO
    }

    @Override
    public void refund(double amount) {
        System.out.println("Memproses refund OVO sebesar: " + amount);
    }
}

class GiftVoucher implements Payable {
    @Override
    public void pay(double amount) {
        System.out.println("Memproses pembayaran Gift Voucher sebesar: " + amount);
    }
}