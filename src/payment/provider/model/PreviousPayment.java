package payment.provider.model;

import money.Money;

import java.util.Date;

public class PreviousPayment {


    private Money value;
    private Date recordDate;


    public PreviousPayment(Money value, Date recordDate) {
        this.value = value;
        this.recordDate = recordDate;
    }

    public Money getValue() {
        return value;
    }

    public void setValue(Money value) {
        this.value = value;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PreviousPayment{");
        sb.append("value=").append(value);
        sb.append(", recordDate=").append(recordDate);
        sb.append('}');
        return sb.toString();
    }

}
