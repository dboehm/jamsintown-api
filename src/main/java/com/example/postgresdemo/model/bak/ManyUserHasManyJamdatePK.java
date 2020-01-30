package com.example.postgresdemo.model.bak;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ManyUserHasManyJamdatePK implements Serializable {
    private Integer userIdUser;
    private Integer jamdateIdJamdate;

    @Column(name = "user_id_user", nullable = false)
    @Id
    public Integer getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(Integer userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Column(name = "jamdate_id_jamdate", nullable = false)
    @Id
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

        ManyUserHasManyJamdatePK that = (ManyUserHasManyJamdatePK) o;

        if (userIdUser != null ? !userIdUser.equals(that.userIdUser) : that.userIdUser != null) return false;
        if (jamdateIdJamdate != null ? !jamdateIdJamdate.equals(that.jamdateIdJamdate) : that.jamdateIdJamdate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userIdUser != null ? userIdUser.hashCode() : 0;
        result = 31 * result + (jamdateIdJamdate != null ? jamdateIdJamdate.hashCode() : 0);
        return result;
    }
}
