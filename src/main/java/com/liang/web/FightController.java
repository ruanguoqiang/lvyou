package com.liang.web;

import com.liang.dao.FlightMapper;
import com.liang.dao.JourneyUserMapper;
import com.liang.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/oprateSystem/flight")
public class FightController {
    @Autowired
    private JourneyUserMapper journeyUserMapper;
    @Autowired
    private FlightMapper flightMapper;

    @RequestMapping("/query")
    public String queryFight(@RequestParam Integer userid, Model model) {
        model.addAttribute("localUser",journeyUserMapper.selectByPrimaryKey(userid));
        model.addAttribute("flightList",flightMapper.selectAll());
        return "oprate/main";
    }
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    public String insertFight(Flight flight, Model model) {
        System.out.print(flight.getFlightnum());
        System.out.print(flight.getFlightprice());
        flightMapper.insert(flight);
        return "1111";
    }
    @RequestMapping(value = "/beforUpdate",method = RequestMethod.POST)
    public String beforUpdate(Flight flight, Model model) {
        flightMapper.insert(flight);
        model.addAttribute("flightList",flightMapper.selectAll());
        return "1111";
    }
    @RequestMapping(value = "/Update",method = RequestMethod.POST)
    public String UpdateFight(Flight flight, Model model) {
        flightMapper.insert(flight);
        model.addAttribute("flightList",flightMapper.selectAll());
        return "1111";
    }

    @RequestMapping(value = "/Delete",method = RequestMethod.POST)
    public String DeleteFight(Flight flight, Model model) {
        flightMapper.insert(flight);
        model.addAttribute("flightList",flightMapper.selectAll());
        return "1111";
    }
}
