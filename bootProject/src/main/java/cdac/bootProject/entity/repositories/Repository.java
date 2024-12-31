package cdac.bootProject.entity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cdac.bootProject.entity.Ticket;

public interface Repository extends JpaRepository<Ticket, Integer> {

}
