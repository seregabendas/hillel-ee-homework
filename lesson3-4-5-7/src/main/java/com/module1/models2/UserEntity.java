package com.module1.models2;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER", schema = "PUBLIC")
public class UserEntity {
    private Integer id;
    private String name;
    private CityEntity city;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "city_id")
    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, city);
    }
}
