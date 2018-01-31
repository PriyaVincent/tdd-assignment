package org.tektutor.data.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "CITY")
@Data
public class City implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CITY_ID")
	@JsonProperty(value = "citId")
	Long cityId;

	@Column(name = "CITY_NAME")
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonProperty(value = "cityName")
	String cityName;

}
