import socket
import threading
import os
import json



def handle_client(conn,addr):
    print(f'[New connection] {addr} connected.')
    try:
        while True:
            msg=conn.recv(1024).decode('utf-8')
            print(msg)
            msg_to_send=input(">")
            conn.send(msg_to_send)
        
    except (ConnectionResetError, ConnectionAbortedError):
        print(f'Client {addr} disconnected... ') 
        conn.close()  
   
def start():
    server.listen()
    while True:
        conn, addr = server.accept()
        thread=threading.Thread(target=handle_client, args=(conn,addr))
        thread.start()
        print(f'[Active connections] {threading.active_count()-1}')
       

port = int(input('Σε ποιο port θα γίνει η σύνδεση;'))
host = socket.gethostname()
server=socket.socket(socket.AF_INET, socket.SOCK_STREAM)
address=(host,port)
server.bind(address)

print('Server is starting...')

start()

