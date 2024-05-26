print('Στην φάρμα ζουν κουνέλια και κοτόπουλα. Μετράμε 35 κεφάλια και 94 πόδια συνολικά')
#Έστω ότι x είναι τα κοτόπουλα και y τα κουνέλια
#Τα κουνέλια έχουν 4 πόδια και τα κοτόπουλα 2
zwa=[(x,y) for x in range(36) for y in range(36) if x+y==35 and 4*y+2*x==94]
print('Tα κουνέλια είναι',zwa[0][0],'και τα κοτόπουλα είναι',zwa[0][1])
try:
    kefalia,podia=input('Πόσα κεφάλια και πόδια υπάρχουν στη δική σου φάρμα;').split()
    k=int(kefalia)
    p=int(podia)
    zwa=[(x,y) for x in range(k+1) for y in range(p+1) if x+y==k and 4*y+2*x==p]
    if zwa:
        print('Tα κουνέλια είναι',zwa[0][0],'και τα κοτόπουλα είναι',zwa[0][1])
    else:
        print('Δεν υπάρχει λύση')
except ValueError:
    print('Δοκίμασε ξανά')
     
