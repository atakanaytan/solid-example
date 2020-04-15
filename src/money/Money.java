package money;

public class Money {


    private double value;
    private Currency currency;


    public Money(double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Money{");
        sb.append("value=").append(value);
        sb.append(", currency=").append(currency);
        sb.append('}');
        return sb.toString();
    }

}
