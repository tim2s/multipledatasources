package de.volkswagen.inbound.multipledatasources.domain.edipv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planning_department")
public class PlanningDepartment {

    @Id
    @Column(name="planning_department_id")
    private Long planningDepartmentId;

    @Column
    private String name;

    @Column(name="site_id")
    private Long siteId;

    public Long getPlanningDepartmentId() {
        return planningDepartmentId;
    }

    public void setPlanningDepartmentId(Long planningDepartmentId) {
        this.planningDepartmentId = planningDepartmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }
}
