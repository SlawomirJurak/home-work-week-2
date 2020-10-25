package pl.sgnit.homeworkweek1shop.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.sgnit.homeworkweek1shop.component.Basket;
import pl.sgnit.homeworkweek1shop.model.Product;

import java.util.Random;

@Service
public class ShopService {

    private final Basket basket;

    public ShopService(Basket basket) {
        this.basket = basket;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startEvent() {
        basket.addProduct(new Product("P1", generatePrice()));
        basket.addProduct(new Product("P2", generatePrice()));
        basket.addProduct(new Product("P3", generatePrice()));
        basket.addProduct(new Product("P4", generatePrice()));
        basket.addProduct(new Product("P5", generatePrice()));
        System.out.println("Summary value: " + String.format("%.2f", basket.summaryValue()));
    }

    private double generatePrice() {
        Random random = new Random();

        return random.nextInt(251)+50;
    }
}
