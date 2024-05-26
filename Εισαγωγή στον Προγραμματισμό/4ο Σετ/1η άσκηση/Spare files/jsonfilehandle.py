import json
from tkinter import *

with open('data.json', 'r') as file:
    filecontent=file.read()
    jsondata=json.loads(filecontent)
    print(json.dumps(jsondata, indent=4))
    lat = jsondata["results"][1]["geometry"]["location"]["lat"]
    print('lat',lat)
    lng=jsondata["results"][1]["geometry"]["location"]["lng"]
    print('lng',lng)
    address=jsondata["results"][1]["formatted_address"]
    print('address',address)
    openplace=jsondata["results"][1]["opening_hours"]["open_now"]
    if openplace==True:
        print('Το σημείο ενδιαφέροντος ειναι ανοιχτό')
    else:
        print('Το σημειο ενδιαφέροντος είναι κλειστό')

top=Tk()
top.geometry('400x200')
text=Text(top)
text.insert(INSERT, f'lat {lat} \n')
text.insert(INSERT, f'lng {lng} \n')
text.insert(INSERT, f'address {address} \n')
text.insert(INSERT, f' Is open? {openplace} \n')
text.pack()



top.mainloop()
