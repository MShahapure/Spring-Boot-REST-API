/*package hello;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccessingDataWithMySqlApplicationTests {


	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	private final String apiPrefix = "/booking";
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	 private static String createBookingInJson (String psngrname, String destination, String departure) {
	        return "{ \"psngrname\": \"" + psngrname + "\", " +
	                            "\"destination\":\"" + destination + "\"," +
	                            "\"departure\":\"" + departure + "\"}";
	    }
	 
	
	
	@Test
	public void verifyCreate() throws Exception {
		
		
		 mockMvc.perform(post(apiPrefix+"/create")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(createBookingInJson("mike",
                            "mike@example.com",
                            "123")))
	                .andExpect(status().isOk()).andDo(print());
		
	}

	@Test
	public void verifyRead() throws Exception {
		
		
		 mockMvc.perform(get(apiPrefix+"/read")
	                .param("bookid", "2"))
	                .andExpect(status().isOk()).andDo(print());
		
	}

	
	@Test
	public void verifyUpdate() throws Exception {
		
		
		 mockMvc.perform(post(apiPrefix+"/update")
	                .param("bookingId", "2")
	                .param("psngrName", "Mayur"))
	                .andExpect(status().isOk()).andDo(print());
		
	}

	@Test
	public void verifyDelete() throws Exception {
		
		
		 mockMvc.perform(post(apiPrefix+"/delete")
	                .param("bookingId", "1"))
	                .andExpect(status().isOk()).andDo(print());
		
	}
	
	@MockBean
	BookingRepository bookingRepository;
	
	@InjectMocks
	BookingController controller;
	
	@Test
	public void verifyFindBookingByDeparture() throws Exception
	{
		List<Booking> list=new ArrayList<Booking>();
	
		 when(bookingRepository.findByDeparture("Mumbai")).thenReturn(list);
		 
		 mockMvc.perform(get(apiPrefix+"/find-by-departure")
				 .param("departure", "Mumbai"))
		 .andExpect(status().isOk()).andDo(print());
	}
	
}
*/