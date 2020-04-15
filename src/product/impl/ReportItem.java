package product.impl;

import money.Money;
import product.Product;

public class ReportItem implements Product {

    private String name;

    private Money price;

    public ReportItem(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Money getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReportItem{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
