package com.company.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Customer extends User implements UserInterface, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7950075637017748908L;

	@Override
	public Double getDiscountRate() {
		return 0.10;
	}

}
