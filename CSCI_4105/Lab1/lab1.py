"""
Author: Colin Sather
Below are questions 1-5 all in one script.

"""
import datetime, random

def help_console():
    print("\nLab 1 Part 1 by Colin Sather")
    print("-----------------------------")
    print("Type 1 to execute question 1.")
    print("Type 2 to execute question 2.")
    print("Type 3 to execute question 3.")
    print("Type 4 to execute question 4.")
    print("Type 5 to execute question 5.")
    print("Type 'exit' to quit the program.\n")

def question1(strx):
    i = 0
    while i < 5:
        print(strx)
        i += 1

def question2():
    # ans: 0.8392857142857143
    x = (9.5*4.5) - (2.5*3)
    y = 45.5 - 3.5
    return x/y

def question3(x):
    # 1 foot = 3.28084 meters
    raw = x / 3.28084
    return round(raw, 3)

def question4(minutes):
    years = minutes / 525600
    days = minutes / 1440
    return years, days

def question5(weight, feet, inches):
    # convert height in string to floating point
    h = feet+"."+inches
    hght = float(h) * 12
    bmi = (weight / pow(hght, 2)) * 703
    final_bmi = round(bmi)
    category = ""
    if final_bmi < 19:
        category = "Underweight"
    elif 19 <= final_bmi <= 24:
        category = "Healthy Weight" 
    elif final_bmi >= 30:
        category = "overweight"
    return final_bmi, category

if __name__ == "__main__":
    help_console()
    option = input()
    run_cons = True

    while run_cons:
        if option == "1":
            print("Question 1 Print Statement 5 Times")
            msg = "Welcome to Data Mining and Knowledge Discovery"
            question1(msg)
            help_console()
            option = input()
        
        if option == "2":
            print("\nQuestion 2 Calculate (9.5*4.5) - (2.5*3)")
            ans2 = question2()
            print(ans2)
            help_console()
            option = input()

        if option == "3":
            print("\nQuestion 3 Feet to Meters Converter")
            print("Enter a number of feet to be converted into meters.")
            inp = input("Input a measurement in feet: ")
            ans3 = question3(int(inp))
            print(inp, "feet")
            print(ans3, "meters")
            help_console()
            option = input()
        
        if option == "4":
            print("\nQuestion 4 Minute Converter")
            print("Enter a number of minutes to be converted to number of years and days.")
            inp = input("Input a number of minutes: ")
            ans4 = question4(int(inp))
            print("years", ans4[0])
            print("days", ans4[1])
            help_console()
            option = input()

        if option == "5":
            print("\nQuestion 5 BMI Calculator")
            w = input("Enter your weight in pounds: ")
            h1 = input("Enter your height in feet, do not include inches: ")
            h2 = input("Enter your height in inches, must be less than 12: ")
            # check if h2 is valid
            if int(h2) > 12:
                print("Error the inches part of your height must be less than 12.")
                h2 = input("Enter your height in inches, must be less than 12: ")
            print("\nYour Height:",h1,"feet,",h2,"inches")
            print("Your weight:",w,"lbs")
            print("Your BMI:", question5(float(w), h1, h2)[0])
            print("Your Weight Category:", question5(float(w), h1, h2)[1])
            help_console()
            option = input()

        if option == "exit":
            run_cons = False
            exit()