package product.impl;

import money.Money;
import product.ClassifiedProduct;

import java.util.Set;

public class Classified implements ClassifiedProduct {

    private String name;
    private Money price;

    private String title;
    private String description;
    private Set<Doping> dopingList;

    public Classified(String name, Money price, Set<Doping> dopingList) {
        this.name = name;
        this.price = price;
        this.dopingList = dopingList;
    }

    @Override
    public void addDoping(Doping doping) {
        this.dopingList.add(doping);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Money getPrice() {
        return price;
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


}
