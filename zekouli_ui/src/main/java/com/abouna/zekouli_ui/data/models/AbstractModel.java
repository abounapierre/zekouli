package com.abouna.zekouli_ui.data.models;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AbstractModel implements Serializable{
	/**
	 * serial No.
	 */
	private static final long serialVersionUID = 1155609287296958207L;
	protected Long id;
	
	
}
