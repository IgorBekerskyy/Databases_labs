package com.bekerskyy.model;

import com.bekerskyy.annotation.Colomn;
import com.bekerskyy.annotation.Primary_key;
import com.bekerskyy.annotation.Table;

@Table(name = "good")
public class Good {

    @Primary_key
    @Colomn(name = "id")
    private int id;

    @Colomn(name = "name")
    private String name;

    @Colomn(name = "firm")
    private String firm;

    @Colomn(name = "description")
    private String description;

    @Colomn(name = "guarantee_in_months")
    private String guarantee_in_months;

    @Colomn(name = "response")
    private String response;

    @Colomn(name = "in_stock")
    private Boolean in_stock;


    public Good(int id, String name, String firm, String description, String guarantee_in_months,
                String response, Boolean in_stock ) {
        this.id = id;
        this.name = name;
        this.firm = firm;
        this.description = description;
        this.guarantee_in_months = guarantee_in_months;
        this.response = response;
        this.in_stock = in_stock;
    }

    public Good(String name, String firm, String description, String guarantee_in_months,
                String response, Boolean in_stock) {
        this(-1, name, firm, description, guarantee_in_months, response, in_stock);
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

    public String getFirm() {
        return firm;
    }
    public void setFirm(String firm) {
        this.firm = firm;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGuarantee_in_months() {
        return guarantee_in_months;
    }

    public void setGuarantee_in_months(String guarantee_in_months) {
        this.guarantee_in_months = guarantee_in_months;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Boolean getIn_Stock() {
        return in_stock;
    }

    public void setIn_stock(Boolean in_stock) {
        this.in_stock = in_stock;
    }

    @Override
    public String toString() {
        return
                "\nid=" + id +
                        ",\n name='" + name + '\'' +
                        ",\n firm='" + firm + '\'' +
                        ",\n description='" + description + '\'' +
                        ",\n guarantee_in_months='" + guarantee_in_months + '\'' +
                        ",\n response='" + response + '\'' +
                        ",\n in_stock='" + in_stock + '\'' +
                        '}';
    }
}

