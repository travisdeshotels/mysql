package io.github.travisdeshotels.mysql;

import org.junit.Test;
import io.github.travisdeshotels.mysql.beans.FoodItem;
import io.github.travisdeshotels.mysql.beans.Restaurant;
import io.github.travisdeshotels.mysql.dao.FoodItemDao;

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
