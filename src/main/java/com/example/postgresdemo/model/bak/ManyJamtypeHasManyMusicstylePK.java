package com.example.postgresdemo.model.bak;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ManyJamtypeHasManyMusicstylePK implements Serializable {
    private Integer jamtypeIdJamtype;
    private Integer musicstyleIdMusicstyle;

    @Column(name = "jamtype_id_jamtype", nullable = false)
    @Id
    public Integer getJamtypeIdJamtype() {
        return jamtypeIdJamtype;
    }

    public void setJamtypeIdJamtype(Integer jamtypeIdJamtype) {
        this.jamtypeIdJamtype = jamtypeIdJamtype;
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

        ManyJamtypeHasManyMusicstylePK that = (ManyJamtypeHasManyMusicstylePK) o;

        if (jamtypeIdJamtype != null ? !jamtypeIdJamtype.equals(that.jamtypeIdJamtype) : that.jamtypeIdJamtype != null)
            return false;
        if (musicstyleIdMusicstyle != null ? !musicstyleIdMusicstyle.equals(that.musicstyleIdMusicstyle) : that.musicstyleIdMusicstyle != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jamtypeIdJamtype != null ? jamtypeIdJamtype.hashCode() : 0;
        result = 31 * result + (musicstyleIdMusicstyle != null ? musicstyleIdMusicstyle.hashCode() : 0);
        return result;
    }
}
