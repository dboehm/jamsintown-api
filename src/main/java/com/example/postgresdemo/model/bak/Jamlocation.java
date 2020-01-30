package com.example.postgresdemo.model.bak;

import javax.persistence.*;
import java.util.Collection;

//@Entity
public class Jamlocation {
    private Integer jamlocationId;
    private String name;
    private Collection<Address> addressesByJamlocationId;
    private Collection<Jamdate> jamdatesByJamlocationId;

    @Id
    @Column(name = "jamlocation_id", nullable = false)
    public Integer getJamlocationId() {
        return jamlocationId;
    }

    public void setJamlocationId(Integer jamlocationId) {
        this.jamlocationId = jamlocationId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jamlocation that = (Jamlocation) o;

        if (jamlocationId != null ? !jamlocationId.equals(that.jamlocationId) : that.jamlocationId != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jamlocationId != null ? jamlocationId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "jamlocationByJamlocationIdJamlocation")
    public Collection<Address> getAddressesByJamlocationId() {
        return addressesByJamlocationId;
    }

    public void setAddressesByJamlocationId(Collection<Address> addressesByJamlocationId) {
        this.addressesByJamlocationId = addressesByJamlocationId;
    }

    @OneToMany(mappedBy = "jamlocationByJamlocationIdJamlocation")
    public Collection<Jamdate> getJamdatesByJamlocationId() {
        return jamdatesByJamlocationId;
    }

    public void setJamdatesByJamlocationId(Collection<Jamdate> jamdatesByJamlocationId) {
        this.jamdatesByJamlocationId = jamdatesByJamlocationId;
    }
}
