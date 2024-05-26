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
def receivelist():
    reply=client.recv(1024)    
    received_list=json.loads(reply.decode('utf-8'))
    print(received_list)
    
    



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
    msg_to_send=input('>')
    send(msg_to_send)
    if msg_to_send=='list':
        receivelist()
        #continue
    elif msg_to_send=='bye':
        receive()
        connected=False
        break
    elif 'put' in msg_to_send:
        filepath=msg_to_send.split("'")[1]
        file= open(filepath,"rb")
        file_size=os.path.getsize(filepath)
        filename=os.path.basename(filepath)
        client.send(filename.encode('utf-8'))
        client.send(str(file_size).encode('utf-8'))
        data=file.read()
        client.sendall(data)
        print(filename, 'sent')
        file.close()
    elif 'get' in msg_to_send:
        filename=msg_to_send.split("'")[1]
        client.send(filename.encode('utf-8'))
        
        filesize=int(client.recv(1024).decode('utf-8'))
        print(filesize)
        file_bytes=b""
        file=open(filename, "wb")
        while len(file_bytes)<filesize:
            data=client.recv(1024)
            file_bytes+=data
        file.write(file_bytes)
        file.close
        print(filename,'received...')
        
    else:
        receive()
    
client.close()    
    
    
    

    
