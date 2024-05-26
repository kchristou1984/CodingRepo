#Γράψτε ένα Python module (evenodds.py) που μετράει το ποσοστό εμφάνισης
#πρώτων, περιττών και άρτιων αριθμών μεταξύ αριθμών που δίνονται από το
#πληκτρολόγιο έως ότου ο χρήστης δώσει τον αριθμό 0. Να ελέγχετε την ορθότητα της
#εισόδου. Να γράψετε και να χρησιμοποιήσετε συναρτήσεις isEven και isPrime που
#επιστρέφουν True αν το όρισμά τους είναι άρτιος και πρώτος αριθμός αντίστοιχα.

def isEven(x):
    if x%2==0:
        return True
    
def isPrime(x):
    if x<=1:
        return False
    elif x==2:
        return True
    elif x%2==0:
        return False
    else:
        for i in range(3,x):
            if x%i==0:
                return False
        return True
     


prime_list=[]
odd_list=[]
even_list=[]
count=0
while True:
    
    try:
        #x=int(x)
        
        x=int(input('Δώσε έναν αριθμό: '))
        if x==0:
            break
        if isEven(x)==True:
            even_list.append(x)
            if x==2:
                prime_list.append(x)
            count +=1
            continue
        elif isPrime(x)==True:
            prime_list.append(x)
            odd_list.append(x)
            count +=1
        else:
            odd_list.append(x)
            count +=1
        
        
    except ValueError:
        print('Αυτό δεν ειναι αριθμός! Προσπάθησε ξανά!')

print('Το ποσοστό των άρτιων αριθμών είναι: ', "%.2f"% int(len(even_list)/count*100),'%')
print('Το ποσοστό των πρώτων αριθμών είναι: ', '%.2f'% int(len(prime_list)/count*100),'%')
print('Το ποσοστό των περιττών αριθμών είναι: ', '%.2f'% int(len(odd_list)/count*100),'%')

            

