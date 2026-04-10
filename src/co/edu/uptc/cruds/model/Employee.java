package co.edu.uptc.cruds.model;

import java.util.Date;


public class Employee extends Person {
    private static int counter = 0;

    private String position;
    private double salary;
    private String schedule;
    private String contractType;

    public Employee(String name, String telephone, Date birthdate,
                    String address, String email,
                    String position, double salary,
                    String schedule, String contractType,
                    String createdBy, Date createdAt) {
        super(name, telephone, birthdate, address, email, createdBy, createdAt);
        this.id = ++counter;
        this.position = position;
        this.salary = salary;
        this.schedule = schedule;
        this.contractType = contractType;
    }

    public String getPosition() { 
    	return position; 
    	}
    public void setPosition(String position) { 
    	this.position = position; 
    	}

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getSchedule() { return schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }

    public String getContractType() { return contractType; }
    public void setContractType(String contractType) { this.contractType = contractType; }

    @Override
    public String toString() {
        return "=== EMPLEADO ===" +
               "\nID: " + id +
               "\nNombre: " + name +
               "\nTeléfono: " + telephone +
               "\nFecha nacimiento: " + birthdate +
               "\nDirección: " + address +
               "\nEmail: " + email +
               "\nCargo: " + position +
               "\nSalario: $" + salary +
               "\nHorario: " + schedule +
               "\nContrato: " + contractType +
               "\nCreado por: " + createdBy +
               "\nFecha creación: " + createdAt +
               "\nActivo: " + (isActive ? "Sí" : "No");
    }
}