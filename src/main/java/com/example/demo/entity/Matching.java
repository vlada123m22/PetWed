package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Matching {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "from_pet_id")
    private Integer fromPetId;
    @Basic
    @Column(name = "to_pet_id")
    private Integer toPetId;
    @Basic
    @Column(name = "like_value")
    private Byte likeValue;
    @Basic
    @Column(name = "seen")
    private Byte seen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFromPetId() {
        return fromPetId;
    }

    public void setFromPetId(Integer fromPetId) {
        this.fromPetId = fromPetId;
    }

    public Integer getToPetId() {
        return toPetId;
    }

    public void setToPetId(Integer toPetId) {
        this.toPetId = toPetId;
    }

    public Byte getLikeValue() {
        return likeValue;
    }

    public void setLikeValue(Byte likeValue) {
        this.likeValue = likeValue;
    }

    public Byte getSeen() {
        return seen;
    }

    public void setSeen(Byte seen) {
        this.seen = seen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matching matching = (Matching) o;

        if (id != matching.id) return false;
        if (fromPetId != null ? !fromPetId.equals(matching.fromPetId) : matching.fromPetId != null) return false;
        if (toPetId != null ? !toPetId.equals(matching.toPetId) : matching.toPetId != null) return false;
        if (likeValue != null ? !likeValue.equals(matching.likeValue) : matching.likeValue != null) return false;
        if (seen != null ? !seen.equals(matching.seen) : matching.seen != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fromPetId != null ? fromPetId.hashCode() : 0);
        result = 31 * result + (toPetId != null ? toPetId.hashCode() : 0);
        result = 31 * result + (likeValue != null ? likeValue.hashCode() : 0);
        result = 31 * result + (seen != null ? seen.hashCode() : 0);
        return result;
    }
}
