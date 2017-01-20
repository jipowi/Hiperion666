/**
 * 
 */
package ec.com.avila.hiperion.web.util;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public class StringField extends Field<CharSequence> {
	
	private Boolean applyLike;
	private Boolean isCaseSensitive;
	
	
	public StringField(){
		//
	}
	
	
	public StringField(CharSequence value, Boolean applyLike, Boolean isCaseSensitive){
		super(value);
		this.applyLike = applyLike;
		this.isCaseSensitive = isCaseSensitive;
	}
	
	/**
	 * @return el applyLike
	 */
	public Boolean getApplyLike() {
		return applyLike;
	}
	/**
	 * @param applyLike el applyLike a establecer
	 */
	public void setApplyLike(Boolean applyLike) {
		this.applyLike = applyLike;
	}
	/**
	 * @return el isCaseSensitive
	 */
	public Boolean getIsCaseSensitive() {
		return isCaseSensitive;
	}
	/**
	 * @param isCaseSensitive el isCaseSensitive a establecer
	 */
	public void setIsCaseSensitive(Boolean isCaseSensitive) {
		this.isCaseSensitive = isCaseSensitive;
	}
	
}
