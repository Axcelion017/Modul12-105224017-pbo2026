public class OrderService {
    private OrderRepository repository;
    private Notifier notifier;

    public OrderService(OrderRepository repository, Notifier notifier) {
        this.repository = repository;
        this.notifier = notifier;
    }

    public void processOrder(String orderId, Payable paymentMethod, double amount) {
        System.out.println("--- Memulai Proses Pesanan " + orderId + " ---");
        
        paymentMethod.pay(amount);
        repository.saveOrderData(orderId);
        notifier.sendMessage("Pesanan " + orderId + " berhasil diproses dan dibayar.");
        
        System.out.println("--- Proses Pesanan Selesai ---\n");
    }
}

interface OrderRepository {
    void saveOrderData(String orderId);
}

class DatabaseOrderRepository implements OrderRepository {
    @Override
    public void saveOrderData(String orderId) {
        System.out.println("Menyimpan data pesanan " + orderId + " ke dalam Database.");
    }
}


