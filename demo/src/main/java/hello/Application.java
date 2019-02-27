package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {
	
    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
//        jdbcTemplate.execute("CREATE TABLE customers(" +
//                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
        
        jdbcTemplate.update("INSERT INTO customers(first_name, last_name) VALUES ('Maan','Alkhelewi')");

        
        String sql = "SELECT id, first_name, last_name FROM customers WHERE first_name = ?";
        List<Customer> customers = jdbcTemplate.query(
                sql, new Object[] { "Maan" },
                new CustomerMapper());
        
        System.out.println(customers.get(0).getFirstName());
    }
}
