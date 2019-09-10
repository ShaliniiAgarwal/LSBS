package com.LSB.controller;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.LSB.Entity.Admin;
import com.LSB.Entity.Persons;
import com.LSB.Entity.Seat;
import com.LSB.Repository.AdminRepo;
import com.LSB.Repository.PersonsRepo;
import com.LSB.Repository.SeatRepo;
import com.LSB.Service.PersonService;
@Controller
public class MainController {
	@Autowired
	private PersonService personService;
	@Autowired
	private SeatRepo seatRepo;
	@Autowired
	private PersonsRepo personRepo;
	@Autowired
	private AdminRepo adminRepo;
	
@GetMapping(value="/")
public String Dashboard(HttpServletRequest request) throws ParseException {
	request.setAttribute("seat",seatRepo.findAll());
	request.setAttribute("checkout",personRepo.checkout());
	request.setAttribute("countper",personRepo.countper());
	request.setAttribute("person",personService.findAll());
	request.setAttribute("mode","view");
	 LocalDate localDate =java.time.LocalDate.now();
Date date1 = java.sql.Date.valueOf(localDate);
List<Date> cdate = new ArrayList<Date>();
cdate.add(date1); 
request.setAttribute("alertDate",cdate);
/*for (int i = 0; i<d2.size(); i++)
{
	 if(cdate.contains(d2.get(i))) {
		 System.out.println(d2.get(i));
		 List<Date> alert = new ArrayList<Date>();
		 alert.add(d2.get(i));
		 request.setAttribute("alertDate",alert);
	 }	 
}*/
return "dashboard";
}
@GetMapping(value="/check")
public void Check(HttpServletResponse response) {
	try {
		response.sendRedirect("/show");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@GetMapping(value="/booking")
public String AddPerson(HttpServletRequest request) {
	request.setAttribute("mode","AddPerson");
	return "dashboard";
}
/*@GetMapping(value="/view")
public String View(HttpServletRequest request) {
	request.setAttribute("seat",seatRepo.findAll());
	request.setAttribute("person",personService.findAll());
	request.setAttribute("mode","view");
	return "dashboard";
}*/
@GetMapping(value="/edit/{id}")
public String EditPerson(HttpServletRequest request,@PathVariable("id") int id) {
	request.setAttribute("person",personService.findId(id));
	request.setAttribute("mode","EditPerson");
	return "dashboard";
}
@GetMapping(value="/editseat/{id}")
public String EditSeat(HttpServletRequest req,@PathVariable("id") int id) {
	req.setAttribute("seats",personService.findById(id));
	req.setAttribute("mode","editseat");
	return "dashboard";
}
@RequestMapping(value="/updateseat",method=RequestMethod.POST)
public void update(HttpServletRequest req,HttpServletResponse res,@ModelAttribute Seat seat) throws IOException {
	personService.SaveSeat(seat);
	req.setAttribute("mode","view");
	res.sendRedirect("/");
}
@RequestMapping(value="/Add",method=RequestMethod.POST)
public void Save(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Persons person) throws IOException {
	personService.SavePerson(person);
	request.setAttribute("mode","view");
	response.sendRedirect("/");
	
}
@GetMapping(value="/admin")
public String admin(HttpServletRequest request) {
	request.setAttribute("mode","login");
return "login";
}
/*@RequestMapping ("/login")
public ModelAndView login(@ModelAttribute Admin admin, HttpServletRequest request,HttpServletResponse response,HttpSession session,
		@RequestParam("name") String name) throws IOException {z
	if(adminRepo.findByNameAndPassword(admin.getName(),admin.getPassword())!=null) {
		session.setAttribute("name",name);
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}
	else {	
		ModelAndView mv = new ModelAndView("redirect:/login");
		return mv;
	}
	}*/
@RequestMapping ("/login")
public String login(@ModelAttribute Admin admin, HttpServletRequest request,HttpServletResponse response,HttpSession session,
		@RequestParam("name") String name){
	try {
	if(adminRepo.findByNameAndPassword(admin.getName(),admin.getPassword())!=null) {
		session.setAttribute("name",name);
		response.sendRedirect("/");
	}
	}
	catch(Exception e) {
	System.out.println(e);		
	}
	return "/login";
	}
@RequestMapping("/logout")
public String logout(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
	session.removeAttribute("name");
	session.invalidate();
	return "/login";
//	request.setAttribute("mode","login");
	//return "login";
}
}