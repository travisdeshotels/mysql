package tk.codedojo.util;

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
            conf.addAnnotatedClass(tk.codedojo.beans.ContactInfo.class);
            conf.addAnnotatedClass(tk.codedojo.beans.Restaurant.class);
            conf.addAnnotatedClass(tk.codedojo.beans.FoodItem.class);
            conf.addAnnotatedClass(tk.codedojo.beans.Customer.class);
            conf.addAnnotatedClass(tk.codedojo.beans.Manager.class);
            conf.addAnnotatedClass(tk.codedojo.beans.Invoice.class);
            conf.addAnnotatedClass(tk.codedojo.beans.InvoiceItem.class);
            conf.addAnnotatedClass(tk.codedojo.beans.User.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
            sessionFactory = conf.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    public Session getSession(){
        return this.getSessionFactory().openSession();
    }
}
