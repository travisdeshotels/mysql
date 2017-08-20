package tk.codedojo;

import org.junit.Test;
import tk.codedojo.beans.*;
import tk.codedojo.dao.InvoiceItemDao;
import tk.codedojo.dao.MasterDao;

public class InvoiceItemTest {
    InvoiceItemDao dao = new InvoiceItemDao();
    MasterDao masterDao = new MasterDao();

    @Test
    public void testSaveInvoiceItem(){
        masterDao.clearDB();
        InvoiceItem item = new InvoiceItem();
        Invoice invoice = new Invoice();
        invoice.setCustomer(setCustomer(setCustomerContactInfo()));
        item.setItem(setFoodItem(setRestaurant(setRestaurantContactInfo())));
        item.setQuantity(1);
        item.setInvoice(invoice);

        this.dao.saveInvoiceItem(item);
    }

    private FoodItem setFoodItem(Restaurant r){
        FoodItem foodItem = new FoodItem();
        foodItem.setRestaurant(r);
        foodItem.setPrice(2f);
        foodItem.setDescription("Tasty");
        foodItem.setName("item");
        foodItem.setSpecial(true);
        foodItem.setSoldOut(false);

        return foodItem;
    }

    private ContactInfo setRestaurantContactInfo(){
        ContactInfo info = new ContactInfo();
        info.setStreet("123 street");
        info.setCity("Washington");
        info.setState("LA");
        info.setZip("55555");
        info.setEmail("food@aol.com");
        info.setPhone("784");

        return info;
    }

    private Restaurant setRestaurant(ContactInfo info){
        Restaurant r = new Restaurant();
        r.setName("FOOD IS GOOD");
        r.setAddress(info);

        return r;
    }

    private ContactInfo setCustomerContactInfo(){
        ContactInfo info = new ContactInfo();
        info.setStreet("customer st");
        info.setCity("Ville Platte");
        info.setState("LA");
        info.setZip("90201");
        info.setEmail("e@ma.il");
        info.setPhone("6");

        return info;
    }

    private Customer setCustomer(ContactInfo info){
        Customer customer = new Customer();
        customer.setUsername("user");
        customer.setPassword(customer.salt("p4ssw0rd"));
        customer.setFirstName("bob");
        customer.setLastName("lastName");
        customer.setContactInfo(info);

        return customer;
    }
}
