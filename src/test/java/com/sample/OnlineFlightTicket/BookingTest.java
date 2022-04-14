package com.sample.OnlineFlightTicket;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.Assert;
//import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.BookingService;
import com.pack1.Booking;
import com.pack1.Passenger;


@SpringBootTest
class BookingTest {
	@Autowired
	BookingService service;
	@Test
	void contextLoads() {
		
	}
	
	@Test
	void testAdd() {
		
		Booking booking=new Booking();
				//booking.setId(12);
				booking.setBookingNumber(1234);
				String str="2022-02-04";
				Date d= Date.valueOf(str);
				booking.setTravelDate(d);
				booking.setTotalCost(25.0);
				
				service.add(booking);
				Booking booking1=service.find(booking.getId());
				Assert.assertEquals(1234L,booking.getBookingNumber());
				//Assert.assertEquals(1234, booking.getBookingNumber());
				//Assert.assertEquals(25.0,booking.getTotalCost());
				//Assert.assertEquals(d, booking.getTravelDate());
	}
		
		
	@Test
	void testFind() {
		
		Booking booking=service.find(4);
		Assert.assertNotNull(booking);
	}

	@Test
	void testUpdate() {
		Booking booking=new Booking();
		booking.setId(1);
		booking.setBookingNumber(1234L);
		booking.setTotalCost(360000);
		String str="2022-04-06";
		Date d= Date.valueOf(str);
		booking.setTravelDate(d);
		service.add(booking);
		Booking booking1=service.find(booking.getId());
		Assert.assertEquals(true, service.update (booking));
	}
	

	@Test
	void testDelete() {
		Booking booking=service.find(4);
		service.delete(booking.getId());
		Booking booking1=service.find(booking.getId());
		Assert.assertNull(booking1);
	}

}
