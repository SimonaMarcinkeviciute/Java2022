package lt.codeacademy.repository;

import lt.codeacademy.entity.Employer;
import lt.codeacademy.entity.Invoice;

import java.util.List;

public class InvoiceRepository extends AbstractRepository {

    public void createInvoice(Invoice invoice) {
        modifyEntity(session -> session.persist(invoice));
    }

    public List<Invoice> getInvoice() {
        return getValue(session -> session.createQuery("FROM Invoice", Invoice.class).list());
    }

    public void deleteInvoice(Invoice invoice) {
        modifyEntity(session -> session.delete(invoice));


    }
}
