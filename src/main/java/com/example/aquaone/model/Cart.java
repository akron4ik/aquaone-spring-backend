package com.example.aquaone.model;

import com.example.aquaone.HasId;
import com.example.aquaone.util.DateTimeUtil;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "cart")
@Transactional
public class Cart extends AbstractBaseEntity implements HasId {

   @Column(name = "date", nullable = false)
   @NotNull
   @DateTimeFormat(pattern = DateTimeUtil.DATE_TIME_PATTERN)
   private LocalDateTime date;

   @NotNull
   @Column(name = "phone")
   private String phone;

   @NotNull
   @Column(name = "surname")
   private String surname;

   @NotNull
   @Column(name = "price", nullable = false)
   @Range(min = 10, max = 100000)
   private Integer price;

   @Column(name = "comment")
   private String comment;

   public Cart(){
   }

   public Cart(Cart c){
        this(c.getId(), c.getDate(), c.getPhone(), c.getSurname(), c.getPrice(), c.getComment());
    }

   public Cart(Integer id, LocalDateTime date, String phone, String surname, int price, String comment){
        super(id);
        this.date = date;
        this.phone = phone;
        this.surname = surname;
        this.price = price;
        this.comment = comment;
   }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
