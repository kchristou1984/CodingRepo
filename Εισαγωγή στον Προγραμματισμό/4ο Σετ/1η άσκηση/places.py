from tkinter import *
import urllib.request
import json

lat=''
lng=''
address=''
openplace=''

def func(event):
    location=etext.get()
    if ' ' in location:
        locationsplit=location.split(' ')
        location=','.join(locationsplit)
    
    serviceurl = f'https://maps.googleapis.com/maps/api/place/textsearch/json?query={location}&key=AIzaSyBCOmk9FWoyuPTYzW-QFxW1hx30x2OXRlI'
    print('Retrieving', serviceurl)
    uh=urllib.request.urlopen(serviceurl)
    data=uh.read()
    js=json.loads(data.decode())
    js2=(json.dumps(js, indent=4))
    
        
    #Data
    count=1
    text.delete('1.0', END)
    for item in js['results']:
        name=item["name"]
        lat = item["geometry"]["location"]["lat"]
        lng=item["geometry"]["location"]["lng"]
        address=item["formatted_address"]
        text.insert(INSERT, f' {count}. \n')
        text.insert(INSERT, f' Όνομα: {name} \n')
        text.insert(INSERT, f' Διεύθυνση: {address} \n')

        text.insert(INSERT, f' Latitude: {lat} \n')
        text.insert(INSERT, f' Longitude: {lng} \n')
        if 'opening_hours' in item:
            openplace=item["opening_hours"]["open_now"]
            if openplace==True:
                text.insert(INSERT, f' Η τοποθεσία είναι ανοιχτή \n\n')
            else:
                text.insert(INSERT, f' Η τοποθεσία είναι κλειστή \n\n')
        else:
            text.insert(INSERT, f' Δεν υπάρχουν διαθέσιμες πληροφορίες αν είναι ανοιχτή η τοποθεσία \n\n')
        count+=1
    text.insert(INSERT, f' Βρέθηκαν {count-1} αποτελέσματα \n')

      
#Κύριο παράθυρο
top=Tk()
top.title('Αναζήτηση πληροφοριών τοποθεσίας')
top.geometry("600x300")

#Εισαγωγή τοποθεσίας

etext=StringVar()
e=Entry(top,bd=5, text=etext)
e.bind('<Return>', func)
e.pack(side=TOP)


#Κουμπί αναζήτησης

b=Button(top, text='Αναζήτηση τοποθεσίας', command=lambda: func(None))
b.pack(side=TOP)

#Εκτύπωση δεδομένων στο παράθυρο
text=Text(top)
text.pack(side=BOTTOM)


top.mainloop()

