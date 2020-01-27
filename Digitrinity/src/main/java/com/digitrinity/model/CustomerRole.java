package com.digitrinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_role")
public class CustomerRole {
    @Id
    @Column(name = "customer_role_id")
    private long customerRoleId;
    @Column(name = "customer_desc")
    private String customerDesc;
    @Column(name = "IGT")
    private int igt;
    @Column(name = "Telenor")
    private int telenor;


    public long getCustomerRoleId() {
        return customerRoleId;
    }

    public void setCustomerRoleId(long customerRoleId) {
        this.customerRoleId = customerRoleId;
    }


    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc;
    }


    public int getIgt() {
        return igt;
    }

    public void setIgt(int igt) {
        this.igt = igt;
    }


    public int getTelenor() {
        return telenor;
    }

    public void setTelenor(int telenor) {
        this.telenor = telenor;
    }

}
