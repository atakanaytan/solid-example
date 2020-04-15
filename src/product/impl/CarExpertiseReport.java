package product.impl;

import money.Money;
import product.ReportProduct;

import java.util.List;
import java.util.Set;

public class CarExpertiseReport implements ReportProduct {

    private String name;
    private Money price;

    private List<String> packages;
    private Set<ReportItem> extraServices;

    public CarExpertiseReport(String name, Money price, Set<ReportItem> extraServices) {
        this.name = name;
        this.price = price;
        this.extraServices = extraServices;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Money getPrice() {
        return price;
    }

    @Override
    public void addReportItem(ReportItem reportItem) {
        this.extraServices.add(reportItem);
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public List<String> getPackages() {
        return packages;
    }

    @Override
    public void setPackages(List<String> packages) {
        this.packages = packages;
    }

    public Set<ReportItem> getExtraServices() {
        return extraServices;
    }

    public void setExtraServices(Set<ReportItem> extraServices) {
        this.extraServices = extraServices;
    }


}
