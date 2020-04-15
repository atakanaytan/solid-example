package payment.integrator;

import basket.BasketItem;
import basket.BasketType;
import basketItem.collector.BasketItemCollector;
import basketItem.collector.TotalBasketItemFinder;
import money.Money;
import payment.provider.PaymentProvider;
import shoppingChart.ShoppingChart;

import java.util.List;

public class ClassifiedPaymentIntegrator implements PaymentIntegrator{

    private PaymentProvider paymentProvider;
    private BasketType type;

    public ClassifiedPaymentIntegrator(PaymentProvider paymentProvider, BasketType type) {

        this.paymentProvider = paymentProvider;
        this.type = type;
    }

    @Override
    public int makePayment(ShoppingChart shoppingChart) {

        List<BasketItem> items = BasketItemCollector.collectBasketItems(type, shoppingChart);

        Money total = TotalBasketItemFinder.sum(items);

        int chargeId = paymentProvider.charge(total);

        return chargeId;
    }

}
