package jhotel;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @RequestMapping("/")
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/newcustomer",method = RequestMethod.POST)
    public Customer newCust(@RequestParam(value="name") String name,@RequestParam(value="email") String email,@RequestParam(value="password") String password) {
        int x = 2000;
        int y = 1;
        int z = 1;

        Customer customer = new Customer(name,z,y,x,email,password);
        try {
            DatabaseCustomer.addCustomer(customer);
        } catch(PelangganSudahAdaException ex) {
            ex.getMessage();
            return null;
        }

        return customer;
    }

    @RequestMapping("/getcustomer/{id}")
    public Customer getCust(@PathVariable int id) {
        Customer customer = DatabaseCustomer.getCustomer(id);
        return customer;
    }

    @RequestMapping(value = "/logincust",method = RequestMethod.POST)
    public Customer loginCust(@RequestParam(value = "email") String email,@RequestParam(value = "password") String password ){
        return DatabaseCustomer.getCustomerLogin(email,password);
    }
}
