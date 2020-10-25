package pl.sgnit.homeworkweek1shop.component;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.sgnit.homeworkweek1shop.model.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("start")
public class Basket {

    private List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        if (!(product.getName() == null || product.getName().isBlank()) && product.getPrice() > 0) {
            productList.add(product);
        }
    }

    public double summaryValue() {
        return productList.stream().mapToDouble(product -> product.getPrice()).sum();
    }
}
