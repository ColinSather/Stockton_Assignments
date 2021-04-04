import java.util.ArrayList;
import java.util.Random;
/* Computer Science and Information Systems
 * Programming and Problem Solving II
 * Code Practice and Review
 * Stockton University
 * 
 * The following exercise will walk you through a lot of the
 * topics covered in the first installment of the series.
 * 
 * This specific exercise uses climate data.
 * 
 * Topics include:
 * 
		CLASSES AND METHODS
 		ARRAY/ARRAYLIST
		CONDITIONAL LOGIC (IF/ELSE-IF/SWITCH)
		ITERATION (FOR/DO/WHILE)
		STRING MANIPULATION (SUBSTR/LENGTH/CHARAT)
		FUNDAMENTAL TOOLS (RANDOM/SCANNER)
		FORMATTED OUTPUT (PRINTF/STDOUT/STDERR)
 *			
 */

public class Student {

	// The insertion point for this application
	public static void main(String[] args) {	

		// Create some arrays to store possible conditions
		double[] aryWaveHeight = new double[5];
		double[] aryTemperature = new double[5];
		String[] aryWeather = new String[5];

		// ------------------------------------------------------------------------
		// CREATE YOUR ARRAYLIST HERE
		ArrayList<WeatherInstance> weatherConditions = new ArrayList<>();
		
		// Populate the arrays with data
		aryWaveHeight[0] = 36;
		aryWaveHeight[1] = 14;
		aryWaveHeight[2] = 25;
		aryWaveHeight[3] = 48;
		aryWaveHeight[4] = 9;
		
		aryTemperature[0] = 92;
		aryTemperature[1] = 87;
		aryTemperature[2] = 65;
		aryTemperature[3] = 72;
		aryTemperature[4] = 83;
		
		aryWeather[0] = "Heavy rain and cloud cover.";
		aryWeather[1] = "Partly cloudy, chance of rain later.";
		aryWeather[2] = "Warm and dry. Clear skies all day.";
		aryWeather[3] = "Scattered T-Storms and showers.";
		aryWeather[4] = "Sunny and hazy. Light clouds in the mid-afternoon.";
		
		
		// ---------------------------------------
		// CREATE A RANDOM NUMBER GENERATOR OBJECT
		Random generator = new Random();		

		 // -------------------------------------------------------------------------------------
		 // PUT A LOOPING CONSTRUCT HERE: FILL YOUR ARRAYLIST WITH 1000 RANDOM WEATHER CONDITIONS
		
		for(int i = 0; i<1000;i++) {
			// CREATE A TEMPORARY RANDOM WEATHER CONDITION
			WeatherInstance randomCondition = new WeatherInstance();
			randomCondition.temperature = aryTemperature[generator.nextInt(5)];
			randomCondition.waveHeight = aryWaveHeight[generator.nextInt(5)];
			randomCondition.weather = aryWeather[generator.nextInt(5)];

			// OUTPUT THE RANDOMLY GENERATED CONDITION'S PARAMETERS
			System.out.println("Temp: " + randomCondition.temperature);
			System.out.println("Wave: " + randomCondition.waveHeight);
			System.out.println(randomCondition.weather);

			// POPULATE THE ARRAYLIST
			weatherConditions.add(randomCondition);
		}
	
		// --------------------------------------------------------------------------------------
		// PUT A LOOPING CONSTRUCT HERE: COUNT HOW MANY TIMES A TEMPERATURE ABOVE 75 WAS OBSERVED
		
		int tempsAbove75 = 0;
		for(int i = 0; i<1000;i++)
				if (weatherConditions.get(i).getTemperature() > 75) 
					tempsAbove75++;


		System.out.println(tempsAbove75 + " specific occurences out of 1000, or approx. " + (tempsAbove75/10.0) + "% of observations were above 75 degrees");
		
		// -----------------------------------------------------------------------------------------
		// PUT A NESTED CONTROL STRUCTURE HERE: COUNT HOW MANY TIMES  
		// SCATTERED T-STORMS OCCURED AT THE SAME TIME THAT WAVE HEIGHT WAS BELOW 30
			
		int tStormsWaveHeightBelow30 = 0;
		
			for (int i=0; i<1000; i++) {
				if (weatherConditions.get(i).getWaveHeight() < 30)
					if (weatherConditions.get(i).getWeather() == "Scattered T-Storms and showers.")
						tStormsWaveHeightBelow30++;
			}
			
		System.out.println(tStormsWaveHeightBelow30 + " specific occurences out of 1000, or approx. " + (tStormsWaveHeightBelow30/10.0) + "% of observations were during scattered T-Storms with waves below 30");
		
	}

}
