package main;

import basket.BasketItem;
import basket.BasketType;
import basketItem.builder.BasketItemBuilder;
import money.Currency;
import money.Money;
import payment.integrator.ClassifiedPaymentIntegrator;
import payment.integrator.ExpertiseReportPaymentIntegrator;
import payment.integrator.PaymentIntegrator;
import payment.provider.PaymentProvider;
import payment.provider.model.AssecoPaymentProvider;
import payment.provider.model.IyzicoPaymentProvider;
import payment.provider.model.PreviousPayment;
import product.ClassifiedProduct;
import product.ReportProduct;
import product.impl.CarExpertiseReport;
import product.impl.Classified;
import product.impl.Doping;
import product.impl.ReportItem;
import product.impl.type.DopingType;
import shoppingChart.ShoppingChart;
import tax.calculator.KDVTaxCalculator;
import tax.calculator.OTVTaxCalculator;
import tax.calculator.TaxCalculator;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Doping> dopings = new HashSet<Doping>();
        dopings.add(new Doping("Make it to the top Doping", new Money(100, Currency.TL), DopingType.UptoDate));
        ClassifiedProduct classified = new Classified("Car for sale", new Money(100000, Currency.TL), dopings);
        ((Classified)classified).setTitle("Secondhand Clean Car!");
        ((Classified)classified).setDescription("2014 secondhand Toyota corolla for sale!!");

        Set<ReportItem> extraServices = new HashSet<ReportItem>();
        extraServices.add(new ReportItem("Valet Service", new Money(40, Currency.TL)));
        extraServices.add(new ReportItem("Car Wash Service", new Money(30, Currency.TL)));
        ReportProduct expertiseReport = new CarExpertiseReport("Car wash service", new Money(250, Currency.TL), extraServices);

        List<TaxCalculator> taxCalculatorForClassified = Arrays.asList(new KDVTaxCalculator(), new OTVTaxCalculator());
        BasketItem classifiedBasketItem = BasketItemBuilder.buildBasketItem(classified, taxCalculatorForClassified, BasketType.Classified);

        List<TaxCalculator> taxCalculatorForExpertiseReport = Arrays.asList(new OTVTaxCalculator());
        BasketItem expertiseReportBasketItem = BasketItemBuilder.buildBasketItem(expertiseReport, taxCalculatorForExpertiseReport, BasketType.CarExpertiseReport);

        ShoppingChart shoppingChart = new ShoppingChart(new ArrayList<BasketItem>());
        shoppingChart.addBasketItem(classifiedBasketItem);
        shoppingChart.addBasketItem(expertiseReportBasketItem);

        printShoppingChart(shoppingChart);


        PaymentProvider iyzico = new IyzicoPaymentProvider(new HashMap<Integer, PreviousPayment>());
        PaymentProvider asseco = new AssecoPaymentProvider(new HashMap<Integer, PreviousPayment>());

        PaymentIntegrator classifiedIntegrator = new ClassifiedPaymentIntegrator(asseco, BasketType.Classified);
        PaymentIntegrator expertiseIntegrator  = new ExpertiseReportPaymentIntegrator(iyzico, BasketType.CarExpertiseReport);

        int chargeIdForClassified = classifiedIntegrator.makePayment(shoppingChart);
        int charIdForExpertiseReport = expertiseIntegrator.makePayment(shoppingChart);

        System.out.println("Payed bills:");
        System.out.println(asseco.loadInvoice(chargeIdForClassified));
        System.out.println(iyzico.loadInvoice(charIdForExpertiseReport));
    }


    private static void printShoppingChart(ShoppingChart shoppingChart) {

        for (BasketItem basketItem : shoppingChart.getBasketItemList()) {
            System.out.println(basketItem);
        }

        System.out.println();
    }


}
