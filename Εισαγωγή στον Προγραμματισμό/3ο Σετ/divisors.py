def divisor_func(number):
    count=0
    for i in range(1,number+1):
        if number%i==0:
            count+=1
            #print(i)
    return count
        
n=int(input('Μέχρι ποιον αριθμό θέλεις τους διαιρέτες; '))

# #Γεννήτρια για τον αριθμό των διαιρετών μέχρι το n
divisors=(divisor_func(number) for number in range(1,n+1))
divisors_list=[]

for i in divisors:
    divisors_list.append(i)
#     print(i, end=' ')

print('Ο αριθμός των διαιρετών των ακεραίων μέχρι το',n,'είναι:',divisors_list)
