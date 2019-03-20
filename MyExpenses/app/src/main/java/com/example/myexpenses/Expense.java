package com.example.myexpenses;

import java.util.Date;

public class Expense {

    private int id ;
    private String name ;
    private Float price ;

    public static Double total ;
    



    public Expense(){}
    public Expense( String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;

        this.total +=price ;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }



    public int getId() {
        return id;
    }

    public static void setTotal(Double total) {
        Expense.total = total;
    }

    public static Double getTotal() {
        return total;
    }
}
