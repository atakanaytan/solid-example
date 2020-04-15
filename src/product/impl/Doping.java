package product.impl;

import money.Money;
import product.Product;
import product.impl.type.DopingType;

import java.util.Objects;

public class Doping implements Product {

    private String name;
    private Money price;
    private DopingType type;

    public Doping(String name, Money price, DopingType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Money getPrice() {
        return this.price;
    }

    public DopingType getType() {
        return type;
    }

    public void setType(DopingType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doping)) return false;
        Doping doping = (Doping) o;
        return Objects.equals(getName(), doping.getName()) &&
                Objects.equals(getPrice(), doping.getPrice()) &&
                getType() == doping.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getType());
    }

}
