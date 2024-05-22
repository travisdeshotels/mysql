package io.github.travisdeshotels.mysql;

import io.github.travisdeshotels.mysql.beans.Customer;
import io.github.travisdeshotels.mysql.beans.FoodItem;
import io.github.travisdeshotels.mysql.beans.Invoice;
import io.github.travisdeshotels.mysql.beans.InvoiceItem;
import io.github.travisdeshotels.mysql.beans.Restaurant;
import org.junit.Test;
import io.github.travisdeshotels.mysql.dao.InvoiceItemDao;

public class InvoiceTest {

    @Test
    public void testSaveInvoice(){
        Invoice invoice = new Invoice();
        invoice.setTotal(2f);

        Customer customer = new Customer();
        customer.setUserName("me");
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
        item.setQuantity(1);
        item.setInvoice(invoice);
        new InvoiceItemDao().saveInvoiceItem(item);
    }
}
