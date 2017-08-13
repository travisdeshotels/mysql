package tk.codedojo;

import org.junit.Test;
import tk.codedojo.beans.FoodItem;
import tk.codedojo.beans.InvoiceItem;
import tk.codedojo.beans.Restaurant;
import tk.codedojo.dao.InvoiceItemDao;

public class InvoiceItemTest {
    InvoiceItemDao dao = new InvoiceItemDao();

    @Test
    public void testSaveInvoiceItem(){
        InvoiceItem item = new InvoiceItem();
        Restaurant r = new Restaurant();
        r.setName("FOOD IS GOOD");
        FoodItem foodItem = new FoodItem();
        foodItem.setRestaurant(r);
        foodItem.setPrice(2f);
        foodItem.setDescription("Tasty");
        foodItem.setName("item");
        item.setItem(foodItem);
        item.setQuantity(1);
        dao.saveInvoiceItem(item);
    }
}
