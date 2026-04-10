package co.edu.uptc.cruds.model;

import java.util.Date;

public class Product extends BaseClass {
    
	private static int counter = 0;

    private String name;
    private String description;
    private double price;
    private String category;
    private boolean isAvailable;

    public Product(String name, String description, double price,
                   String category, boolean isAvailable,
                   String createdBy, Date createdAt) {
        super(0, createdBy, createdAt);
        this.id = ++counter;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public String getName() { 
    	return name;
    	}
    public void setName(String name) { 
    	this.name = name;
    	}

    public String getDescription() {
    	return description; 
    	}
    public void setDescription(String description) { this.description = description; }

    public double getPrice() {
    	return price; 
    	}
    public void setPrice(double price) {
    	this.price = price; 
    	}

    public String getCategory() {
    	return category;
    	}
    public void setCategory(String category) {
    	this.category = category;
    	}

    public boolean isAvailable() { 
    	return isAvailable; 
    	}
    public void setAvailable(boolean isAvailable) { 
    	this.isAvailable = isAvailable;
    	}

    @Override
    public String toString() {
        return "----- PRODUCTO -----\n"
             + "ID: " + id + "\n"
             + "Nombre: " + name + "\n"
             + "Descripción: " + description + "\n"
             + "Precio: $" + price + "\n"
             + "Categoría: " + category + "\n"
             + "Disponible: " + (isAvailable ? "Sí" : "No") + "\n"
             + "Creado por: " + createdBy + "\n"
             + "Fecha creación: " + createdAt + "\n"
             + "Activo: " + (isActive ? "Sí" : "No") + "\n"
             + "--------------------";
    }
}