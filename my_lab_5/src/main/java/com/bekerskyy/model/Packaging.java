package com.bekerskyy.model;

import com.bekerskyy.annotation.Colomn;
import com.bekerskyy.annotation.Primary_key;
import com.bekerskyy.annotation.Table;
import javax.persistence.*;
@Table(name = "packaging")
@Entity
public class Packaging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Colomn(name = "id")
    private int id;

    @Colomn(name = "name")
    private String name;

    @Colomn(name = "for_a_gift")
    private Boolean for_a_gift;

    public Packaging(int id, String name, Boolean for_a_gift) {
        this.id = id;
        this.name = name;
        this.for_a_gift = for_a_gift;
    }

    public Packaging(String name, Boolean for_a_gift) {
        this(-1, name, for_a_gift);

    }

    public Packaging() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFor_a_gift() {
        return for_a_gift;
    }

    public void setFor_a_gift(Boolean for_a_gift) {
        this.for_a_gift = for_a_gift;
    }

    @Override
    public String toString() {
        return
                "\nid=" + id +
                        ",\n name='" + name + '\'' +
                        ",\n for_a_gift='" + for_a_gift + '\'' +
                        '}';
    }
}

