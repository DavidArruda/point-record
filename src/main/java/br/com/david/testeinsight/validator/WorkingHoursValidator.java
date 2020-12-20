package br.com.david.testeinsight.validator;

import br.com.david.testeinsight.model.WorkingHours;

/**
 *
 * @author David Arruda
 */
public interface WorkingHoursValidator extends FieldValidator<WorkingHours> {
    
	/**
	 * Valida os dados de um determidado campo de horários
	 * @param value
	 * @return boolean
	 */
	boolean validate(WorkingHours value);
}
