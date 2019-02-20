package com.corelogic.rps.rentrolldata.audit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.corelogic.rps.rentrolldata.audit.data.RentrollRequest;
import com.corelogic.rps.rentrolldata.audit.data.RentrollRequestMessage;
import com.corelogic.rps.rentrolldata.audit.data.RequestStatus;
import com.corelogic.rps.rentrolldata.audit.repository.AuditRequestMessageRepository;
import com.corelogic.rps.rentrolldata.audit.repository.AuditRequestRepository;

import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Log4j2
@Service
public class AuditService {

	@Autowired
	private AuditRequestRepository requestRepository;

	@Autowired
	private AuditRequestMessageRepository messageRepository;

	public long saveRequest(@NotNull String vendor, String furnisher,
			RequestStatus status) {
		RentrollRequest request = RentrollRequest.builder().vendor(vendor).requestCreateDateTime(LocalDateTime.now())
				.furnisher(furnisher).requestStatus(status).build();
		return requestRepository.save(request).getRequestId();
	}

	public void updateRequest(@NotNull long requestId, RequestStatus status) {
		RentrollRequest request = requestRepository.findById(requestId).orElse(null);	
		if(request!=null){
			request.setRequestStatus(status);
			requestRepository.save(request);
		}
	}

	public long saveRequestMessage(@NotNull long requestId, String requestAPI, String from, String to, String message,
			RequestStatus status) {
		RentrollRequestMessage requestMessage = RentrollRequestMessage.builder().requestApi(requestAPI)
				.requestMessageCreateDateTime(LocalDateTime.now()).requestId(requestId).requestMessageFrom(from)
				.requestMessageTo(to).requestMessageStatus(status).requestMessage(message).build();
		return messageRepository.save(requestMessage).getRequestMessageId();
	}

	public void updateRequestMessage(@NotNull long requestMessageId, RequestStatus status) {
		RentrollRequestMessage requestMessage = messageRepository.findById(requestMessageId).orElse(null);
		if(requestMessage!=null){
			requestMessage.setRequestMessageStatus(status);
			requestMessage.setRequestMessageCreateDateTime(LocalDateTime.now());
			messageRepository.save(requestMessage);
		}
	}
}
