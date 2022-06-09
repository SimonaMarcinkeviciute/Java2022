package lt.codeacademy.service;

import lt.codeacademy.entity.Employer;
import lt.codeacademy.entity.Invoice;
import lt.codeacademy.repository.InvoiceRepository;

import java.util.List;

public class InvoiceService {
    private final InvoiceRepository repository;

    public InvoiceService() {
        repository = new InvoiceRepository();
    }

    public void createInvoice(Invoice invoice) {
        repository.createInvoice(invoice);
    }

    public List<Invoice> getInvoice() {
        return repository.getInvoice();
    }

    public void deleteInvoice(Invoice invoice) {
        repository.deleteInvoice(invoice);

    }
}
