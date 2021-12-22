package com.company.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Employee extends User implements UserInterface,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9024339741568234149L;

	@Override
	public Double getDiscountRate() {
 		return 0.30;
	}

}
