package tk.codedojo;

import org.junit.Test;
import tk.codedojo.beans.*;
import tk.codedojo.dao.InvoiceItemDao;

public class InvoiceTest {

    @Test
    public void testSaveInvoice(){
        Invoice invoice = new Invoice();
        invoice.setTotal(2f);

        Customer customer = new Customer();
        customer.setUsername("me");
        customer.setPassword(customer.salt("p4ssw0rd"));
        invoice.setCustomer(customer);

        Restaurant r = new Restaurant();
        r.setName("restaurant");
        FoodItem foodItem = new FoodItem();
        foodItem.setRestaurant(r);
        foodItem.setName("Chaudin");
        foodItem.setDescription("Don't ask: it's tasty");
        foodItem.setPrice(3.5f);
        InvoiceItem item = new InvoiceItem();
        item.setItem(foodItem);
        item.setInvoice(invoice);
        new InvoiceItemDao().saveInvoiceItem(item);
    }
}
