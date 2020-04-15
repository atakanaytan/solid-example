package product;

import product.impl.ReportItem;

import java.util.List;

public interface ReportProduct extends Product{

    public void addReportItem(ReportItem reportItem);
    public void setPackages(List<String > packages);
}
