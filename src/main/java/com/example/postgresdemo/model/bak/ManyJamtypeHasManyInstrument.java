package com.example.postgresdemo.model.bak;

import javax.persistence.*;

//@Entity
@Table(name = "many_jamtype_has_many_instrument", schema = "jams", catalog = "jamsintown")
@IdClass(ManyJamtypeHasManyInstrumentPK.class)
public class ManyJamtypeHasManyInstrument {
    private Integer jamtypeIdJamtype;
    private Integer instrIdInstrument;
    private Jamtype jamtypeByJamtypeIdJamtype;
    private Instrument instrumentByInstrIdInstrument;

    @Id
    @Column(name = "jamtype_id_jamtype", nullable = false)
    public Integer getJamtypeIdJamtype() {
        return jamtypeIdJamtype;
    }

    public void setJamtypeIdJamtype(Integer jamtypeIdJamtype) {
        this.jamtypeIdJamtype = jamtypeIdJamtype;
    }

    @Id
    @Column(name = "instr_id_instrument", nullable = false)
    public Integer getInstrIdInstrument() {
        return instrIdInstrument;
    }

    public void setInstrIdInstrument(Integer instrIdInstrument) {
        this.instrIdInstrument = instrIdInstrument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManyJamtypeHasManyInstrument that = (ManyJamtypeHasManyInstrument) o;

        if (jamtypeIdJamtype != null ? !jamtypeIdJamtype.equals(that.jamtypeIdJamtype) : that.jamtypeIdJamtype != null)
            return false;
        if (instrIdInstrument != null ? !instrIdInstrument.equals(that.instrIdInstrument) : that.instrIdInstrument != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jamtypeIdJamtype != null ? jamtypeIdJamtype.hashCode() : 0;
        result = 31 * result + (instrIdInstrument != null ? instrIdInstrument.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "jamtype_id_jamtype", referencedColumnName = "jamtype_id", nullable = false)
    public Jamtype getJamtypeByJamtypeIdJamtype() {
        return jamtypeByJamtypeIdJamtype;
    }

    public void setJamtypeByJamtypeIdJamtype(Jamtype jamtypeByJamtypeIdJamtype) {
        this.jamtypeByJamtypeIdJamtype = jamtypeByJamtypeIdJamtype;
    }

    @ManyToOne
    @JoinColumn(name = "instr_id_instrument", referencedColumnName = "instr_id", nullable = false)
    public Instrument getInstrumentByInstrIdInstrument() {
        return instrumentByInstrIdInstrument;
    }

    public void setInstrumentByInstrIdInstrument(Instrument instrumentByInstrIdInstrument) {
        this.instrumentByInstrIdInstrument = instrumentByInstrIdInstrument;
    }
}
