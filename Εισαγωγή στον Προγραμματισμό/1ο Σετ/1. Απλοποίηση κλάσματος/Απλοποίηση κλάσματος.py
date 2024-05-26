#Απλοποίηση κλάσματος
koinoi_diairetes=[]
print('________________Απλοποίηση κλασματος________________ \n')
x=input('Ποιος είναι ο αριθμητής του κλάσματος: \n')
y=input('Ποιος είναι ο παρανομαστής του κλάσματος: \n')
try:
    x=int(x)
    y=int(y)
except:
    print('Αυτα δεν είναι αριθμοί. Δοκίμασε ξανά!!')
if x<=y:
    for i in range (1,x+1):
        if x%i==0 and y%i==0:
            koinoi_diairetes.append(i)
            mcd=koinoi_diairetes[-1]        
else:
    for i in range (1,y+1):
        if x%i==0 and y%i==0:
            koinoi_diairetes.append(i)
            mcd=koinoi_diairetes[-1]
            

print('Ο μεγιστος κοινός διαιρέτης των δύο είναι:', koinoi_diairetes[-1])
print('Το κλάσμα σου είναι το:', x,'/',y)
print('Η απλοποιημένη του μορφή είναι το:', int(x/mcd), '/', int(y/mcd))
# def mcd(x,y):
#     return (x-y)
    