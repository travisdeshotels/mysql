package tk.codedojo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import tk.codedojo.beans.Restaurant;
import tk.codedojo.util.HibernateUtil;

public class RestaurantDao {
    private HibernateUtil hu = new HibernateUtil();

    public void saveRestaurant(Restaurant r){
        Session session = hu.getSession();
        Transaction tx = session.beginTransaction();
        session.save(r);
        tx.commit();
        session.close();
    }
}
