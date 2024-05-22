package io.github.travisdeshotels.mysql.dao;

import io.github.travisdeshotels.mysql.beans.Invoice;
import org.hibernate.Session;
import org.hibernate.Transaction;
import io.github.travisdeshotels.mysql.util.HibernateUtil;

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
