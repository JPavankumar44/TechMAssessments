import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class Order {
    private String orderId;
    private String customerName;
    private boolean isPaid;
    private boolean isShipped;
    private LocalDate orderDate;
    private LocalDate deliveryDate;

    public Order(String orderId, String customerName, boolean isPaid, boolean isShipped, LocalDate orderDate, LocalDate deliveryDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.isPaid = isPaid;
        this.isShipped = isShipped;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public boolean isShipped() {
        return isShipped;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Optional<LocalDate> getDeliveryDate() {
        return Optional.ofNullable(deliveryDate); // Can be empty if not yet delivered
    }

    @Override
    public String toString() {
        return orderId + " - " + customerName + " | Paid: " + isPaid + " | Shipped: " + isShipped + " | Order Date: " + orderDate;
    }
}

public class OnlineShoppingOrderProcessing {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("O001", "Alice", true, true, LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 3)),
                new Order("O002", "Bob", false, false, LocalDate.of(2025, 4, 2), null),
                new Order("O003", "Charlie", true, true, LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 4)),
                new Order("O004", "Diana", false, true, LocalDate.of(2025, 4, 3), LocalDate.of(2025, 4, 5))
        );

        // Filter orders that are paid and shipped
        System.out.println("Processed Orders (Paid and Shipped):");
        orders.stream()
                .filter(o -> o.isPaid() && o.isShipped())
                .forEach(o -> System.out.println(o));

        // Find an order where the delivery date is missing (Optional handling)
        Optional<Order> orderWithMissingDelivery = orders.stream()
                .filter(o -> o.getDeliveryDate().isEmpty())
                .findFirst();

        orderWithMissingDelivery.ifPresentOrElse(
                o -> System.out.println("\nOrder with missing delivery date: " + o),
                () -> System.out.println("\nNo orders with missing delivery dates.")
        );
    }
}
/*Online Shopping Order Processing (Streams, Lambda, Date API, Optional)
Approach:
Streams: We will process orders using streams, filtering them based on conditions like payment status and shipping status.

Lambda: We'll use lambda expressions for concise filtering and mapping.

Date API: We'll use LocalDate to handle order dates.

Optional: We'll use Optional to check for missing order data, such as a missing delivery date or payment information.

Explanation:
Order Class: Represents an order with attributes like order ID, customer name, payment status, shipping status, and dates.

Streams: We use streams to filter orders based on their payment and shipping statuses.

Lambda Expressions: Filtering and operations are performed using lambda expressions within the stream.

Optional: For orders that may not have a delivery date, we use Optional to safely check for missing values without causing errors.

*/