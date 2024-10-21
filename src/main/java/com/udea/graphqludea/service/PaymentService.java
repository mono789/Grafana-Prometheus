package com.udea.graphqludea.service;

import com.udea.graphqludea.entity.Payment;
import com.udea.graphqludea.entity.PaymentMethod;
import com.udea.graphqludea.entity.Reservation;
import com.udea.graphqludea.repository.PaymentMethodRepository;
import com.udea.graphqludea.repository.PaymentRepository;
import com.udea.graphqludea.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final ReservationRepository reservationRepository;

    public PaymentService(PaymentRepository paymentRepository, PaymentMethodRepository paymentMethodRepository, ReservationRepository reservationRepository) {
        this.paymentRepository = paymentRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.reservationRepository = reservationRepository;
    }

    public PaymentMethod addPaymentMethod(String cardNumber, String cvv, String expirationDate, String cardHolderName) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setCardNumber(cardNumber);
        paymentMethod.setCvv(cvv);
        paymentMethod.setExpirationDate(expirationDate);
        paymentMethod.setCardHolderName(cardHolderName);
        return paymentMethodRepository.save(paymentMethod);
    }

    public Payment payReservation(Long reservationId, Long paymentMethodId, Double amount) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        PaymentMethod paymentMethod = paymentMethodRepository.findById(paymentMethodId)
                .orElseThrow(() -> new RuntimeException("Payment method not found"));

        Payment payment = new Payment();
        payment.setReservation(reservation);
        payment.setPaymentMethod(paymentMethod);
        payment.setAmount(amount);
        payment.setPaymentStatus("Paid");

        return paymentRepository.save(payment);
    }

    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    public PaymentMethod getPaymentMethodById(Long id) {
        return paymentMethodRepository.findById(id).orElse(null);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

}
