import math

def question5(weight, feet, inches):
    # convert height in string to floating point
    h = feet+"."+inches
    hght = float(h) * 12
    bmi = (weight / pow(hght, 2)) * 703
    return round(bmi)


if __name__ == "__main__":
    print("\nQuestion 5 BMI Calculator")
    w = input("Enter your weight in pounds: ")
    h1 = input("Enter your height in feet, do not include inches: ")
    h2 = input("Enter your height in inches, must be less than 12: ")
    
    
    print("Your Height:",h1,"feet,",h2,"inches")
    print("Your weight:",w,"lbs")
    print("Your BMI:", question5(float(w), h1, h2))