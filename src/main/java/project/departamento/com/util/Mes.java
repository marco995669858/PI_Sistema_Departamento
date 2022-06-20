package project.departamento.com.util;

import java.text.ParseException;
import java.time.LocalDate;

public class Mes {

	public static void main(String argos[]) throws ParseException {
		int mes = 0;
		for (int i = 1; i <=12; i++) {
			LocalDate monthstart = LocalDate.of(2016, mes+i, 1);
			LocalDate monthend = monthstart.plusDays(monthstart.lengthOfMonth() - 1);
			System.out.println(monthend);

		}

		
	}
}
