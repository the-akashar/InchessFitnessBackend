package com.inchessFitness.webApp.repository;


import com.inchessFitness.webApp.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "clients" , path = "clients")
public interface ClientsRepository extends JpaRepository<Clients , Integer> {
}
