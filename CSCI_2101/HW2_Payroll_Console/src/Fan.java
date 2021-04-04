// Problem 2 Fan 

public class Fan 
{
	int speed;
	boolean f_on;
	double radius;
	String color;
	
	public Fan(int fanspeed, boolean fanf_on, double fanradius, String fancolor)
	{
		speed = fanspeed;
		f_on = fanf_on;
		radius = fanradius;
		color = fancolor;		
	}
	public void SetVariable(int fanspeed1, boolean fanf_on1, double fanradius1, String fancolor1) 
	{
		speed = fanspeed1;
		f_on = fanf_on1;
		radius = fanradius1;
		color = fancolor1;
	}

	public void display()
	{
		if (f_on) 
		{
			System.out.println("FAN_STATE ON " + speed + "rpm " + radius + " " + color);
		}
		else 
		{
			System.out.println("FAN_STATE OFF " + " " + radius + " " + color);
		}
			
	}
}
