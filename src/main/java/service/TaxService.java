package service;

import com.challenge.Desafio_Injection_dependecy.entities.Order;
import org.springframework.stereotype.Component;

@Component
public interface TaxService {

    public Double TaxOrder(Double amount);

    public Double Discount(Order order);

}
