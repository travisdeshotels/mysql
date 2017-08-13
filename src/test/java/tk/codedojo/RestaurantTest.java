package tk.codedojo;

import org.junit.Test;
import tk.codedojo.beans.ContactInfo;
import tk.codedojo.beans.Restaurant;
import tk.codedojo.dao.ContactInfoDao;
import tk.codedojo.dao.RestaurantDao;

public class RestaurantTest {
    RestaurantDao dao = new RestaurantDao();

    @Test
    public void testSaveRestaurant() {
        Restaurant r = new Restaurant();
        r.setName("IhazCI");
        ContactInfo info = new ContactInfo();
        info.setStreet("my street");
        info.setCity("my city");
        info.setState("LA");
        info.setZip("99999");
        info.setPhone("3378675309");
        info.setEmail("leaveme@alo.ne");
        new ContactInfoDao().saveContactInfo(info);
        r.setAddress(info);
        dao.saveRestaurant(r);
    }

    @Test
    public void testGetRestaurant() {
        Restaurant r = dao.getRestaurantByName("Test");
        assert r != null;
    }
}
