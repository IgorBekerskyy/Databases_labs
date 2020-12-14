package com.bekerskyy.model;

import com.bekerskyy.annotation.Colomn;
import com.bekerskyy.annotation.Primary_key;
import com.bekerskyy.annotation.Table;

import javax.persistence.*;

@Table(name = "city")
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Colomn(name = "id")
    private int id;

    @Colomn(name = "name")
    private String name;

    @Colomn(name = "region_name")
    private String region_name;

    public City(int id, String name, String region_name) {
        this.id = id;
        this.name = name;
        this.region_name = region_name;
    }

    public City(String name, String region_name) {
        this(-1, name, region_name);

    }

    public City() {

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

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    @Override
    public String toString() {
        return
                "\nid=" + id +
                        ",\n name='" + name + '\'' +
                        ",\n region_name='" + region_name + '\'' +
                        '}';
    }
}


