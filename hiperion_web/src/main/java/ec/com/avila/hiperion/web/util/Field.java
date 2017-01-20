/**
 * 
 */
package ec.com.avila.hiperion.web.util;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Field<x> implements Serializable {

	private x value;
	
	
	public Field(){
		//
	}
	
	public Field(x value){
		this.value = value;
	}

	/**
	 * @return el value
	 */
	public x getValue() {
		return value;
	}

	/**
	 * @param value el value a establecer
	 */
	public void setValue(x value) {
		this.value = value;
	}
	
	
}
