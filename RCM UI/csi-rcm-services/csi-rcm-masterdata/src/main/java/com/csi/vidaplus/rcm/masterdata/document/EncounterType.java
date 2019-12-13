/**
 * 
 */
package com.csi.vidaplus.rcm.masterdata.document;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * DTO class for Encounter Type table
 * 
 * @version 1.0 18 Jan 2018
 * @author rajith pemabandu
 *
 */

@Document(collection = "encounter_type")
public class EncounterType extends MasterData{
	
	@NotNull(message = "Encounter id must not be null")
	@NotEmpty(message = "Encounter id  cannot be empty")
	private String encounter_id;
	
	@NotNull(message = "Encounter Type id must not be null")
	@NotEmpty(message = "Encounter Type id  cannot be empty")
	private String encounter_type_id;
	
	@NotNull(message = "Encounter Name must not be null")
	@NotEmpty(message = "Encounter Name cannot be empty")
	private String name;
	
	
	/**
	 * 
	 * Default constructor
	 * 
	 */
	public EncounterType() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	/**
	 * Parameterized constructor
	 * 
	 * @param encounter_id
	 * @param encounter_type_id
	 * @param encounter_patient_id
	 
	 */
	public EncounterType(String encounter_id, String encounter_type_id, String name) {
		super();
		this.encounter_id = encounter_id;
		this.encounter_type_id = encounter_type_id;
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns the encounter_id
	 *
	 * @return the encounter_id
	 */
	public String getEncounter_id() {
		return encounter_id;
	}

	/**
	 * Sets the encounter_id to encounter_id
	 *
	 * @param encounter_id the encounter_id to set
	 */
	public void setEncounter_id(String encounter_id) {
		this.encounter_id = encounter_id;
	}

	/**
	 * returns the encounter_type_id
	 *
	 * @return the encounter_type_id
	 */
	public String getEncounter_type_id() {
		return encounter_type_id;
	}

	/**
	 * Sets the encounter_type_id to encounter_type_id
	 *
	 * @param encounter_type_id the encounter_type_id to set
	 */
	public void setEncounter_type_id(String encounter_type_id) {
		this.encounter_type_id = encounter_type_id;
	}

}
