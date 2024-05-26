class Mylist(list):     
    #Πρόσθεση λιστών
    def __add__(self,other):
        new_list=[]
        for i in self:
            new_list.append(i)
        for j in other:
            if j not in new_list:
                new_list.append(j)
        sorted_result=sorted(new_list)
        return(sorted_result)
    
    #Διαφορά λιστών
    def __sub__ (self,other):
        new_list=[]
        for i in self:
            new_list.append(i)
        for j in other:
            if j in new_list:
                new_list.remove(j)
        sorted_result=sorted(new_list)
        return(sorted_result)
    #Τομή λιστών
    def __or__(self,other):
        new_list=[]
        for i in self:
            if i in other:
                new_list.append(i)
        sorted_result=sorted(new_list)
        return(sorted_result)

list1=Mylist([1,2,5])
list2=Mylist([1,6,9])
list3=Mylist([2,9,10])
print(list1+list2)
print(list1-list2)
print(list2|list3)