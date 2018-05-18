package me.Vamsi;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {


    @Id private String email;
    private String name;
    private String phoneNumber;

    public Contact() {  }

    public Contact(String email, String name, String phoneNumber) {
        this.setEmail(email);
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email=" + email +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
