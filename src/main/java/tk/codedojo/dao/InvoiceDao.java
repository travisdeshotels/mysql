package tk.codedojo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import tk.codedojo.beans.Invoice;
import tk.codedojo.util.HibernateUtil;

public class InvoiceDao {
    HibernateUtil hu = new HibernateUtil();

    public void saveInvoice(Invoice invoice){
        Session session = hu.getSession();
        Transaction tx = session.beginTransaction();
        session.save(invoice);
        tx.commit();
        session.close();
    }
}
