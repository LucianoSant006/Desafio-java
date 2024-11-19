package com.challenge.Desafio_Injection_dependecy.entities;

import org.springframework.stereotype.Component;
import java.util.Objects;

@Component
public class Order {
    private Integer code;
    private Double basic;
    private Double discount;

    public Order(){

    }

    public Order(Integer code, Double basic, Double discount) {
        this.code = code;
        this.basic = basic;
        this.discount = discount;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Double getBasic() {
        return basic;
    }

    public void setBasic(Double basic) {
        this.basic = basic;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discont) {
        this.discount = discont;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(code, order.code) && Objects.equals(basic, order.basic) && Objects.equals(discount, order.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, basic, discount);
    }
}
