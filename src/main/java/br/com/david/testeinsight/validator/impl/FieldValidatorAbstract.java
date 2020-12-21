package br.com.david.testeinsight.validator.impl;

import java.time.LocalTime;

import br.com.david.testeinsight.validator.FieldValidator;

/**
 * implementação abstrata para reutilização de códigos
 * 
 * @author David Arruda
 *
 */
public class FieldValidatorAbstract implements FieldValidator<String[]> {
	
	@Override
	public boolean validate(String[] values) throws Exception {
		boolean returnValidate = false;

		String entryTime = values[0];
		String departureTime = values[1];

		LocalTime valueEntry = LocalTime.parse(entryTime);
		LocalTime valueDeparture = LocalTime.parse(departureTime);

		if (entryTime.length() == 5 && departureTime.length() == 5 
				&& valueEntry.getHour() <= 23 && valueEntry.getMinute() <= 59 
				&& valueDeparture.getHour() <= 23 && valueDeparture.getMinute() <= 59) {

			returnValidate = true;
		}

		return returnValidate;
	}

}
