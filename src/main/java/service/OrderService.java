package service;

import com.challenge.Desafio_Injection_dependecy.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private TaxService taxService;

    public OrderService(TaxService taxService) {
        this.taxService = taxService;
    }


    public Double Total(Order order) {
        double descontoplusvalue = taxService.Discount(order);
        double payment = order.getBasic() - descontoplusvalue;
        double result = taxService.TaxOrder(payment);
        return result;
    }
}
