package com.api.webapiloja.entities;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_APP")
public class Aplicativo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
	@Column(nullable = false,unique = true)
    private String appName;
	@Column(nullable = false)
    private String appCategory;
	@Column(nullable = false)
    private Double appPrice;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppCategory() {
		return appCategory;
	}
	public void setAppCategory(String appCategory) {
		this.appCategory = appCategory;
	}
	public Double getAppPrice() {
		return appPrice;
	}
	public void setAppPrice(Double appPrice) {
		this.appPrice = appPrice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

