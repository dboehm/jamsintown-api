package com.example.postgresdemo.model.bak;

import javax.persistence.*;

//@Entity
public class Contact {
    private Integer contactId;
    private String name;
    private String role;
    private String email;
    private String phone;
    private String mobil;
    private Integer jamdateIdJamdate;
    private Jamdate jamdateByJamdateIdJamdate;

    @Id
    @Column(name = "contact_id", nullable = false)
    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "role", nullable = true, length = -1)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "email", nullable = true, length = -1)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = -1)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "mobil", nullable = true, length = -1)
    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    @Basic
    @Column(name = "jamdate_id_jamdate", nullable = true)
    public Integer getJamdateIdJamdate() {
        return jamdateIdJamdate;
    }

    public void setJamdateIdJamdate(Integer jamdateIdJamdate) {
        this.jamdateIdJamdate = jamdateIdJamdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (contactId != null ? !contactId.equals(contact.contactId) : contact.contactId != null) return false;
        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
        if (role != null ? !role.equals(contact.role) : contact.role != null) return false;
        if (email != null ? !email.equals(contact.email) : contact.email != null) return false;
        if (phone != null ? !phone.equals(contact.phone) : contact.phone != null) return false;
        if (mobil != null ? !mobil.equals(contact.mobil) : contact.mobil != null) return false;
        if (jamdateIdJamdate != null ? !jamdateIdJamdate.equals(contact.jamdateIdJamdate) : contact.jamdateIdJamdate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contactId != null ? contactId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (mobil != null ? mobil.hashCode() : 0);
        result = 31 * result + (jamdateIdJamdate != null ? jamdateIdJamdate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "jamdate_id_jamdate", referencedColumnName = "jamdate_id")
    public Jamdate getJamdateByJamdateIdJamdate() {
        return jamdateByJamdateIdJamdate;
    }

    public void setJamdateByJamdateIdJamdate(Jamdate jamdateByJamdateIdJamdate) {
        this.jamdateByJamdateIdJamdate = jamdateByJamdateIdJamdate;
    }
}
