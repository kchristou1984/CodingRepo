animal_list=[]
new_list=[]
class Animal():
    def __init__(self,weight,name=''):
        self.weight=weight
        self.name=name
        animal_list.append(self)
        
class Mammal(Animal):
    def __init__(self,weight,name='',haircolor=''):
        Animal.__init__(self,weight,name)
        self.haircolor=haircolor
        
class Cow(Mammal):
    def moo(self):
        print('Mooo')
    def __init__(self,weight,name='',haircolor=''):
        Mammal.__init__(self,weight,name,haircolor)
                
        
class Dolphin(Mammal):
    def whistle(self):
        print('Whistle')
    def __init__(self,weight,name='',haircolor=''):
        Mammal.__init__(self,weight,name,haircolor)
        
    
class Serpent(Animal):
    def __init__(self,weight,name='',length='',skincolor=''):
        Animal.__init__(self,weight,name)
        self.skincolor=skincolor
        self.length=length

class Cobra(Serpent):
    def crawl(self):
        print('Crawl')
    def __init__(self,weight,name='',length='',skincolor=''):
        Serpent.__init__(self,weight,name,length,skincolor)

Cow1=Cow(450,'Roxanna',haircolor='brown')
Cow2=Cow(300,haircolor='white')
Dolphin1=Dolphin(56,'Wiley','blue')
Dolphin2=Dolphin(45,'Sylvester','black')
Cobra1=Cobra(15,length=5)
Cobra2=Cobra(6.2,'Queen',3.5,'yellow')


sorted_animal_list=sorted(animal_list, key=lambda x: (x.name,x.weight))


for i in sorted_animal_list:
    if type(i).__name__=='Cow':
        print(('weight:',i.weight,'name:',i.name,'haircolor:',i.haircolor))
        i.moo()
    elif type(i).__name__=='Dolphin':
        print(('weight:',i.weight,'name:',i.name,'haircolor:',i.haircolor))
        i.whistle()
    elif type(i).__name__=='Cobra':
        print(('weight:',i.weight,'name:',i.name,'length',i.length, 'skincolor:',i.skincolor))
        i.crawl()


