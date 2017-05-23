package de.volkswagen.inbound.multipledatasources.domain.edipv;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanningDepartmentRepository extends CrudRepository<PlanningDepartment, Long> {
}
