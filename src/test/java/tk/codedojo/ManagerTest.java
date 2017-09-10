package tk.codedojo;

import org.junit.Test;
import tk.codedojo.beans.Manager;
import tk.codedojo.beans.Restaurant;
import tk.codedojo.dao.ManagerDao;
import tk.codedojo.dao.RestaurantDao;

public class ManagerTest {

    @Test
    public void testSaveManager(){
        ManagerDao dao = new ManagerDao();
        Restaurant r = new Restaurant();
        r.setName("T-Coons");
        new RestaurantDao().saveRestaurant(r);
        Manager m = new Manager();
        m.setUserName("myusername");
        m.setPassword(m.salt("p4ssw0rd"));
        m.setRestaurant(r);
        dao.saveManager(m);
    }
}
