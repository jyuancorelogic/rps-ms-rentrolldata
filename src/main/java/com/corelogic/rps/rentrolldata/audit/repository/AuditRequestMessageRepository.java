package com.corelogic.rps.rentrolldata.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corelogic.rps.rentrolldata.audit.data.RentrollRequestMessage;

import java.util.List;

public interface AuditRequestMessageRepository extends JpaRepository<RentrollRequestMessage, Long> {
    List<RentrollRequestMessage> getByRequestMessageId(Long  requestMessageId);
}
