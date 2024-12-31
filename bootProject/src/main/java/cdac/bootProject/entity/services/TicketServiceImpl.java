package cdac.bootProject.entity.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.bootProject.entity.Ticket;
import cdac.bootProject.entity.dto.TicketDTO;
import cdac.bootProject.entity.enums.TicketStatus;
import cdac.bootProject.entity.repositories.Repository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private Repository repo;

	@Override
	public boolean createNewTicket(TicketDTO dto) {
		Ticket ticket = new Ticket();
		BeanUtils.copyProperties(dto, ticket);
		repo.save(ticket);
		return true;
	}

	@Override
	public boolean updateTicketDetails(TicketDTO dto) {
		Ticket ticket = repo.findById(dto.getId()).orElse(null);

		if (null == ticket) {
			return false;
		}

		BeanUtils.copyProperties(dto, ticket);
		repo.save(ticket);
		return true;
	}

	@Override
	public TicketDTO getTicketByID(Integer id) {
		Ticket ticket = repo.findById(id).orElse(null);

		if (null == ticket) {
			return null;
		}

		TicketDTO dto = new TicketDTO();
		BeanUtils.copyProperties(ticket, dto);
		return dto;
	}

	@Override
	public List<TicketDTO> getOpenTickets() {
		Iterator<Ticket> listIterator = repo.findAll().iterator();
		List<TicketDTO> openTicketsList = new ArrayList<TicketDTO>();

		while (listIterator.hasNext()) {
			Ticket ticket = listIterator.next();

			if (ticket.getStatus() != null && ticket.getStatus() == TicketStatus.OPEN) {
				System.out.println(ticket);
				TicketDTO dto = new TicketDTO();
				BeanUtils.copyProperties(ticket, dto);
				openTicketsList.add(dto);
			}
		}

		return openTicketsList;
	}

	@Override
	public boolean isNumberExist(String phNumber) {
		Iterator<Ticket> listIterator = repo.findAll().iterator();

		if (listIterator.hasNext()) {
			return true;
		}
		return false;
	}

}
