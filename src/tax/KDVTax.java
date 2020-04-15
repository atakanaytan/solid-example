package tax;

import money.Money;

public class KDVTax implements Tax{

    public String name;

    public Money value;

    public KDVTax(String name, Money value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Money getTaxValue() {
        return this.value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KDVTax{");
        sb.append("name='").append(name).append('\'');
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
