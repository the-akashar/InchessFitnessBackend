package com.inchessFitness.webApp.service;


import com.inchessFitness.webApp.model.Roles;
import com.inchessFitness.webApp.model.Trainers;
import com.inchessFitness.webApp.repository.RolesRepository;
import com.inchessFitness.webApp.repository.TrainersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.inchessFitness.webApp.constants.InchessFitnessConstants.TRAINER_ROLE;

@Service
public class TrainersService {

    @Autowired
    RolesRepository rolesRepository;


    @Autowired
    TrainersRepository trainersRepository;

    public boolean createNewTrainer(Trainers trainers){
        boolean isSaved = false;
        Roles roles = rolesRepository.getByRoleName(TRAINER_ROLE);
        trainers.setRoles(roles);
        trainers = trainersRepository.save(trainers);
        if (null!=trainers && trainers.getTrainersid() >0 ){
            isSaved = true;
        }
        return isSaved;
    }



}

