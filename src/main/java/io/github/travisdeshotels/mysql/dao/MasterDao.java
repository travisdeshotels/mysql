package io.github.travisdeshotels.mysql.dao;

import io.github.travisdeshotels.mysql.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MasterDao {
    private HibernateUtil hu = new HibernateUtil();

    public void clearDB(){
        String[] tables =
        {
            "InvoiceItem",
            "Invoice",
            "FoodItem",
            "Manager",
            "Restaurant",
            "Customer",
            "ContactInfo",
            "User"
        };
        for(String t: tables){
            executeUpdate("DELETE FROM " + t);
        }
    }
    private void executeUpdate(String hql){
        Session session = hu.getSession();
        Query query;
        Transaction tx = session.beginTransaction();
        query = session.createQuery(hql);
        query.executeUpdate();
        tx.commit();
    }
}
