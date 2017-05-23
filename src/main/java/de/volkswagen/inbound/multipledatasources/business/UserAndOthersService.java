package de.volkswagen.inbound.multipledatasources.business;

import de.volkswagen.inbound.multipledatasources.domain.edipv.PlanningDepartmentRepository;
import de.volkswagen.inbound.multipledatasources.domain.ldb.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAndOthersService {

    @Autowired
    private PlanningDepartmentRepository planningDepartmentRepository;

    @Autowired
    private UserRepository userRepository;

    public void update() {

        userRepository.findAll();

        planningDepartmentRepository.findAll();

    }
}
