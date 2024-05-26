import socket
import json
import os

def send(msg):
    message=msg.encode('utf-8')
    client.send(message)

def receive():
    reply=client.recv(1024)    
    apnt=reply.decode('utf-8')
    print(apnt)

    

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
host = socket.gethostname()

try:
    port=int(input('Σε ποιο port θα γίνει η σύνδεση;'))
    ADDR=(host,port)
    client.connect(ADDR)
    incoming=client.recv(1024)
    incoming=incoming.decode('utf-8')
    print(incoming)

except ConnectionRefusedError:
    print('Δεν μπορει να πραγματοποιηθει η σύνδεση')
    client.close()



connected=True

while connected:
    msg=input(">")
    send(msg)
    receive()
    
client.close()    
    
    
    

    
