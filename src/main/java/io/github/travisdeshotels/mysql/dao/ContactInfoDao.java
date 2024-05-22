package io.github.travisdeshotels.mysql.dao;

import io.github.travisdeshotels.mysql.beans.ContactInfo;
import io.github.travisdeshotels.mysql.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
