package tk.codedojo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tk.codedojo.beans.Customer;
import tk.codedojo.exception.DuplicateUserNameException;
import tk.codedojo.util.HibernateUtil;

import java.util.List;

public class CustomerDao {
    private HibernateUtil hu = new HibernateUtil();

    public void saveCustomer(Customer c){
        Session session = hu.getSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();
    }

    public Customer getCustomerByUserName(String userName) throws DuplicateUserNameException{
        Session session = hu.getSession();
        String hql = "FROM tk.codedojo.beans.Customer as C WHERE C.userName = :c_name";
        Query query = session.createQuery(hql);
        query.setParameter("c_name", userName);
        List<Customer> customers = query.list();
        if (customers.size() > 1){
            throw new DuplicateUserNameException("Duplicate userName was found! " + customers.get(0).getUserName());
        }
        return customers.get(0);
    }
}
