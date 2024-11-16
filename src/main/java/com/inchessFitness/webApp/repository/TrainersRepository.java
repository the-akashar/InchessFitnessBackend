package com.inchessFitness.webApp.repository;

import com.inchessFitness.webApp.model.Roles;
import com.inchessFitness.webApp.model.Trainers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "trainers" , path = "trainers")
public interface TrainersRepository extends JpaRepository<Trainers , Integer> {
   // List<Trainers> findByRoles(Roles roles);
}
