package com.init.products.entitys;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="clients")
public class Clients {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "TelNumber", nullable = false, length = 50)
    private Integer telNumber;

    @Column(name = "Email", nullable = false, length = 50)
    private String email;

    @Column(name = "Address", nullable = false, length = 50)
    private String address;

    @Column(name = "CreationDate", nullable = false, length = 50)
    private Date creationDate;

    @Column(name = "UpdateDate", nullable = false, length = 50)
    private Date updateDate;

    @Column(name = "CreatedBy", nullable = false, length = 50)
    private String createdBy;

    @Column(name = "UpdatedBy", nullable = false, length = 50)
    private String updatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(Integer telNumber) {
        this.telNumber = telNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}



