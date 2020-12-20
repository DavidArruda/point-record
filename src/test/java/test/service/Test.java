package test.service;

import java.time.LocalDateTime;

public class Test {
	
	public static void main(String[] args) {
		
		DateTest jornada = new DateTest();
		jornada.entry = LocalDateTime.of(2020, 12, 18, 22, 00);
		jornada.departure = LocalDateTime.of(2020, 12, 19, 05,00);
		
		DateTest marcacao = new DateTest();
		marcacao.entry = LocalDateTime.of(2020, 12, 18, 03, 00);
		marcacao.departure = LocalDateTime.of(2020, 12, 19, 07,00);
		
		if(marcacao.entry.isAfter(jornada.entry) || marcacao.departure.isAfter(jornada.departure)) {
			System.out.println("Atraso");
			
		}
		
		if (marcacao.entry.isBefore(jornada.entry) || marcacao.departure.isAfter(jornada.departure)) {
			System.out.println("Hora extra");
		}
		
		
	}
	
	

}


class DateTest {
	LocalDateTime entry;
	LocalDateTime departure;
}
