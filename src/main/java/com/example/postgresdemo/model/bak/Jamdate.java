package com.example.postgresdemo.model.bak;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

//@Entity
public class Jamdate {
    private Integer jamdateId;
    private Integer jamlocationIdJamlocation;
    private Date date;
    private Timestamp starttime;
    private Timestamp endtime;
    private Date createdate;
    private Short maxpersons;
    private Collection<Contact> contactsByJamdateId;
    private Jamlocation jamlocationByJamlocationIdJamlocation;
    private Collection<Jamtype> jamtypesByJamdateId;
    private Collection<ManyUserHasManyJamdate> manyUserHasManyJamdatesByJamdateId;

    @Id
    @Column(name = "jamdate_id", nullable = false)
    public Integer getJamdateId() {
        return jamdateId;
    }

    public void setJamdateId(Integer jamdateId) {
        this.jamdateId = jamdateId;
    }

    @Basic
    @Column(name = "jamlocation_id_jamlocation", nullable = true)
    public Integer getJamlocationIdJamlocation() {
        return jamlocationIdJamlocation;
    }

    public void setJamlocationIdJamlocation(Integer jamlocationIdJamlocation) {
        this.jamlocationIdJamlocation = jamlocationIdJamlocation;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "starttime", nullable = true)
    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    @Basic
    @Column(name = "endtime", nullable = true)
    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    @Basic
    @Column(name = "createdate", nullable = true)
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Basic
    @Column(name = "maxpersons", nullable = true)
    public Short getMaxpersons() {
        return maxpersons;
    }

    public void setMaxpersons(Short maxpersons) {
        this.maxpersons = maxpersons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jamdate jamdate = (Jamdate) o;

        if (jamdateId != null ? !jamdateId.equals(jamdate.jamdateId) : jamdate.jamdateId != null) return false;
        if (jamlocationIdJamlocation != null ? !jamlocationIdJamlocation.equals(jamdate.jamlocationIdJamlocation) : jamdate.jamlocationIdJamlocation != null)
            return false;
        if (date != null ? !date.equals(jamdate.date) : jamdate.date != null) return false;
        if (starttime != null ? !starttime.equals(jamdate.starttime) : jamdate.starttime != null) return false;
        if (endtime != null ? !endtime.equals(jamdate.endtime) : jamdate.endtime != null) return false;
        if (createdate != null ? !createdate.equals(jamdate.createdate) : jamdate.createdate != null) return false;
        if (maxpersons != null ? !maxpersons.equals(jamdate.maxpersons) : jamdate.maxpersons != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jamdateId != null ? jamdateId.hashCode() : 0;
        result = 31 * result + (jamlocationIdJamlocation != null ? jamlocationIdJamlocation.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (starttime != null ? starttime.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        result = 31 * result + (createdate != null ? createdate.hashCode() : 0);
        result = 31 * result + (maxpersons != null ? maxpersons.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "jamdateByJamdateIdJamdate")
    public Collection<Contact> getContactsByJamdateId() {
        return contactsByJamdateId;
    }

    public void setContactsByJamdateId(Collection<Contact> contactsByJamdateId) {
        this.contactsByJamdateId = contactsByJamdateId;
    }

    @ManyToOne
    @JoinColumn(name = "jamlocation_id_jamlocation", referencedColumnName = "jamlocation_id")
    public Jamlocation getJamlocationByJamlocationIdJamlocation() {
        return jamlocationByJamlocationIdJamlocation;
    }

    public void setJamlocationByJamlocationIdJamlocation(Jamlocation jamlocationByJamlocationIdJamlocation) {
        this.jamlocationByJamlocationIdJamlocation = jamlocationByJamlocationIdJamlocation;
    }

    @OneToMany(mappedBy = "jamdateByJamdateIdJamdate")
    public Collection<Jamtype> getJamtypesByJamdateId() {
        return jamtypesByJamdateId;
    }

    public void setJamtypesByJamdateId(Collection<Jamtype> jamtypesByJamdateId) {
        this.jamtypesByJamdateId = jamtypesByJamdateId;
    }

    @OneToMany(mappedBy = "jamdateByJamdateIdJamdate")
    public Collection<ManyUserHasManyJamdate> getManyUserHasManyJamdatesByJamdateId() {
        return manyUserHasManyJamdatesByJamdateId;
    }

    public void setManyUserHasManyJamdatesByJamdateId(Collection<ManyUserHasManyJamdate> manyUserHasManyJamdatesByJamdateId) {
        this.manyUserHasManyJamdatesByJamdateId = manyUserHasManyJamdatesByJamdateId;
    }
}
