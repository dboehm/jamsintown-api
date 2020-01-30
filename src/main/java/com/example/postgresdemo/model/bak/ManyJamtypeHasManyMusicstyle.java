package com.example.postgresdemo.model.bak;

import javax.persistence.*;

//@Entity
@Table(name = "many_jamtype_has_many_musicstyle", schema = "jams", catalog = "jamsintown")
@IdClass(ManyJamtypeHasManyMusicstylePK.class)
public class ManyJamtypeHasManyMusicstyle {
    private Integer jamtypeIdJamtype;
    private Integer musicstyleIdMusicstyle;
    private Jamtype jamtypeByJamtypeIdJamtype;
    private Musicstyle musicstyleByMusicstyleIdMusicstyle;

    @Id
    @Column(name = "jamtype_id_jamtype", nullable = false)
    public Integer getJamtypeIdJamtype() {
        return jamtypeIdJamtype;
    }

    public void setJamtypeIdJamtype(Integer jamtypeIdJamtype) {
        this.jamtypeIdJamtype = jamtypeIdJamtype;
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

        ManyJamtypeHasManyMusicstyle that = (ManyJamtypeHasManyMusicstyle) o;

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

    @ManyToOne
    @JoinColumn(name = "jamtype_id_jamtype", referencedColumnName = "jamtype_id", nullable = false)
    public Jamtype getJamtypeByJamtypeIdJamtype() {
        return jamtypeByJamtypeIdJamtype;
    }

    public void setJamtypeByJamtypeIdJamtype(Jamtype jamtypeByJamtypeIdJamtype) {
        this.jamtypeByJamtypeIdJamtype = jamtypeByJamtypeIdJamtype;
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
