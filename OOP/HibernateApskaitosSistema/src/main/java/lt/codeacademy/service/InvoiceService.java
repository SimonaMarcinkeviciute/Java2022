package lt.codeacademy.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import lt.codeacademy.entity.Employer;
import lt.codeacademy.entity.Invoice;
import lt.codeacademy.repository.InvoiceRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceService {

    InvoiceRepository invoiceRepository = new InvoiceRepository();

    public void createInvoice(LocalDateTime date, BigDecimal salary, boolean cashPayed), Long id {
        Invoice invoice = new Invoice(date, salary, cashPayed);
    }
}
