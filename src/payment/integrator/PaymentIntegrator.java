package payment.integrator;

import shoppingChart.ShoppingChart;

public interface PaymentIntegrator {

    public int makePayment(ShoppingChart shoppingChart);
}
