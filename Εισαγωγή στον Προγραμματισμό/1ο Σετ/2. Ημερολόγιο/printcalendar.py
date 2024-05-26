def mycal(year,month):
    import calendar
    hmeres=[]
    #Υπολογισμός πρώτης ημέρας όπου Monday=0 κοκ
    
    first_day=calendar.monthrange(year,month)[0]
    
    print(calendar.month_name[month], year)
    print('Mo''\t''Tu''\t''We''\t''Th''\t''Fr''\t''Sa''\t''Su')

    #Προσθήκη ημερών του κάθε μήνα σε λίστα
    for i in range(1, calendar.monthrange(year,month)[1]):
        hmeres.append(i)

    
    teleftaia_hmera_prwths_grammhs=8-first_day

    #Υπολογισμός των ημερών στην 1η γραμμή
    
    hmeres_prwths_grammhs=[]
    
    for hmera in range(2,teleftaia_hmera_prwths_grammhs):
        hmeres_prwths_grammhs.append(hmera)
    
    print(f"{'\t'*first_day}1",end='\t')
    for n in hmeres_prwths_grammhs:
        print(n,end='\t')
    print('\n')
    count=0
    ypoloipes_meres=[]
    for z in range(teleftaia_hmera_prwths_grammhs,calendar.monthrange(year,month)[1]+1):
        count=count+1
        ypoloipes_meres.append(z)
        print(z, end='\t')
        if count%7==0:
            print('\n')
            count=0


print('____________Ημερολόγιο____________________')
year=int(input('Έτος; '))
month=int(input('Μήνας; '))
mycal(year, month)
