package br.com.david.testeinsight.validator;

/**
 *
 * @author David Arruda
 */
public interface WorkingHoursValidator extends FieldValidator<String[]> {
    
	/**
	 * Valida os dados de um determidado campo de horários
	 * @param value
	 * @return boolean
	 */
	boolean validate(String[] values) throws Exception;
}
