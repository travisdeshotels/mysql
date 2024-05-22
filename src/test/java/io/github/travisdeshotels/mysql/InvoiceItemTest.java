package io.github.travisdeshotels.mysql;

import io.github.travisdeshotels.mysql.beans.ContactInfo;
import io.github.travisdeshotels.mysql.beans.Customer;
import io.github.travisdeshotels.mysql.beans.FoodItem;
import io.github.travisdeshotels.mysql.beans.Invoice;
import io.github.travisdeshotels.mysql.beans.InvoiceItem;
import io.github.travisdeshotels.mysql.beans.Restaurant;
import io.github.travisdeshotels.mysql.dao.CustomerDao;
import io.github.travisdeshotels.mysql.dao.InvoiceItemDao;
import io.github.travisdeshotels.mysql.dao.MasterDao;
import io.github.travisdeshotels.mysql.dao.RestaurantDao;
import org.junit.Test;
import io.github.travisdeshotels.mysql.exception.DuplicateUserNameException;

import java.util.List;

import static org.junit.Assert.*;

public class InvoiceItemTest {
    InvoiceItemDao dao = new InvoiceItemDao();
    MasterDao masterDao = new MasterDao();

    @Test
    public void testSaveInvoiceItem() throws DuplicateUserNameException{
        masterDao.clearDB();
        InvoiceItem item = new InvoiceItem();
        Invoice invoice = new Invoice();
        invoice.setCustomer(setCustomer(setCustomerContactInfo()));
        item.setItem(setFoodItem(setRestaurant(setRestaurantContactInfo())));
        item.setQuantity(1);
        item.setInvoice(invoice);

        this.dao.saveInvoiceItem(item);
        validateData();
    }

    private void validateData() throws DuplicateUserNameException{
        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.getCustomerByUserName("user");
        validateCustomer(customer);

        RestaurantDao restaurantDao = new RestaurantDao();
        Restaurant restaurant = restaurantDao.getRestaurantByName("FOOD IS GOOD");
        validateRestaurant(restaurant);
    }


    private void validateRestaurant(Restaurant restaurant){
        ContactInfo contactInfo = restaurant.getAddress();
        assertEquals(contactInfo.getStreet(), "123 street");
        assertEquals(contactInfo.getCity(), "Washington");
        assertEquals(contactInfo.getState(), "LA");
        assertEquals(contactInfo.getZip(), "55555");
        assertEquals(contactInfo.getEmail(), "food@aol.com");
        assertEquals(contactInfo.getPhone(), "784");
        List<FoodItem> foodItems = restaurant.getMenu();
        FoodItem foodItem = foodItems.get(0);
        assertEquals(foodItem.getPrice(), 2f, .1);
        assertEquals(foodItem.getDescription(), "Tasty");
        assertEquals(foodItem.getName(), "item");
        assertEquals(foodItem.isSpecial(), true);
        assertEquals(foodItem.isSoldOut(), false);
    }

    private void validateCustomer(Customer customer){
        assertEquals(customer.getLastName(), "lastName");
        assertEquals(customer.getFirstName(), "bob");

        ContactInfo contactInfo = customer.getContactInfo();
        assertEquals(contactInfo.getStreet(),"customer st");
        assertEquals(contactInfo.getCity(), "Ville Platte");
        assertEquals(contactInfo.getState(), "LA");
        assertEquals(contactInfo.getZip(), "90201");
        assertEquals(contactInfo.getEmail(), "e@ma.il");
        assertEquals(contactInfo.getPhone(), "6");

        validateInvoice(customer.getOrders().get(0));
    }

    private void validateInvoice(Invoice invoice){
        assertEquals(invoice.getInvoiceItems().get(0).getItem().getRestaurant().getName(), "FOOD IS GOOD");
        InvoiceItem invoiceItem = invoice.getInvoiceItems().get(0);
        assertEquals(invoiceItem.getItem().getPrice(), 2f, .1);
        assertEquals(invoiceItem.getItem().getDescription(), "Tasty");
        assertEquals(invoiceItem.getItem().getName(), "item");
        assertEquals(invoiceItem.getQuantity(), 1);
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
        customer.setUserName("user");
        customer.setPassword(customer.salt("p4ssw0rd"));
        customer.setFirstName("bob");
        customer.setLastName("lastName");
        customer.setContactInfo(info);

        return customer;
    }
}
