package tk.codedojo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tk.codedojo.beans.Restaurant;
import tk.codedojo.util.HibernateUtil;

import java.util.List;

public class RestaurantDao {
    private HibernateUtil hu = new HibernateUtil();

    public void saveRestaurant(Restaurant r){
        Session session = hu.getSession();
        Transaction tx = session.beginTransaction();
        session.save(r);
        tx.commit();
        session.close();
    }

    public Restaurant getRestaurantByName(String name){
        Session session = hu.getSession();
        Query query;
        String hql;

        hql="FROM tk.codedojo.beans.Restaurant as R WHERE R.name = :r_name";
        query = session.createQuery(hql);
        query.setParameter("r_name", name);
        List<Restaurant> restaurants = query.list();
        return restaurants.get(0);
    }

}
