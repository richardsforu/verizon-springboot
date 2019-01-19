package com.brownfield.pss.checkin.component;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.brownfield.pss.checkin.controller.Sender;
import com.brownfield.pss.checkin.entity.CheckInRecord;
import com.brownfield.pss.checkin.repository.CheckinRepository;

@Service
public class CheckinComponent {
	private static final Logger logger = LoggerFactory.getLogger(CheckinComponent.class);

	private static final String bookingURL = "http://localhost:8060/booking"; // Added by Praveen S.K

	// @Autowired
	private RestTemplate restTemplate; // Added by Praveen S

	CheckinRepository checkinRepository;
	Sender sender;

	@Autowired
	CheckinComponent(CheckinRepository checkinRepository, Sender sender) {
		this.checkinRepository = checkinRepository;
		this.sender = sender;
		this.restTemplate = new RestTemplate(); // Added by Praveen S
	}

	public long checkIn(CheckInRecord checkIn) {
		// Added by Praveen S
		long bookingId = checkIn.getBookingId();
		BookingRecord bookingRecord = null;
		try {
			logger.info("calling booking to get booking information for booking id " + bookingId);
			// call booking to get know whether booking was done or not
			bookingRecord = restTemplate.getForObject(bookingURL + "/get/" + bookingId, BookingRecord.class);

			if (bookingRecord != null) { // booking existed
				if (bookingRecord.getStatus().equals(BookingStatus.CHECKED_IN)) { // already checked in
					return -2;
				} else { // correct booking id and passenger not Checked-In yet.  
					logger.info("Booking info is " + bookingRecord.toString());
					checkIn.setCheckInTime(new Date());
					logger.info("Saving checkin ");
					long checkInId = checkinRepository.save(checkIn).getId(); //Modified by Praveen S
					logger.info("Successfully saved checkin ");
					
					// Send bookingId to Booking Microservice via RabbitMQ to update the status to CHECKED_IN
					logger.info("Sending booking id " + bookingId);
					sender.send(bookingId);
					return checkInId; //added by Praveen S
				}
			} else { // In case of wrong booking id
				return -1;
			}
		} catch (Exception e) {
			logger.error("BOOKING SERVICE IS NOT AVAILABLE");
			e.printStackTrace();
			System.exit(0);
		}
		return bookingId;
	}

	public Optional<CheckInRecord> getCheckInRecord(long id) {
		return checkinRepository.findById(id);
	}

}
