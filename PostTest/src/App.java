public class App {
    public static void main(String[] args) throws Exception {
        OrderRepository dbRepo = new DatabaseOrderRepository();
        Notifier emailNotifier = new EmailSystem();
        OrderService orderService = new OrderService(dbRepo, emailNotifier);
        
        Payable creditCard = new CreditCard();
        orderService.processOrder("ORD-001", creditCard, 500000);
        
        Payable voucher = new GiftVoucher();
        orderService.processOrder("ORD-002", voucher, 150000);
    }
}
