package co.edu.uptc.cruds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client extends Person {
    private static int counter = 0;

    private String membershipType;
    private boolean isVip;
    private int totalOrders;
    private double totalSpent;
    private List<Order> orderHistory;

    public Client(String name, String telephone, Date birthdate,
                  String address, String email,
                  String membershipType, boolean isVip,
                  String createdBy, Date createdAt) {
        super(name, telephone, birthdate, address, email, createdBy, createdAt);
        this.id = ++counter;
        this.membershipType = membershipType;
        this.isVip = isVip;
        this.totalOrders = 0;
        this.totalSpent = 0.0;
        this.orderHistory = new ArrayList<>();
    }

    public void addOrder(Order order) {
        this.orderHistory.add(order);
        this.totalOrders++;
        this.totalSpent += order.calculateTotal();
    }

    public String getMembershipType() {
    	return membershipType; 
    	}
    public void setMembershipType(String membershipType) {
    	this.membershipType = membershipType; 
    	}

    public boolean isVip() {
    	return isVip; 
    	}
    public void setVip(boolean isVip) { this.isVip = isVip; }

    public int getTotalOrders() { return totalOrders; }
    public double getTotalSpent() { return totalSpent; }
    public List<Order> getOrderHistory() { return orderHistory; }

    @Override
    public String toString() {
        return "=== CLIENTE ===" +
               "\nID: " + id +
               "\nNombre: " + name +
               "\nTeléfono: " + telephone +
               "\nEmail: " + email +
               "\nDirección: " + address +
               "\nMembresia: " + membershipType +
               "\nVIP: " + (isVip ? "Sí" : "No") +
               "\nÓrdenes realizadas: " + totalOrders +
               "\nTotal gastado: $" + totalSpent +
               "\nCreado por: " + createdBy +
               "\nFecha creación: " + createdAt +
               "\nActivo: " + (isActive ? "Sí" : "No");
    }
}