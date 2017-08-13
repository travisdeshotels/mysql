package tk.codedojo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import tk.codedojo.beans.FoodItem;
import tk.codedojo.util.HibernateUtil;

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
