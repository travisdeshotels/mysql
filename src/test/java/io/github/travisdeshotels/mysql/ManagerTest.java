package io.github.travisdeshotels.mysql;

import org.junit.Test;
import io.github.travisdeshotels.mysql.beans.Manager;
import io.github.travisdeshotels.mysql.beans.Restaurant;
import io.github.travisdeshotels.mysql.dao.ManagerDao;
import io.github.travisdeshotels.mysql.dao.RestaurantDao;

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
