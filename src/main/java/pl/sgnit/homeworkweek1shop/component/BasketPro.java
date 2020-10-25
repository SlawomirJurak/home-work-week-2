package pl.sgnit.homeworkweek1shop.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("PRO")
public class BasketPro extends BasketPlus {

    @Value("${discount}")
    private double discountPercentage;

    @Override
    public double summaryValue() {
        return super.summaryValue() * (1-discountPercentage/100);
    }
}
