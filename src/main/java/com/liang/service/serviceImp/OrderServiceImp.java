package com.liang.service.serviceImp;

import com.liang.dao.FlightMapper;
import com.liang.dao.JourneyUserMapper;
import com.liang.dao.ReservationMapper;
import com.liang.model.Flight;
import com.liang.model.JourneyUser;
import com.liang.model.Reservation;
import com.liang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private JourneyUserMapper journeyUserMapper;

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private FlightMapper flightMapper;

    @Override
    public Boolean orderFlight(String flightNum,Integer userid) {
        JourneyUser journeyUser=journeyUserMapper.selectByPrimaryKey(userid);
        Flight flight=flightMapper.selectByPrimaryKey(flightNum);
        flight.setFlightnumavail(flight.getFlightnumavail()-1);
        Reservation reservation=new Reservation();
        reservation.setrUserid(userid);
        reservation.setrUsername(journeyUser.getUsername());
        reservation.setAssociateid(flightNum);
        reservation.setResstatus("预定成功");
        reservation.setRestype("F");
        reservationMapper.insert(reservation);
        flightMapper.updateByPrimaryKeySelective(flight);
        return true;
    }
}
