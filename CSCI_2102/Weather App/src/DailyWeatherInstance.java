public class DailyWeatherInstance extends WeatherInstance {

	// Instance Variables ----------------
	
	private int dayOfMonth,
				month,
				year;
	
	// Constructors ----------------------

	public DailyWeatherInstance() { }
	
	public DailyWeatherInstance(int dayOfMonth,
							    int month,
							    int year,
							    double temperature,
							    double waveHeight,
							    String weather) {
		
		// Call the setter methods to initialize the instance variables
		// with the shadowed parameter variables to provide for input
		// validation and exception handling
		
		try {
			setDayOfMonth(dayOfMonth);
			setMonth(month);
			setYear(year);
			setTemperature(temperature);
			setWaveHeight(waveHeight);
			setWeather(weather);
		} catch (Exception e) {
			// Write to console error and remain uninitialized
			System.err.println("Error initializing DailyWeatherInstance");
		}
		
	}
	

	// Methods ---------------------------
	
	public String getInstanceInfo() {
		return  month + "-" + dayOfMonth + "-" + year + "\n" +
				"Temp: " + temperature + "\n" +
				"Wave: " + waveHeight + "\n" +
				weather;
	}
	
	// Additional Setters
	public void setDayOfMonth(int dayOfMonth) throws InvalidValueException {
		if (dayOfMonth > 0 && dayOfMonth <= 31) {
			this.dayOfMonth = dayOfMonth;
			return;
		}
		throw new InvalidValueException();
	}

	public void setMonth(int month) throws InvalidValueException {
		if (month > 0 && month <= 12) {
			this.month = month;
			return;
		}
		throw new InvalidValueException();
	}

	public void setYear(int year) throws InvalidValueException {
		if (year >= 1900 && year <= 2100) {
			this.year = year;
			return;
		}
		throw new InvalidValueException();
	}
		
	
	// Additional Getters
	public int getDayOfMonth() {
		return dayOfMonth;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
		
}