package co.edu.uptc.cruds.model;

import java.util.Date;

public abstract class Person extends BaseClass {
    protected String name;
    protected String telephone;
    protected Date birthdate;
    protected String address;
    protected String email;

    public Person() {}

    public Person(String name, String telephone, Date birthdate,
                  String address, String email,
                  String createdBy, Date createdAt) {
        super(0, createdBy, createdAt);
        this.name = name;
        this.telephone = telephone;
        this.birthdate = birthdate;
        this.address = address;
        this.email = email;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public Date getBirthdate() { return birthdate; }
    public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Person [name=" + name + ", telephone=" + telephone +
               ", birthdate=" + birthdate + ", address=" + address +
               ", email=" + email + "]";
    }
}