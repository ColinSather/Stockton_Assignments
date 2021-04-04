public class WeatherInstance {

	// Instance Variables ----------------
	
	protected double temperature,
				   	 waveHeight;
	
	protected String weather;

	
	// Constructors ----------------------

	public WeatherInstance() { }
	
	public WeatherInstance(double temperature,
						   double waveHeight,
						   String weather) {
	
		// Call the setter methods to initialize the instance variables
		// with the shadowed parameter variables to provide for input
		// validation and exception handling
		
		try {
			setTemperature(temperature);
			setWaveHeight(waveHeight);
			setWeather(weather);
		} catch (Exception e) {
			// Write to console error and remain uninitialized
			System.err.println("Error initializing WeatherInstance");
		}
		
	}
	

	// Methods ---------------------------
	
	public String getInstanceInfo() {
		return  "Temp: " + temperature + "\n" +
				"Wave: " + waveHeight + "\n" +
				weather;
	}
	
	// Setters
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	public void setWaveHeight(double waveHeight) {
		this.waveHeight = waveHeight;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	
	// Getters
	public double getTemperature() {
		return temperature;
	}

	public double getWaveHeight() {
		return waveHeight;
	}

	public String getWeather() {
		return weather;
	}
		
}