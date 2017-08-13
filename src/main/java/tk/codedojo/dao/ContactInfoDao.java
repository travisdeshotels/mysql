package tk.codedojo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import tk.codedojo.beans.ContactInfo;
import tk.codedojo.util.HibernateUtil;

public class ContactInfoDao {
    private HibernateUtil hu = new HibernateUtil();

    public void saveContactInfo(ContactInfo info){
        Session session = hu.getSession();
        Transaction tx = session.beginTransaction();
        session.save(info);
        tx.commit();
        session.close();
    }
}
