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
        return this.name;
    }

    @Override
    public Money getPrice() {
        return this.price;
    }

    @Override
    public void addReportItem(ReportItem reportItem) {
        this.extraServices.add(reportItem);
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CarExpertiseReport{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", packages=").append(packages);
        sb.append(", extraServices=").append(extraServices);
        sb.append('}');
        return sb.toString();
    }
}
