package com.example.postgresdemo.model.bak;

import com.example.postgresdemo.model.UserInstrumentExperience;

import javax.persistence.*;
import java.util.Collection;

//@Entity
public class Instrument {
    private Integer instrId;
    private String name;
    private Collection<ManyJamtypeHasManyInstrument> manyJamtypeHasManyInstrumentsByInstrId;
    private Collection<ManyUsersHasManyInstruments> manyUsersHasManyInstrumentsByInstrId;
    private Collection<UserInstrumentExperience> userInstrumentExperiencesByInstrId;

    @Id
    @Column(name = "instr_id", nullable = false)
    public Integer getInstrId() {
        return instrId;
    }

    public void setInstrId(Integer instrId) {
        this.instrId = instrId;
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

        Instrument that = (Instrument) o;

        if (instrId != null ? !instrId.equals(that.instrId) : that.instrId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = instrId != null ? instrId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "instrumentByInstrIdInstrument")
    public Collection<ManyJamtypeHasManyInstrument> getManyJamtypeHasManyInstrumentsByInstrId() {
        return manyJamtypeHasManyInstrumentsByInstrId;
    }

    public void setManyJamtypeHasManyInstrumentsByInstrId(Collection<ManyJamtypeHasManyInstrument> manyJamtypeHasManyInstrumentsByInstrId) {
        this.manyJamtypeHasManyInstrumentsByInstrId = manyJamtypeHasManyInstrumentsByInstrId;
    }

    @OneToMany(mappedBy = "instrumentByInstrIdInstrument")
    public Collection<ManyUsersHasManyInstruments> getManyUsersHasManyInstrumentsByInstrId() {
        return manyUsersHasManyInstrumentsByInstrId;
    }

    public void setManyUsersHasManyInstrumentsByInstrId(Collection<ManyUsersHasManyInstruments> manyUsersHasManyInstrumentsByInstrId) {
        this.manyUsersHasManyInstrumentsByInstrId = manyUsersHasManyInstrumentsByInstrId;
    }

    @OneToMany(mappedBy = "instrumentByInstrId")
    public Collection<UserInstrumentExperience> getUserInstrumentExperiencesByInstrId() {
        return userInstrumentExperiencesByInstrId;
    }

    public void setUserInstrumentExperiencesByInstrId(Collection<UserInstrumentExperience> userInstrumentExperiencesByInstrId) {
        this.userInstrumentExperiencesByInstrId = userInstrumentExperiencesByInstrId;
    }
}
