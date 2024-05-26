while True:
    try:
        normal_duration=int(input('What is the normal study duration? '))
        if normal_duration<0:
            print('Study duration should be a positive number! Please try again')
            continue
        break
    except ValueError:
        print('This is not a number! Please try again')

student_sample_size=int(input('What is the student sample size? '))

student_list=[]
ID_list=[]
count=0
while count<student_sample_size:
    try:
        ID=int(input('ID and Years? '))
        years=int(input())
        if years<0 or years<normal_duration or years>2*normal_duration:
            print('Invalid Years')
            continue
        
        for i in student_list:
            ID_list.append(i[0])
        if ID in ID_list or ID<0:
            print('Wrong ID')
            continue
        student_list.append([ID,years])
        count +=1
    except ValueError:
        print('Invalid ID and years')
    
student_list=sorted(student_list, key=lambda x:x[1])

#Υπολογισμός φοιτητών που πήραν πτυχίο στα προβλεπόμενα χρόνια
count_student=0
for student in student_list:
    if student[1]==normal_duration:
        count_student +=1
print(count_student, 'students finished on time(', round(count_student/len(student_list)*100,2), '%)')

#Υπολογισμός μέσου όρου διάρκειας σπουδών
years_sum=sum(n[1] for n in student_list)
print('Average length of study: ', round(years_sum/len(student_list), 2))

#Υπολογισμός μέσου όρου ή διάμεσου
#Αν το μήκος της λίστας ειναι περιττό:
if (len(student_list))%2==1:
    median=(len(student_list)//2)
    print('Median length of study: ', round(student_list[median][1],2))
#Αν το μήκος της λίστας είναι άρτιο: 
if (len(student_list))%2==0:
    first_middle=len(student_list)//2-1
    second_middle=len(student_list)//2
    first_middle=student_list[first_middle][1]
    second_middle=student_list[second_middle][1]
    print('Median length of study: ', round((first_middle+second_middle)/2, 2))   


