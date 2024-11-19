package service;

import com.challenge.Desafio_Injection_dependecy.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService implements TaxService {

    private static final double Tax_lower = 20.0;
    private static final double Tax_exclusive = 12.0;

    @Override
    public Double TaxOrder(Double amount) {
        if (amount < 100) {
            return amount + Tax_lower;
        } else if (amount >= 100 && amount <= 200.0) {
            return amount + Tax_exclusive;
        } else {
            return amount;
        }

    }

    @Override
    public Double Discount(Order order) {
        return (order.getBasic() * order.getDiscount()) / 100.0;
    }

}

