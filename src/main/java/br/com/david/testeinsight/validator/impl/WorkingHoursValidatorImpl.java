package br.com.david.testeinsight.validator.impl;

import br.com.david.testeinsight.model.WorkingHours;
import br.com.david.testeinsight.validator.WorkingHoursValidator;

public class WorkingHoursValidatorImpl implements WorkingHoursValidator {

	@Override
	public boolean validate(WorkingHours value) {

		boolean returnValidate = false;

		String valueEntry = value.getEntryTime().toString();
		String valueDeparture = value.getDepartureTime().toString();

		if (valueEntry.length() == 5 && valueDeparture.length() == 5 && value.getEntryTime().getHour() <= 23
				&& value.getEntryTime().getMinute() <= 59 && value.getDepartureTime().getHour() <= 23
				&& value.getDepartureTime().getMinute() <= 59) {

			returnValidate = true;
		}

		return returnValidate;
	}

}
