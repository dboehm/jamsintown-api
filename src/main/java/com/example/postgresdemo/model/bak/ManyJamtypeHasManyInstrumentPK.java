package com.example.postgresdemo.model.bak;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ManyJamtypeHasManyInstrumentPK implements Serializable {
    private Integer jamtypeIdJamtype;
    private Integer instrIdInstrument;

    @Column(name = "jamtype_id_jamtype", nullable = false)
    @Id
    public Integer getJamtypeIdJamtype() {
        return jamtypeIdJamtype;
    }

    public void setJamtypeIdJamtype(Integer jamtypeIdJamtype) {
        this.jamtypeIdJamtype = jamtypeIdJamtype;
    }

    @Column(name = "instr_id_instrument", nullable = false)
    @Id
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

        ManyJamtypeHasManyInstrumentPK that = (ManyJamtypeHasManyInstrumentPK) o;

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
}
