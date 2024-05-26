from tkinter import *
import urllib.request
import json
import urllib.parse

def func(event):
    location=etext.get()
    print("Η τοποθεσία που ψάχνεις ειναι: "+location)
    serviceurl = f'https://maps.googleapis.com/maps/api/place/textsearch/json?query={location}&key=AIzaSyBCOmk9FWoyuPTYzW-QFxW1hx30x2OXRlI'
    print('Retrieving', serviceurl)
    uh=urllib.request.urlopen(serviceurl)
    data=uh.read()
    js=json.loads(data.decode())
    print(json.dumps(js, indent=4))
    #Δημιουργία αρχείου JSON
    filename = "data.json"
    with open("data.json", 'w') as file:
        json.dump(js, file, indent=4)
#Κύριο παράθυρο
top=Tk()
top.title('Αναζήτηση πληροφοριών τοποθεσίας')
top.geometry("400x50")


#Εισαγωγή τοποθεσίας

etext=StringVar()
e=Entry(top,bd=5, text=etext)
e.bind('<Return>', func)
e.pack(side=LEFT)


#Κουμπί αναζήτησης

b=Button(top, text='Αναζήτηση τοποθεσίας', command=lambda: func(None))
b.pack(side=RIGHT)

top.mainloop()


