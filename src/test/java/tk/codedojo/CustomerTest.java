package tk.codedojo;

import org.junit.Test;
import tk.codedojo.beans.ContactInfo;
import tk.codedojo.beans.Customer;
import tk.codedojo.beans.User;
import tk.codedojo.dao.ContactInfoDao;
import tk.codedojo.dao.CustomerDao;

public class CustomerTest {
    private CustomerDao dao = new CustomerDao();

    @Test
    public void testSaveCustomer(){
        Customer c = new Customer();
        c.setUserName("bob");
        c.setPassword(c.salt("p4ssw0rd"));
        c.setFirstName("bob");
        c.setLastName("pski");
        ContactInfo info = new ContactInfo();
        info.setStreet("my street");
        info.setCity("my city");
        info.setState("LA");
        info.setZip("99999");
        info.setPhone("3378675309");
        info.setEmail("leaveme@alo.ne");
        new ContactInfoDao().saveContactInfo(info);
        c.setContactInfo(info);
        dao.saveCustomer(c);
    }
}
