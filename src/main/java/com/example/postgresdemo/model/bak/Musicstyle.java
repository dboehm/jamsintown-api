package com.example.postgresdemo.model.bak;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

//@Entity
public class Musicstyle {
    private Integer musicstyleId;
    private Collection<ManyJamtypeHasManyMusicstyle> manyJamtypeHasManyMusicstylesByMusicstyleId;
    private Collection<ManyUsersHasManyMusicstyles> manyUsersHasManyMusicstylesByMusicstyleId;

    @Id
    @Column(name = "musicstyle_id", nullable = false)
    public Integer getMusicstyleId() {
        return musicstyleId;
    }

    public void setMusicstyleId(Integer musicstyleId) {
        this.musicstyleId = musicstyleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Musicstyle that = (Musicstyle) o;

        if (musicstyleId != null ? !musicstyleId.equals(that.musicstyleId) : that.musicstyleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return musicstyleId != null ? musicstyleId.hashCode() : 0;
    }

    @OneToMany(mappedBy = "musicstyleByMusicstyleIdMusicstyle")
    public Collection<ManyJamtypeHasManyMusicstyle> getManyJamtypeHasManyMusicstylesByMusicstyleId() {
        return manyJamtypeHasManyMusicstylesByMusicstyleId;
    }

    public void setManyJamtypeHasManyMusicstylesByMusicstyleId(Collection<ManyJamtypeHasManyMusicstyle> manyJamtypeHasManyMusicstylesByMusicstyleId) {
        this.manyJamtypeHasManyMusicstylesByMusicstyleId = manyJamtypeHasManyMusicstylesByMusicstyleId;
    }

    @OneToMany(mappedBy = "musicstyleByMusicstyleIdMusicstyle")
    public Collection<ManyUsersHasManyMusicstyles> getManyUsersHasManyMusicstylesByMusicstyleId() {
        return manyUsersHasManyMusicstylesByMusicstyleId;
    }

    public void setManyUsersHasManyMusicstylesByMusicstyleId(Collection<ManyUsersHasManyMusicstyles> manyUsersHasManyMusicstylesByMusicstyleId) {
        this.manyUsersHasManyMusicstylesByMusicstyleId = manyUsersHasManyMusicstylesByMusicstyleId;
    }
}
