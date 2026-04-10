package co.edu.uptc.cruds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Restaurant extends BaseClass {
    private static int counter = 0;

    private String name;
    private String address;
    private String telephone;
    private String typeKitchen;
    private double score;
    private String openingHours;
    private List<Employee> employees;

    public Restaurant(String name, String address, String telephone,
                      String typeKitchen, double score, String openingHours,
                      String createdBy, Date createdAt) {
        super(0, createdBy, createdAt);
        this.id = ++counter;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.typeKitchen = typeKitchen;
        this.score = score;
        this.openingHours = openingHours;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee e) {
    	this.employees.add(e);
    	}

    public String getName() {
    	return name; 
    	}
    public void setName(String name) {
    	this.name = name;
    	}

    public String getAddress() {
    	return address; 
    	}
    public void setAddress(String address) {
    	this.address = address; 
    	}

    public String getTelephone() { 
    	return telephone; 
    	}
    public void setTelephone(String telephone) { 
    	this.telephone = telephone; 
    	}

    public String getTypeKitchen() {
    	return typeKitchen; 
    	}
    public void setTypeKitchen(String typeKitchen) { 
    	this.typeKitchen = typeKitchen; 
    	}

    public double getScore() { 
    	return score;
    	}
    public void setScore(double score) { 
    	this.score = score; 
    	}

    public String getOpeningHours() {
    	return openingHours; 
    	}
    public void setOpeningHours(String openingHours) { 
    	this.openingHours = openingHours; 
    	}

    public List<Employee> getEmployees() { 
    	return employees;
    	}
    public void setEmployees(List<Employee> employees) { 
    	this.employees = employees; 
    	}

    @Override
    public String toString() {
        return "===== RESTAURANTE =====\n"
             + "ID: " + id + "\n"
             + "Nombre: " + name + "\n"
             + "Dirección: " + address + "\n"
             + "Teléfono: " + telephone + "\n"
             + "Tipo de cocina: " + typeKitchen + "\n"
             + "Calificación: " + String.format("%.1f", score) + "\n"
             + "Horario: " + openingHours + "\n"
             + "Empleados: " + employees.size() + "\n"
             + "Creado por: " + createdBy + "\n"
             + "Fecha creación: " + createdAt + "\n"
             + "Activo: " + (isActive ? "Sí" : "No") + "\n"
             + "========================";
    }
}