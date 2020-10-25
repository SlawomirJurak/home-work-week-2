package pl.sgnit.homeworkweek1shop.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("PLUS")
public class BasketPlus extends Basket {

    @Value("${vat}")
    private double vatPercentage;

    @Override
    public double summaryValue() {
        double vat = getVatPercentage() / 100;
        return getProductList().stream().mapToDouble(product -> product.getPrice() * (1 + vat)).sum();
    }

    public double getVatPercentage() {
        return vatPercentage;
    }
}
