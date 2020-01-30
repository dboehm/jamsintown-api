package com.example.postgresdemo.model.bak;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ManyUsersHasManyMusicstylesPK implements Serializable {
    private Integer userIdUser;
    private Integer musicstyleIdMusicstyle;

    @Column(name = "user_id_user", nullable = false)
    @Id
    public Integer getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(Integer userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Column(name = "musicstyle_id_musicstyle", nullable = false)
    @Id
    public Integer getMusicstyleIdMusicstyle() {
        return musicstyleIdMusicstyle;
    }

    public void setMusicstyleIdMusicstyle(Integer musicstyleIdMusicstyle) {
        this.musicstyleIdMusicstyle = musicstyleIdMusicstyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManyUsersHasManyMusicstylesPK that = (ManyUsersHasManyMusicstylesPK) o;

        if (userIdUser != null ? !userIdUser.equals(that.userIdUser) : that.userIdUser != null) return false;
        if (musicstyleIdMusicstyle != null ? !musicstyleIdMusicstyle.equals(that.musicstyleIdMusicstyle) : that.musicstyleIdMusicstyle != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userIdUser != null ? userIdUser.hashCode() : 0;
        result = 31 * result + (musicstyleIdMusicstyle != null ? musicstyleIdMusicstyle.hashCode() : 0);
        return result;
    }
}
