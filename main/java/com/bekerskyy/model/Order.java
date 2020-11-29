package com.bekerskyy.model;

import com.bekerskyy.annotation.Colomn;
import com.bekerskyy.annotation.Primary_key;
import com.bekerskyy.annotation.Table;

@Table(name = "order")
public class Order {

    @Primary_key
    @Colomn(name = "id")
    private int id;

    @Colomn(name = "client_id")
    private String client_id;

    @Colomn(name = "salon_id")
    private String salon_id;

    @Colomn(name = "packaging_id")
    private String packaging_id;

    @Colomn(name = "delivery_in_days")
    private String delivery_in_days;

    @Colomn(name = "good_id")
    private String good_id;



    public Order(int id, String client_id, String salon_id, String packaging_id
    ,String delivery_in_days, String good_id) {
        this.id = id;
        this.client_id = client_id;
        this.salon_id = salon_id;
        this.packaging_id = packaging_id;
        this.delivery_in_days = delivery_in_days;
        this.good_id = good_id;

    }

    public Order( String client_id, String salon_id, String packaging_id,
                  String delivery_in_days, String good_id) {
        this(-1, client_id, salon_id, packaging_id, delivery_in_days, good_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getSalon_id() {
        return salon_id;
    }

    public void setSalon_id(String salon_id) {
        this.salon_id = salon_id;
    }

    public String getPackaging_id() {
        return packaging_id;
    }

    public void setPackaging_id(String packaging_id) {
        this.packaging_id = packaging_id;
    }

    public String getDelivery_in_days() {
        return delivery_in_days;
    }

    public void setDelivery_in_days(String delivery_in_days) {
        this.delivery_in_days = delivery_in_days;
    }

    public String getGood_id() {
        return good_id;
    }

    public void setGood_id(String good_id) {
        this.good_id = good_id;
    }

    @Override
    public String toString() {
        return
                "\n id=" + id +
                        ",\n  client_id='" + client_id + '\'' +
                        ",\n salon_id='" + salon_id + '\'' +
                        ",\n packaging_id='" + packaging_id + '\'' +
                        ",\n  delivery_in_days='" + delivery_in_days + '\'' +
                        ",\n good_id='" + good_id + '\'' +
                        '}';
    }
}

