package com.odix.fr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PartenaireTemporaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2655886717769992583L;

	@Id
    private @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	
	@Column
	private String identite;
	
    @Column
	private String email;


	public Long getId() {
		return id;
	}

	public String getIdentite() {
		return identite;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIdentite(String identite) {
		this.identite = identite;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
