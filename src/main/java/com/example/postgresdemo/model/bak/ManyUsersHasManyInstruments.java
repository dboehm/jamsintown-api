package com.example.postgresdemo.model.bak;

import javax.persistence.*;

//@Entity
@Table(name = "many_users_has_many_instruments", schema = "users", catalog = "jamsintown")
@IdClass(ManyUsersHasManyInstrumentsPK.class)
public class ManyUsersHasManyInstruments {
    private Integer userIdUser;
    private Integer instrIdInstrument;
    private User userByUserIdUser;
    private Instrument instrumentByInstrIdInstrument;

    @Id
    @Column(name = "user_id_user", nullable = false)
    public Integer getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(Integer userIdUser) {
        this.userIdUser = userIdUser;
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

        ManyUsersHasManyInstruments that = (ManyUsersHasManyInstruments) o;

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

    @ManyToOne
    @JoinColumn(name = "user_id_user", referencedColumnName = "user_id", nullable = false)
    public User getUserByUserIdUser() {
        return userByUserIdUser;
    }

    public void setUserByUserIdUser(User userByUserIdUser) {
        this.userByUserIdUser = userByUserIdUser;
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
