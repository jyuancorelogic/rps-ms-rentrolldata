package com.corelogic.rps.rentrolldata.audit.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RENTROLL_REQUESTS_MESSAGES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RentrollRequestMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RequestMessageId")
	private Long requestMessageId;
	
	@Column(name = "RequestId")
	private Long requestId;

	@Column(name = "RequestApi")
	private String requestApi;

	@Column(name = "RequestMessageFrom")
	private String requestMessageFrom;
	
	@Column(name = "RequestMessageTo")
	private String requestMessageTo;
	
	@Column(name = "RequestMessageStatus")
    @Enumerated(value = EnumType.STRING)
	private RequestStatus requestMessageStatus;
	
	@Column(name = "RequestMessage")
	private String requestMessage;

	@Column(name = "RequestMessageCreateDateTime")
	private LocalDateTime requestMessageCreateDateTime;

}
