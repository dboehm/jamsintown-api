package com.example.postgresdemo.model.bak;

import javax.persistence.*;

//@Entity
@Table(name = "many_user_has_many_jamdate", schema = "users", catalog = "jamsintown")
@IdClass(ManyUserHasManyJamdatePK.class)
public class ManyUserHasManyJamdate {
    private Integer userIdUser;
    private Integer jamdateIdJamdate;
    private User userByUserIdUser;
    private Jamdate jamdateByJamdateIdJamdate;

    @Id
    @Column(name = "user_id_user", nullable = false)
    public Integer getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(Integer userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Id
    @Column(name = "jamdate_id_jamdate", nullable = false)
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

        ManyUserHasManyJamdate that = (ManyUserHasManyJamdate) o;

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

    @ManyToOne
    @JoinColumn(name = "user_id_user", referencedColumnName = "user_id", nullable = false)
    public User getUserByUserIdUser() {
        return userByUserIdUser;
    }

    public void setUserByUserIdUser(User userByUserIdUser) {
        this.userByUserIdUser = userByUserIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "jamdate_id_jamdate", referencedColumnName = "jamdate_id", nullable = false)
    public Jamdate getJamdateByJamdateIdJamdate() {
        return jamdateByJamdateIdJamdate;
    }

    public void setJamdateByJamdateIdJamdate(Jamdate jamdateByJamdateIdJamdate) {
        this.jamdateByJamdateIdJamdate = jamdateByJamdateIdJamdate;
    }
}
