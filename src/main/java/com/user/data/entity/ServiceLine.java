package com.user.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Practice")
@Data
public class ServiceLine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "practicName")
	private String serviceName;
	
	@Column(name = "practiceLead")
	private String sericeLineHead;
	
	@Column(name = "practiceLeadEmail")
	private String serviceLineLeadContact;
}
