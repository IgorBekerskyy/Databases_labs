package com.bekerskyy.model;

import com.bekerskyy.annotation.Colomn;
import com.bekerskyy.annotation.Primary_key;
import com.bekerskyy.annotation.Table;

import javax.persistence.*;

@Table(name = "bonus_account")
@Entity
public class BonusAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Colomn(name = "id")
    private int id;

    @Colomn(name = "type")
    private String type;

    @Colomn(name = "promocode")
    private String promocode;

    public BonusAccount(int id, String type, String promocode) {
        this.id = id;
        this.type = type;
        this.promocode = promocode;
    }

    public BonusAccount(String type, String promocode) {
        this(-1, type, promocode);
    }

    public BonusAccount() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPromocode() {
        return promocode;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }

    @Override
    public String toString() {
        return
                "\nid=" + id +
                        ",\n type='" + type + '\'' +
                        ",\n promocode='" + promocode + '\'' +
                        '}';
    }
}

