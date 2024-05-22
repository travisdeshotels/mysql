package io.github.travisdeshotels.mysql.util;

import io.github.travisdeshotels.mysql.beans.ContactInfo;
import io.github.travisdeshotels.mysql.beans.Customer;
import io.github.travisdeshotels.mysql.beans.FoodItem;
import io.github.travisdeshotels.mysql.beans.Invoice;
import io.github.travisdeshotels.mysql.beans.InvoiceItem;
import io.github.travisdeshotels.mysql.beans.Manager;
import io.github.travisdeshotels.mysql.beans.Restaurant;
import io.github.travisdeshotels.mysql.beans.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            Configuration conf = new Configuration().configure();
			conf.setProperty("hibernate.connection.url", System.getenv("DB_URL"));
			conf.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"));
			conf.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"));
            conf.addAnnotatedClass(ContactInfo.class);
            conf.addAnnotatedClass(Restaurant.class);
            conf.addAnnotatedClass(FoodItem.class);
            conf.addAnnotatedClass(Customer.class);
            conf.addAnnotatedClass(Manager.class);
            conf.addAnnotatedClass(Invoice.class);
            conf.addAnnotatedClass(InvoiceItem.class);
            conf.addAnnotatedClass(User.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
            sessionFactory = conf.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    public Session getSession(){
        return this.getSessionFactory().openSession();
    }
}
