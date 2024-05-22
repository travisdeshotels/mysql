package io.github.travisdeshotels.mysql.dao;

import io.github.travisdeshotels.mysql.beans.Manager;
import io.github.travisdeshotels.mysql.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManagerDao {
    private HibernateUtil hu = new HibernateUtil();

    public void saveManager(Manager m){
        Session session = hu.getSession();
        Transaction tx = session.beginTransaction();
        session.save(m);
        tx.commit();
        session.close();
    }
}
