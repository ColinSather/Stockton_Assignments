import csv
import pandas as pd

def reader(file):
    # read in file and output count of unique values
    with open(file, newline='') as f:
        reader = csv.reader(f)
        data = list(reader)
    return data    
    
if __name__ == "__main__":
    #data = reader("data.csv")
    #print(data)
    data = pd.read_csv("data.csv")
    print(data["TID"])
