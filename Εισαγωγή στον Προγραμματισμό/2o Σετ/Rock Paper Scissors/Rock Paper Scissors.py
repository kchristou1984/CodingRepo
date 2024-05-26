


player_input=0
win_count=0
lose_count=0
draw_count=0
rock=("""
    _______
---'   ____)  
      (_____)  
      (_____)  
      (____)
---.__(___)
    """)

    
paper=("""
    _______
---'   ____)____  
          ______)  
          _______)  
         _______)
---.__________) 
    """)

    
scissors=("""
    _______
---'   ____)____  
          ______)  
       __________)  
      (____)
---.__(___) 
    """)

while player_input!='n':
    player_choice=input('1: Πέτρα / 2: Χαρτί / 3: Ψαλίδι > ')
    print('_______________ΔΙΑΛΕΞΕΣ____________________')
    if player_choice=='1':
        print(rock)
    elif player_choice=='2':
        print(paper)
    elif player_choice=='3':
        print(scissors)
    print('_________Ο ΥΠΟΛΟΓΙΣΤΗΣ ΔΙΑΛΕΞΕ_____________')
    import random
    choice=random.randint(1,3)
    if choice==1:
        print(rock)
    elif choice==2:
        print(paper)
    elif choice==3:
        print(scissors)

    if player_choice=='1' and choice==3:
        print("Κέρδισες")
        win_count +=1
    elif player_choice=='2' and choice==1:
        print("Κέρδισες")
        win_count +=1
    elif int(player_choice)==choice:
        print("Ισοπαλία")
        draw_count +=1
    elif player_choice=='1' and choice==2:
        print("Έχασες")
        lose_count +=1
    if player_choice=='3' and choice==2:
        print("Κέρδισες")
        win_count +=1
    if player_choice=='2' and choice==3:
        print("Έχασες")
        lose_count +=1
    if player_choice=='3' and choice==1:
        print("Έχασες")
        lose_count +=1
    player_input=input('Θέλεις να παίξεις ξανά; Πάτα Enter για συνέχεια ή N για έξοδο ').lower()


if lose_count==1:
    print('Εχασες', lose_count, 'φορά')
else:
    print('Έχασες:', lose_count,'φορές')
if win_count==1:
    print('Κέρδισες:', win_count, 'φορά')
else:
    print('Κέρδιδες:', win_count,'φορές')
if draw_count==1:
    print('Ήρθες ισοπαλία με τον υπολογιστή', draw_count, 'φορά')
else:
    print('Ήρθες ισοπαλία με τον υπολογιστή:', draw_count,'φορές')


