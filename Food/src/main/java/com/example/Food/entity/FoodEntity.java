package com.example.Food.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "FOOD_TABLE")
public class FoodEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) // Database primary key alanında database uniqe değeri 1 arttırıyor
    @Column(name = "Id")
    private Long id  ;
    @Column(name = "TİTLE")
    private String title ;
    @Column(name = "DESCRİPTİON")
    private  String description;
    @Column(name = "CREATEDATE")
    private Date createDate;
    @Lob
    @Column(name = "FOODDETAİLS")
    private String foodDetails;
//    private List<String> foooDetails = new ArrayList<>();
   @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFoodDetails() {
        return foodDetails;
    }

    public void setFoodDetails(String foodDetails) {
        this.foodDetails = foodDetails;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
