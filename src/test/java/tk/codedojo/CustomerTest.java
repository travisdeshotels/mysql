package tk.codedojo;

import org.junit.Test;
import tk.codedojo.beans.Customer;
import tk.codedojo.beans.User;
import tk.codedojo.dao.CustomerDao;

public class CustomerTest {
    private CustomerDao dao = new CustomerDao();

    @Test
    public void testSaveCustomer(){
        Customer c = new Customer();
        c.setUsername("bob");
        c.setPassword(c.salt("p4ssw0rd"));
        c.setFirstName("bob");
        c.setLastName("pski");
        dao.saveCustomer(c);
    }
}
