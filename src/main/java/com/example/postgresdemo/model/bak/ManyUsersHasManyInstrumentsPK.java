package com.example.postgresdemo.model.bak;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ManyUsersHasManyInstrumentsPK implements Serializable {
    private Integer userIdUser;
    private Integer instrIdInstrument;

    @Column(name = "user_id_user", nullable = false)
    @Id
    public Integer getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(Integer userIdUser) {
        this.userIdUser = userIdUser;
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

        ManyUsersHasManyInstrumentsPK that = (ManyUsersHasManyInstrumentsPK) o;

        if (userIdUser != null ? !userIdUser.equals(that.userIdUser) : that.userIdUser != null) return false;
        if (instrIdInstrument != null ? !instrIdInstrument.equals(that.instrIdInstrument) : that.instrIdInstrument != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userIdUser != null ? userIdUser.hashCode() : 0;
        result = 31 * result + (instrIdInstrument != null ? instrIdInstrument.hashCode() : 0);
        return result;
    }
}
