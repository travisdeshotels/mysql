package tk.codedojo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import tk.codedojo.beans.Customer;
import tk.codedojo.util.HibernateUtil;

public class CustomerDao {
    private HibernateUtil hu = new HibernateUtil();

    public void saveCustomer(Customer c){
        Session session = hu.getSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();
    }
}
