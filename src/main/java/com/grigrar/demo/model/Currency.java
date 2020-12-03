package com.grigrar.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Table
public class Currency {
    @Id
    @GeneratedValue
    private Integer id;

    public Currency(@NotBlank String name, @NotBlank BigDecimal rate) {
        this.name = name;
        this.value = rate;
    }

    public String name;
    @Column(name="value", precision=12, scale=4, nullable = false)
    public BigDecimal value;

    public Currency() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String country) {
        this.name = country;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal rate) {
        this.value =rate;;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
