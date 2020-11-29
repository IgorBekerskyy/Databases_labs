package com.bekerskyy.model;

import com.bekerskyy.annotation.Colomn;
import com.bekerskyy.annotation.Primary_key;
import com.bekerskyy.annotation.Table;

@Table(name = "client")
public class Client {

    @Primary_key
    @Colomn(name = "id")
    private int id;

    @Colomn(name = "surname")
    private String surname;

    @Colomn(name = "name")
    private String name;

    @Colomn(name = "birthday")
    private String birthday;

    @Colomn(name = "gender")
    private String gender;

    @Colomn(name = "adresse")
    private String adresse;

    @Colomn(name = "native_language")
    private String native_language;

    @Colomn(name = "zip_code")
    private String zip_code;

    @Colomn(name = "phone")
    private String phone;

    @Colomn(name = "email")
    private String email;


    @Colomn(name = "bonus_account_id")
    private String bonus_account_id;


    public Client(int id, String surname, String name, String birthday, String gender,
    String adresse, String native_language, String zip_code, String phone,
    String email,  String bonus_account_id ) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.adresse = adresse;
        this.native_language = native_language;
        this.zip_code = zip_code;
        this.phone = phone;
        this.email = email;
        this.bonus_account_id = bonus_account_id;

    }

    public Client(String surname, String name, String birthday, String gender,
                  String adresse, String native_language, String zip_code, String phone,
                  String email, String bonus_account_id) {
        this(-1, surname, name, birthday, gender,adresse, native_language, zip_code, phone,
                email, bonus_account_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
         this.gender= gender;
    }
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNative_language() {
        return native_language;
    }

    public void setNative_language(String native_language) {
        this.native_language = native_language;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone= phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBonus_account_id() {
        return bonus_account_id;
    }

    public void setBonus_account_id(String bonus_account_id) {
        this.bonus_account_id = bonus_account_id;
    }


    @Override
    public String toString() {
        return
                "\nid=" + id +
                        ",\n surname='" + surname + '\'' +
                        ",\n name='" + name + '\'' +
                        ",\n birthday='" + birthday + '\'' +
                        ",\n gender='" + gender + '\'' +
                        ",\n adresse='" + adresse + '\'' +
                        ",\n native_language='" + native_language + '\'' +
                        ",\n zip_code='" + zip_code + '\'' +
                        ",\n phone='" + phone + '\'' +
                        ",\n email='" + email + '\'' +
                        ",\n bonus_account_id='" + bonus_account_id + '\'' +
                        '}';
    }
}

