import random
path_list=[]
N=int(input('Ποιο είναι το πλήθος των κόμβων:'))
p=float(input('Ποια είναι η πιθανότητα μετάδοσης στο διάστημα [0,1]; '))
A=int(input('Ποιος είναι ο αριθμός του αρχικού κόμβου;'))
B=int(input("Ποιος είναι ο αριθμός του τελικού κόμβου;"))
random.seed(20)
path_list.append(A)

while path_list[-1]!=B:
    if random.random()<p:
        path_list.append(B)
    else:
        if random.random()<0.1:
            pass
        else:
            neos_komvos=random.randint(1,N)
            if neos_komvos==path_list[-1]:
                pass
            else:
                path_list.append(neos_komvos)

print(path_list)
