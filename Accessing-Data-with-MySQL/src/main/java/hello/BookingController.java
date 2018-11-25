/**
 * 
 */
package hello;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 * @author Dinesh.Rajput
 *
 */
@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingRepository bookingRepository;
	/**
	 * GET /create  --> Create a new booking and save it in the database.
	 */
	/*@RequestMapping("/create")
	public Booking create(Booking booking) {
		booking.setTravelDate(new Date());
		booking = bookingRepository.save(booking);
	    return booking;
	}*/
	
	@PostMapping("/create")
	public ResponseEntity<Booking> create(@RequestBody Booking booking) {
		booking.setTravelDate(new Date());
		booking = bookingRepository.save(booking);
	    return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	}
	
	
	//sorting
	@RequestMapping(value = "/sort", method = RequestMethod.GET)
	Page<Booking> employeesPageable() {
		return bookingRepository.findAll(new PageRequest(0,5,Sort.Direction.ASC,"psngrName"));

	}
	
/*	@RequestMapping("/findall")
	public List<Booking> find(Pageable pageable) {
		Sort sort = new Sort(new Sort.Order(Direction.ASC, "psngrName"));
		List<Booking> booking = (List<Booking>) bookingRepository.findAll();
	    return booking;
	}
	
	*/
	
	/**
	 * GET /read  --> Read a booking by booking id from the database.
	 */
	/*@RequestMapping("/read")
	public Booking read(@RequestParam Long bookingId) {
		Booking booking = bookingRepository.findOne(bookingId);
	    return booking;
	}*/
	
	@RequestMapping("/read")
	public ResponseEntity<Booking> create(@RequestParam("bookid") String bookingId) {
		Booking booking = bookingRepository.findOne(bookingId);
		 return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	}
	
	/**
	 * GET /update  --> Update a booking record and save it in the database.
	 */
	/*@RequestMapping("/update")
	public Booking update(@RequestParam String bookingId, @RequestParam String psngrName) {
		Booking booking = bookingRepository.findOne(bookingId);
		booking.setPsngrName(psngrName);
		booking = bookingRepository.save(booking);
	    return booking;
	}*/
	
	@RequestMapping("/update")
	public ResponseEntity<Booking> update(@RequestParam String bookingId, @RequestParam String psngrName) {
		Booking booking = bookingRepository.findOne(bookingId);
		booking.setPsngrName(psngrName);
		booking = bookingRepository.save(booking);
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);	}
	
	
	/**
	 * GET /delete  --> Delete a booking from the database.
	 */
	/*@RequestMapping("/delete")
	public String delete(@RequestParam String bookingId) {
		bookingRepository.delete(bookingId);
	    return "booking #"+bookingId+" deleted successfully";
	}*/
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String bookingId) {
		bookingRepository.delete(bookingId);
	    return "booking #"+bookingId+" deleted successfully";
	}
	
	
	/**
	   * GET /get-by-email  --> Return the id for the user having the passed
	   * email.
	   *//*
	  @RequestMapping("/get-by-email")
	  @ResponseBody
	  public String getByEmail(String email) {
	    String userId = "";
	    try {
	      User user = userDao.findByEmail(email);
	      userId = String.valueOf(user.getId());
	    }
	    catch (Exception ex) {
	      return "User not found";
	    }
	    return "The user id is: " + userId;
	  }
	*/
	
/*	@RequestMapping("/find-by-departure")
	@ResponseBody
	public String getByDeparture(String departure) {
		
		String psngrName="";
		try {
			Booking booking = bookingRepository.findByDeparture(departure);
			psngrName=String.valueOf(booking.getPsngrName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Passenger not found";
		}
		return "The Passenger id is: " + psngrName;
	}*/
	
	List<Booking> list=new ArrayList<Booking>();
	@RequestMapping("/find-by-departure")
	@ResponseBody
	public List<Booking> getAllMatch(@RequestHeader String departure)
	{
		for (Booking user : bookingRepository.findByDeparture(departure)) {
			System.out.println(user.toString());
			list.add(user);
		}
		return list;
	}
	
	
}
