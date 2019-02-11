package com.corelogic.rps.rentrolldata.vendordata.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.corelogic.rps.rentrolldata.vendordata.id.VendorParamsId;

@Entity
@Table(name = "RENTROLL_VENDORREQUESTPARAMS")
@Data
@EqualsAndHashCode(of = "vendorParamsId")
@NoArgsConstructor
@AllArgsConstructor

public class VendorRequestParams implements Serializable {

	private static final long serialVersionUID = 1L;
    
	@EmbeddedId
	private VendorParamsId vendorParamsId;

	@Column(name = "VendorServiceType")
	private String vendorServiceType;

	@Column(name = "VendorServiceURL")
	private String vendorServiceURL;
	
	@Column(name = "LoginId")
	private String loginId;
	
	@Column(name = "Pasword")
	private String pasword;
	
	@Column(name = "VendorDatabase")
	private String vendorDatabase;

	@Column(name = "Server")
	private String server;
	
	@Column(name = "Entity")
	private String entity;
	
	@Column(name = "Platform")
	private String platform;
	
	@Column(name = "Licence")
	private String licence;
	
	@Column(name = "UnitStatus")
	private String unitStatus;
	
	@Column(name = "DBLive")
	private String dBLive;
	
	@Column(name = "LastUpdateUser")
	private String lastUpdateUser;
	
	@Column(name = "LastUpdateDate")
	private LocalDateTime lastUpdateDate;

}
