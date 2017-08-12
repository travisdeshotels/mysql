package tk.codedojo;

import org.junit.Test;
import tk.codedojo.beans.Restaurant;
import tk.codedojo.dao.RestaurantDao;

public class RestaurantTest {
    RestaurantDao dao = new RestaurantDao();

    @Test
    public void testCreateRestaurant() {
        Restaurant r = new Restaurant();
        r.setName("Test");
        dao.saveRestaurant(r);
    }
}
