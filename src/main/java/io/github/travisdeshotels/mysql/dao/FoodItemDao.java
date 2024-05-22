package io.github.travisdeshotels.mysql.dao;

import io.github.travisdeshotels.mysql.beans.FoodItem;
import io.github.travisdeshotels.mysql.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FoodItemDao {
    private HibernateUtil hu = new HibernateUtil();

    public void saveFoodItem(FoodItem item){
        Session session = hu.getSession();
        Transaction tx = session.beginTransaction();
        session.save(item);
        tx.commit();
        session.close();
    }
}
