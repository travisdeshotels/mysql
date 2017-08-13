package tk.codedojo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import tk.codedojo.beans.InvoiceItem;
import tk.codedojo.util.HibernateUtil;

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
