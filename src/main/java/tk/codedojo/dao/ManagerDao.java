package tk.codedojo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import tk.codedojo.beans.Manager;
import tk.codedojo.util.HibernateUtil;

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
