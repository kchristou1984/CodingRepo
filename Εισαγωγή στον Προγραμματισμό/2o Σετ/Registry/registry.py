student_list=[]
stoixeia_foithth=tuple()

# def readStudent():
def addStudent():
    student_name=input('Ποιο είναι το όνομα του φοιτητή;> ').lower()
    student_surname=input('Ποιο είναι το επίθετο του φοιτητή;> ').lower()
    student_adress=input('Ποιο είναι η διεύθυνση του φοιτητή;> ').lower()
    student_phonenumber=input('Ποιο είναι το τηλέφωνο του φοιτητή;> ').lower()
    if student_name=='' or student_surname=='' or student_phonenumber=='' or student_adress=='':
        print("Τα στοιχεία του φοιτητή είναι ελλιπή")
        return None
    stoixeia_foithth=(student_name,student_surname,student_adress,student_phonenumber)
    print('\nΗ εγγραφή του φοιτητή ήταν επιτυχής.\n')
    student_list.append(stoixeia_foithth)
def removeStudent():
    student_rem=input('Γράψτε το όνοματεπώνυμο του φοιτητή που θέλετε να διαγράψετε: ').lower()
    student_name,student_surname=student_rem.split()
    for tup in student_list:
        if student_name in tup and student_surname in tup:
            student_list.remove(tup)
    print('\nΟ φοιτητής διαγράφηκε\n')  
def printStudent():
    student_print=input('Γράψτε το ονοματεπώνυμο του φοιτητή που θέλετε να εκτυπωθούν τα στοιχεία του: ').lower()
    student_name,student_surname=student_print.split()
    for tup in student_list:
        if student_name in tup and student_surname in tup:
            print('Όνομα φοιτητή:',tup[0].capitalize())
            print('Επίθετο φοιτητή:',tup[1].capitalize())
            print('Διεύθυνση φοιτητή:',tup[2].title())
            print('Τηλεφωνο φοιτητή:',tup[3],'\n')
def printStudentlist():
    print('________ΣΤΟΙΧΕΙΑ ΦΟΙΤΗΤΩΝ________\n')
    for student in student_list:
        print('Όνομα φοιτητή:',student[0].capitalize())
        print('Επίθετο φοιτητή:',student[1].capitalize())
        print('Διεύθυνση φοιτητή:',student[2].title())
        print('Τηλεφωνο φοιτητή:',student[3],'\n')
        

while True:
    user_choice=input('_______ΠΡΟΓΡΑΜΜΑ ΔΙΑΧΕΙΡΙΣΗΣ ΦΟΙΤΗΤΩΝ_______\n\n1.Εγγραφή Φοιτητή\n2.Διαγραφή Φοιτητή\n3.Εκτύπωση Στοιχείων Φοιτητή\n4.Εκτύπωση Λίστας Φοιτητών\n0.Τερματισμός\n')
    if user_choice=='0':
        break    
    elif user_choice=='1':
        addStudent()
        continue
    elif user_choice=='2':
        removeStudent()
    elif user_choice=='3':
        printStudent()
    elif user_choice=='4':
        printStudentlist()
        continue
    else:
        print('Λαθος επιλογή. Παρακαλώ επαναλάβετε.')
        continue


    

