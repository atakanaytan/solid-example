package basket;

import product.Product;
import tax.Tax;

import java.util.Set;

public class BasketItem {

    private Product product;
    private Set<Tax> taxList;
    private BasketType type;

    public BasketItem(Product product, Set<Tax> taxList, BasketType type) {
        this.product = product;
        this.taxList = taxList;
        this.type = type;
    }

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Set<Tax> getTaxList() {
        return taxList;
    }

    public void setTaxList(Set<Tax> taxList) {
        this.taxList = taxList;
    }

    public BasketType getType() {
        return type;
    }

    public void setType(BasketType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BasketItem{");
        sb.append("product=").append(product);
        sb.append(", taxList=").append(taxList);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
