"""
Attempt at extra credit, ran out of time unfortunatly.
"""
import datetime, random

def generate_bdays(n):
    bdays = []
    for i in range(n):
        start_date = datetime.date(2020, 1, 1)
        end_date = datetime.date(2020, 2, 1)
        time_between_dates = end_date - start_date
        days_between_dates = time_between_dates.days
        random_number_of_days = random.randrange(days_between_dates)
        random_date = start_date + datetime.timedelta(days=random_number_of_days)
        bdays.append(random_date)
    return bdays

bday_data = []
n = [5, 10, 20, 25, 30, 45, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100]
for j in n:
    row = []
    for date in generate_bdays(j):
        row.append(date)
    bday_data.append(row)
bdcounts = []
for line in bday_data:
    group = {i:line.count(i) for i in line}
    bdcounts.append(group)

for x in bdcounts:
    for key, value in x.items():
        print(key, value)    