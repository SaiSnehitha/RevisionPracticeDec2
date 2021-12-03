package com.example.revisionpracticedec2;

public class SelectedCart {
    private String name;
    private Double priceTotal;
    private int person;

    public SelectedCart(String name, Double priceTotal, int person) {
        this.name = name;
        this.priceTotal = priceTotal;
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }
}
