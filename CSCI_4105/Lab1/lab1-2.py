import matplotlib.pyplot as plt
plt.style.use('ggplot')

def help_console():
    print("Type 1 to display a bar chart.")
    print("Type 2 to display a scatter plot chart.")
    print("Type 3 to generate a list of days and workout times.")
    print("Type 'exit' to quit the program.\n")

def bar_chart():
    x = ["Java", "Python", "PHP", "JavaScript", "C#", "C++"]
    oscars = [19.2, 22.6, 8.8, 7.6, 7.2, 6.7]
    x_pos = [i for i, _ in enumerate(x)]
    plt.bar(x_pos, oscars, color='green')
    plt.xlabel("Programming Language")
    plt.ylabel("Popularity Rating")
    plt.title("Programming Language Popularity Ratings")
    plt.xticks(x_pos, x)
    plt.show()

def scat_chart():
    x = [88, 92, 80, 89, 100, 80, 60, 100, 80, 34]
    y = [35, 79, 79, 48, 100, 88, 32, 45, 20, 30]
    labels =  [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
    x_pos = [i for i, _ in enumerate(x)]
    plt.scatter(x_pos, y, color='green')
    plt.xlabel("Math Scores")
    plt.ylabel("Sciencec Scores")
    plt.title("Grade Ranges")
    plt.xticks(x_pos, x)
    plt.show()

def workout_list():
    x = [1, 3, 6, 9, 10, 11, 12, 13, 14]
    times = [25, 55, 20, 42, 10, 60, 60, 60, 60]
    x_pos = [i for i, _ in enumerate(x)]
    plt.plot(x_pos, times, color="Blue")
    plt.xlabel("Workout Days")
    plt.ylabel("Time Spent")
    plt.title("Fitness Chart")
    plt.xticks(x_pos, x)
    plt.show()

if __name__ == "__main__":
    print("Data visualization program by Colin Sather")
    help_console()
    option = input()

    if option == "1":
        bar_chart()
        help_console()
    
    if option == "2":
        scat_chart()
        help_console()

    if option == "3":
        workout_list()
        help_console()

    if option == "exit":
        exit()