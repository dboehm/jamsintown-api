package com.example.postgresdemo.model.bak;

import com.example.postgresdemo.model.UserInstrumentExperience;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

//@Entity
public class User {
    private Integer userId;
    private String username;
    private String email;
    private String vorname;
    private String nachname;
    private Date entryDate;
    private Date lastLoggimgDate;
    private Collection<ManyUserHasManyJamdate> manyUserHasManyJamdatesByUserId;
    private Collection<ManyUsersHasManyInstruments> manyUsersHasManyInstrumentsByUserId;
    private Collection<ManyUsersHasManyMusicstyles> manyUsersHasManyMusicstylesByUserId;
    private Collection<UserInstrumentExperience> userInstrumentExperiencesByUserId;

    @Id
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username", nullable = true, length = -1)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email", nullable = true, length = -1)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "vorname", nullable = true, length = -1)
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Basic
    @Column(name = "nachname", nullable = true, length = -1)
    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Basic
    @Column(name = "entry_date", nullable = true)
    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Basic
    @Column(name = "last_loggimg_date", nullable = true)
    public Date getLastLoggimgDate() {
        return lastLoggimgDate;
    }

    public void setLastLoggimgDate(Date lastLoggimgDate) {
        this.lastLoggimgDate = lastLoggimgDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (vorname != null ? !vorname.equals(user.vorname) : user.vorname != null) return false;
        if (nachname != null ? !nachname.equals(user.nachname) : user.nachname != null) return false;
        if (entryDate != null ? !entryDate.equals(user.entryDate) : user.entryDate != null) return false;
        if (lastLoggimgDate != null ? !lastLoggimgDate.equals(user.lastLoggimgDate) : user.lastLoggimgDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (vorname != null ? vorname.hashCode() : 0);
        result = 31 * result + (nachname != null ? nachname.hashCode() : 0);
        result = 31 * result + (entryDate != null ? entryDate.hashCode() : 0);
        result = 31 * result + (lastLoggimgDate != null ? lastLoggimgDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserIdUser")
    public Collection<ManyUserHasManyJamdate> getManyUserHasManyJamdatesByUserId() {
        return manyUserHasManyJamdatesByUserId;
    }

    public void setManyUserHasManyJamdatesByUserId(Collection<ManyUserHasManyJamdate> manyUserHasManyJamdatesByUserId) {
        this.manyUserHasManyJamdatesByUserId = manyUserHasManyJamdatesByUserId;
    }

    @OneToMany(mappedBy = "userByUserIdUser")
    public Collection<ManyUsersHasManyInstruments> getManyUsersHasManyInstrumentsByUserId() {
        return manyUsersHasManyInstrumentsByUserId;
    }

    public void setManyUsersHasManyInstrumentsByUserId(Collection<ManyUsersHasManyInstruments> manyUsersHasManyInstrumentsByUserId) {
        this.manyUsersHasManyInstrumentsByUserId = manyUsersHasManyInstrumentsByUserId;
    }

    @OneToMany(mappedBy = "userByUserIdUser")
    public Collection<ManyUsersHasManyMusicstyles> getManyUsersHasManyMusicstylesByUserId() {
        return manyUsersHasManyMusicstylesByUserId;
    }

    public void setManyUsersHasManyMusicstylesByUserId(Collection<ManyUsersHasManyMusicstyles> manyUsersHasManyMusicstylesByUserId) {
        this.manyUsersHasManyMusicstylesByUserId = manyUsersHasManyMusicstylesByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserInstrumentExperience> getUserInstrumentExperiencesByUserId() {
        return userInstrumentExperiencesByUserId;
    }

    public void setUserInstrumentExperiencesByUserId(Collection<UserInstrumentExperience> userInstrumentExperiencesByUserId) {
        this.userInstrumentExperiencesByUserId = userInstrumentExperiencesByUserId;
    }
}
