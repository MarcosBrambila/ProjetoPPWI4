package com.lojaconstrucao.models.model;

import com.lojaconstrucao.models.pk.PrimaryKey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_ROLE")
public class Role extends PrimaryKey {

	private static final long serialVersionUID = 8707839023450582222L;
	
	private String name;

	@Column(name="NAME", length = 50, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
