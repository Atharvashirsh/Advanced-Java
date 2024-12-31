package cdac.bootProject.entity.services;

import java.util.List;

import cdac.bootProject.entity.dto.TicketDTO;

public interface TicketService {

	public boolean createNewTicket(TicketDTO dto);
	
	public boolean updateTicketDetails(TicketDTO dto);
	
	public TicketDTO getTicketByID(Integer id);
	
	public List<TicketDTO> getOpenTickets();
	
	public boolean isNumberExist(String phNumber);
}
