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
        return this.name;
    }

    @Override
    public Money getPrice() {
        return this.price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Classified{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", dopingList=").append(dopingList);
        sb.append('}');
        return sb.toString();
    }
}
