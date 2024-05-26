import csv

import math


with open('filename.csv', 'r', encoding='utf-8-sig') as csvfile:
    with open('filename_new.csv', 'w') as csvfile_new:
        csvwriter = csv.writer(csvfile_new)
        csvreader=csv.reader(csvfile)
        for row in csvreader:
            row_sum=sum(int(num) for num in row)
            #Υπολογισμός μέσης τιμής κάθε γραμμής
            average=row_sum/len(row)
            #Υπολογισμός τυπικής απόκλισης
            deviation=round(math.sqrt(sum((int(num)-average)**2 for num in row)/(len(row)-1)),2)

            #Εγγραφή μέσης τιμής, τυπικής απόκλισης στο αρχειο
            
            row.append(str(average))
            row.append(str(deviation))
            csvwriter.writerow(row)

csvfile.close()
csvfile_new.close()

            


        

    




