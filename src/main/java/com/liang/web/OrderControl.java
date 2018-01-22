package com.liang.web;

import com.liang.JsonUtil.FastJsonUtil;
import com.liang.dao.FlightMapper;
import com.liang.dao.JourneyUserMapper;
import com.liang.handle.Myexception;
import com.liang.model.Flight;
import com.liang.model.JourneyUser;
import com.liang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@Controller

public class OrderControl {
   @Autowired
   private JourneyUserMapper journeyUserMapper;

   @Autowired
   private FlightMapper flightMapper;

   @Autowired
    OrderService orderService;

    @RequestMapping(value = "/flight")
    public String index(@RequestParam Integer userid, Model model, HttpServletRequest servletRequest) {
        model.addAttribute("user",journeyUserMapper.selectByPrimaryKey(userid));
        model.addAttribute("flightList",flightMapper.selectAll());

        return "flight/flightInfo";
    }

    @RequestMapping(value = "/orderflight")
    public void orderFlight(Flight flight, JourneyUser user, Model model, HttpServletResponse response) throws Exception {

        if (orderService.orderFlight(flight.getFlightnum(),user.getUserid())){

            FastJsonUtil.sendJsonData(response,111 );
        }
        else {
            throw new Myexception("数据错误");
        }

    }
}
