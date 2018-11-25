package hello;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/*@Transactional
public interface BookingRepository extends CrudRepository<Booking, Long> {
	
	*//**
	   * This method will find an Boooking instance in the database by its departure.
	   * Note that this method is not implemented and its working code will be
	   * automatically generated from its signature by Spring Data JPA.
	   *//*
	 // public Booking findByDeparture(String departure);
	  List<Booking> findByDeparture(String departure);
	 
}*/

@Transactional
public interface BookingRepository extends JpaRepository<Booking, String> {
	
	/**
	   * This method will find an Boooking instance in the database by its departure.
	   * Note that this method is not implemented and its working code will be
	   * automatically generated from its signature by Spring Data JPA.
	   */
	 // public Booking findByDeparture(String departure);
	  List<Booking> findByDeparture(String departure);
	  Page<Booking> findAll(Pageable pageable);
	Booking findOne(String bookingId);
}

