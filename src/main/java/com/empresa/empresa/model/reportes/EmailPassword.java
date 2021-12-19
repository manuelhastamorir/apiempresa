package com.empresa.empresa.model.reportes;

import java.util.Date;

public class EmailPassword 
{
    private Integer id;
    private String identification;
    private String name;
    private Date birthtDay;
    private String monthBirthtDay;
    private String address;
    private String cellPhone;
    private String email;
    private String password;
    private String zone;
    private String type;
    public EmailPassword(Integer id, String identification, String name, Date birthtDay, String monthBirthtDay,
            String address, String cellPhone, String email, String password, String zone, String type) {
        this.id = id;
        this.identification = identification;
        this.name = name;
        this.birthtDay = birthtDay;
        this.monthBirthtDay = monthBirthtDay;
        this.address = address;
        this.cellPhone = cellPhone;
        this.email = email;
        this.password = password;
        this.zone = zone;
        this.type = type;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getIdentification() {
        return identification;
    }
    public void setIdentification(String identification) {
        this.identification = identification;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthtDay() {
        return birthtDay;
    }
    public void setBirthtDay(Date birthtDay) {
        this.birthtDay = birthtDay;
    }
    public String getMonthBirthtDay() {
        return monthBirthtDay;
    }
    public void setMonthBirthtDay(String monthBirthtDay) {
        this.monthBirthtDay = monthBirthtDay;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCellPhone() {
        return cellPhone;
    }
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getZone() {
        return zone;
    }
    public void setZone(String zone) {
        this.zone = zone;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
}
    