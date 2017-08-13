package tk.codedojo;

import org.junit.Test;
import tk.codedojo.beans.FoodItem;
import tk.codedojo.beans.Restaurant;
import tk.codedojo.dao.FoodItemDao;

public class FoodItemTest {
    FoodItemDao dao = new FoodItemDao();

    @Test
    public void testSaveFoodItem(){
        FoodItem item = new FoodItem();
        item.setName("Chaudin");
        item.setDescription("Don't ask, but it's tasty");
        item.setPrice(3.5f);

        Restaurant r = new Restaurant();
        r.setName("Teet's Food Store");
        r.setAddress(null);

        item.setRestaurant(r);
        dao.saveFoodItem(item);
    }
}
