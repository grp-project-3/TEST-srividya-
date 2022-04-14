package com.dao;
import java.util.List;
import com.pack1.Booking;
import com.pack1.Passenger;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BookingService {

		@Autowired
		BookingDAO bookingDAOImpl;

		public void add(Booking booking)
		{
			bookingDAOImpl.addBooking(booking);
		}
		
		public Booking find(int id)
		{
			return bookingDAOImpl.findBooking(id);
		}
		public List<Booking> findAll()
		{
			return bookingDAOImpl.findAllBooking();

			}

		public boolean update(Booking booking)
		{
			return bookingDAOImpl.updateBooking(booking);
		}
		public boolean delete(int id)
		{
			return bookingDAOImpl.deleteBooking(id);
		}

}
