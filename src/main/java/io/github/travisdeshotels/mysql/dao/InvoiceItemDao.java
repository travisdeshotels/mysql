package io.github.travisdeshotels.mysql.dao;

import io.github.travisdeshotels.mysql.beans.InvoiceItem;
import io.github.travisdeshotels.mysql.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InvoiceItemDao {
    HibernateUtil hu = new HibernateUtil();

    public void saveInvoiceItem(InvoiceItem item){
        Session session = hu.getSession();
        Transaction tx = session.beginTransaction();
        session.save(item);
        tx.commit();
        session.close();
    }
}
