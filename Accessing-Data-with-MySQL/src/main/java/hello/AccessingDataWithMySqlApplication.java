package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataWithMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataWithMySqlApplication.class, args);
	}
}



/*http://localhost:8080/booking/create?psngrName=Saurabh&destination=Jermany&departure=Mumbai
	http://localhost:8080/booking/read?bookingId=5
		http://localhost:8080/booking/delete?bookingId=4
			http://localhost:8080/booking/update?bookingId=5&psngrName=Suresh
				http://localhost:8080/booking/find-by-departure?departure=Pune*/



//sort
//http://localhost:8080/booking/listPageable?page=0&size=4&sort=psngrName