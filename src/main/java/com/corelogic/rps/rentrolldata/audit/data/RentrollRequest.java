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
@Table(name = "RENTROLL_REQUESTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RentrollRequest implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RequestId")
	private Long requestId;

	@Column(name = "Vendor")
	private String vendor;

	@Column(name = "furnisher")
	private String furnisher;
	
	@Column(name = "RequestStatus")
	@Enumerated(value = EnumType.STRING)
	private RequestStatus requestStatus;

	@Column(name = "RequestCreateDateTime")
	private LocalDateTime requestCreateDateTime;

}

