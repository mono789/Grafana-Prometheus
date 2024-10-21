package com.udea.graphqludea.controller;

import com.udea.graphqludea.entity.Payment;
import com.udea.graphqludea.entity.PaymentMethod;
import com.udea.graphqludea.service.PaymentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @QueryMapping
    public List<PaymentMethod> allPaymentMethods() {
        return paymentService.getAllPaymentMethods();
    }

    @QueryMapping
    public PaymentMethod paymentMethodById(@Argument Long id) {
        return paymentService.getPaymentMethodById(id);
    }

    @QueryMapping
    public List<Payment> allPayments() {
        return paymentService.getAllPayments();
    }

    @QueryMapping
    public Payment paymentById(@Argument Long id) {
        return paymentService.getPaymentById(id);
    }

    @MutationMapping
    public PaymentMethod addPaymentMethod(@Argument String cardNumber, @Argument String cvv,
                                          @Argument String expirationDate, @Argument String cardHolderName) {
        return paymentService.addPaymentMethod(cardNumber, cvv, expirationDate, cardHolderName);
    }

    @MutationMapping
    public Payment payReservation(@Argument Long reservationId, @Argument Long paymentMethodId,
                                  @Argument Double amount) {
        return paymentService.payReservation(reservationId, paymentMethodId, amount);
    }
}

