package com.example.postgresdemo.model.bak;

import javax.persistence.*;

//@Entity
@Table(name = "many_users_has_many_musicstyles", schema = "users", catalog = "jamsintown")
@IdClass(ManyUsersHasManyMusicstylesPK.class)
public class ManyUsersHasManyMusicstyles {
    private Integer userIdUser;
    private Integer musicstyleIdMusicstyle;
    private User userByUserIdUser;
    private Musicstyle musicstyleByMusicstyleIdMusicstyle;

    @Id
    @Column(name = "user_id_user", nullable = false)
    public Integer getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(Integer userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Id
    @Column(name = "musicstyle_id_musicstyle", nullable = false)
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

        ManyUsersHasManyMusicstyles that = (ManyUsersHasManyMusicstyles) o;

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

    @ManyToOne
    @JoinColumn(name = "user_id_user", referencedColumnName = "user_id", nullable = false)
    public User getUserByUserIdUser() {
        return userByUserIdUser;
    }

    public void setUserByUserIdUser(User userByUserIdUser) {
        this.userByUserIdUser = userByUserIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "musicstyle_id_musicstyle", referencedColumnName = "musicstyle_id", nullable = false)
    public Musicstyle getMusicstyleByMusicstyleIdMusicstyle() {
        return musicstyleByMusicstyleIdMusicstyle;
    }

    public void setMusicstyleByMusicstyleIdMusicstyle(Musicstyle musicstyleByMusicstyleIdMusicstyle) {
        this.musicstyleByMusicstyleIdMusicstyle = musicstyleByMusicstyleIdMusicstyle;
    }
}
