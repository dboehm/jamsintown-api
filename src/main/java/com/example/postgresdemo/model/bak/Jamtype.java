package com.example.postgresdemo.model.bak;

import javax.persistence.*;
import java.util.Collection;

//@Entity
public class Jamtype {
    private Integer jamtypeId;
    private String name;
    private Integer jamdateIdJamdate;
    private Jamdate jamdateByJamdateIdJamdate;
    private Collection<ManyJamtypeHasManyInstrument> manyJamtypeHasManyInstrumentsByJamtypeId;
    private Collection<ManyJamtypeHasManyMusicstyle> manyJamtypeHasManyMusicstylesByJamtypeId;

    @Id
    @Column(name = "jamtype_id", nullable = false)
    public Integer getJamtypeId() {
        return jamtypeId;
    }

    public void setJamtypeId(Integer jamtypeId) {
        this.jamtypeId = jamtypeId;
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

        Jamtype jamtype = (Jamtype) o;

        if (jamtypeId != null ? !jamtypeId.equals(jamtype.jamtypeId) : jamtype.jamtypeId != null) return false;
        if (name != null ? !name.equals(jamtype.name) : jamtype.name != null) return false;
        if (jamdateIdJamdate != null ? !jamdateIdJamdate.equals(jamtype.jamdateIdJamdate) : jamtype.jamdateIdJamdate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jamtypeId != null ? jamtypeId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
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

    @OneToMany(mappedBy = "jamtypeByJamtypeIdJamtype")
    public Collection<ManyJamtypeHasManyInstrument> getManyJamtypeHasManyInstrumentsByJamtypeId() {
        return manyJamtypeHasManyInstrumentsByJamtypeId;
    }

    public void setManyJamtypeHasManyInstrumentsByJamtypeId(Collection<ManyJamtypeHasManyInstrument> manyJamtypeHasManyInstrumentsByJamtypeId) {
        this.manyJamtypeHasManyInstrumentsByJamtypeId = manyJamtypeHasManyInstrumentsByJamtypeId;
    }

    @OneToMany(mappedBy = "jamtypeByJamtypeIdJamtype")
    public Collection<ManyJamtypeHasManyMusicstyle> getManyJamtypeHasManyMusicstylesByJamtypeId() {
        return manyJamtypeHasManyMusicstylesByJamtypeId;
    }

    public void setManyJamtypeHasManyMusicstylesByJamtypeId(Collection<ManyJamtypeHasManyMusicstyle> manyJamtypeHasManyMusicstylesByJamtypeId) {
        this.manyJamtypeHasManyMusicstylesByJamtypeId = manyJamtypeHasManyMusicstylesByJamtypeId;
    }
}
