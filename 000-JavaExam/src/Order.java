public class Order extends Drink{
    private int orderId;
    private OrderStatus status;
    public Order(int orderId, OrderStatus status, int drinkId, String name, String type, int quantity) {
        super(drinkId, name, type, quantity);
        this.orderId = orderId;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
