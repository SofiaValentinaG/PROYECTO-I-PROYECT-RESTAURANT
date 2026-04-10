package co.edu.uptc.cruds.model;

import co.edu.uptc.cruds.enums.Status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends BaseClass {
    private static int counter = 0;

    private Client client;
    private Employee employee;
    private Restaurant restaurant;
    private Status status;
    private Date timeOrder;
    private String deliveryAddress;
    private String paymentMethod;
    private List<Product> products;

    public Order(Client client, Employee employee, Restaurant restaurant,
                 Status status, Date timeOrder,
                 String deliveryAddress, String paymentMethod,
                 String createdBy, Date createdAt) {
        super(0, createdBy, createdAt);
        this.id = ++counter;
        this.client = client;
        this.employee = employee;
        this.restaurant = restaurant;
        this.status = status;
        this.timeOrder = timeOrder;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) { 
    	this.products.add(p);
    	}

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) total += p.getPrice();
        return total;
    }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Restaurant getRestaurant() { return restaurant; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Date getTimeOrder() { return timeOrder; }
    public void setTimeOrder(Date timeOrder) { this.timeOrder = timeOrder; }

    public String getDeliveryAddress() { 
    	return deliveryAddress;
    	}
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public List<Product> getProducts() { return products; }

    @Override
    public String toString() {
        return "=== ORDEN ===" +
               "\nID: " + id +
               "\nCliente: " + (client != null ? client.getName() : "N/A") +
               "\nEmpleado: " + (employee != null ? employee.getName() : "N/A") +
               "\nRestaurante: " + (restaurant != null ? restaurant.getName() : "N/A") +
               "\nEstado: " + status +
               "\nDirección entrega: " + deliveryAddress +
               "\nMétodo de pago: " + paymentMethod +
               "\nProductos: " + products.size() +
               "\nFecha: " + timeOrder +
               "\nTotal: $" + calculateTotal() +
               "\nCreado por: " + createdBy +
               "\nActivo: " + (isActive ? "Sí" : "No");
    }
}