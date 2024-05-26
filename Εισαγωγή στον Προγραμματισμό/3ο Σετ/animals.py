animal_list=[]
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
    def action(self):
        return('Moo')
class Dolphin(Mammal):
    def action(self):
        return('Whistle')
class Serpent(Animal):
    def __init__(self,weight,name='',length='',skincolor=''):
        Animal.__init__(self,weight,name)
        self.skincolor=skincolor
        self.length=length
class Cobra(Serpent):
    def action(self):
        return('Crawl')

Cow1=Cow(124,'Roxanna')
Cow2=Cow(300,haircolor='white')
Dolphin1=Dolphin(56,'Wiley','blue')
Dolphin2=Dolphin(45,'Sylvester','black')
Cobra1=Cobra(15,length=5)
Cobra2=Cobra(6.2,'Queen',3.5,'yellow')

sorted_animal_list=sorted(animal_list, key=lambda x: (x.name,x.weight))
print(sorted_animal_list)
for i in sorted_animal_list:
    print(vars(i), ':', i.action())