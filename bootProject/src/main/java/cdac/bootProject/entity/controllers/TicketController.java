package cdac.bootProject.entity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cdac.bootProject.entity.dto.TicketDTO;
import cdac.bootProject.entity.services.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService tService;
	
	/*
	 * Add a new Ticket
	 */
	@PostMapping("/add")
	public ResponseEntity<String> createNewTicket(@RequestBody TicketDTO dto)
	{
		boolean isPhoneExists = tService.isNumberExist(dto.getPhoneNum());
		
		if(isPhoneExists)
		{
			return new ResponseEntity<String>("Phone number already exists", HttpStatus.BAD_REQUEST);			
		}
		
		boolean isCreated = tService.createNewTicket(dto);
		
		if(!isCreated)
		{
			return new ResponseEntity<String>("Error creating ticket", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>("Ticket created successfully", HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{tid}")
	public ResponseEntity<String> updateTicketDetails(@PathVariable("tid") Integer tid,@RequestBody TicketDTO dto)
	{
		dto.setId(tid);
		boolean isUpdated = tService.updateTicketDetails(dto);
		
		if(!isUpdated)
		{
			return new ResponseEntity<String>("Ticket Not Found or Update failed", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>("Ticket updated successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getOpenTickets")
	public ResponseEntity<List<TicketDTO>> getOpenTickets()
	{
		List<TicketDTO> openTickets = tService.getOpenTickets();
		
		if(openTickets.isEmpty())
		{			
			return new ResponseEntity<List<TicketDTO>>(openTickets, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TicketDTO>>(openTickets, HttpStatus.OK);
	}
	
	@GetMapping("/getticket/{tid}")
	public ResponseEntity<TicketDTO> getTicketByID(@PathVariable("tid") Integer id)
	{
		TicketDTO ticket = tService.getTicketByID(id);
		
		if(null == ticket)
		{			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>( ticket, HttpStatus.OK);
	}
}
