package com.corelogic.rps.rentrolldata.audit.repository;

import com.corelogic.rps.rentrolldata.audit.data.RentrollRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuditRequestRepository extends JpaRepository<RentrollRequest, Long> {
    List<RentrollRequest> getByFurnisher(String furnisher);
}
