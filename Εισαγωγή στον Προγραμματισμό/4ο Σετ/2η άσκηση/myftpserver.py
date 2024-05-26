import socket
import threading
import os
import json



def handle_client(conn,addr):
    print(f'[New connection] {addr} connected.')
    conn.send(
        '''Έχεις τις παρακάτω επιλογές:\n1.list: για την απαρίθμηση των αρχείων του τρέχοντα καταλόγου \n2.mkdir'dir': για δημιουργία φακέλου\n3.put'διαδρομή αρχείου': για την αποστολή του αρχείου\n4.get'αρχείο': για την λήψη του αρχείου\n5.cd'κατάλογο': για να αλλάξει ο τρέχοντας κατάλογος\n6.bye: για την αποσύνδεση από τον εξυπηρετητή
        '''.encode('utf-8'))
    try:
        while True:
            msg=conn.recv(1024).decode('utf-8')
                       
            if msg=='bye':
                print(f'Client {addr} disconnected... ')
                conn.send('You are now disconnected'.encode('utf-8')) 
                conn.close() 
                break
            elif msg=='getcwd':
                reply=os.getcwd()
                reply=reply.encode('utf-8')
                conn.send(reply)
            elif msg=='list':
                list_dir=os.listdir()
                json_list=json.dumps(list_dir)
                conn.send(json_list.encode('utf-8'))
            elif 'mkdir' in msg:
                folder_name=msg.split("'")[1]
                os.mkdir(folder_name)
                conn.send(f'Folder {folder_name} was created'.encode('utf-8'))
            elif 'cd' in msg:
                try:
                    folder_name=msg.split("'")[1]
                    os.chdir(folder_name)
                    conn.send(f'You are in {folder_name} now'.encode('utf-8'))
                except (IndexError, FileNotFoundError):
                    conn.send(f'Please provide a valid folder name'.encode('utf-8'))
            elif 'put' in msg:
                file_name= conn.recv(1024).decode('utf-8')
                
                file_size=int(conn.recv(1024).decode('utf-8'))
                
                file=open(file_name, "wb")
                file_bytes=b""
                while len(file_bytes)<file_size:
                    data=conn.recv(1024)
                    file_bytes +=data
                file.write(file_bytes)
                file.close()
                print(f'{file_name} received')
            elif 'get' in msg:
                file_name=conn.recv(1024).decode('utf-8')
                file=open(file_name, "rb")
                file_size=os.path.getsize(file_name)
                conn.send(str(file_size).encode('utf-8'))
                data=file.read()
                conn.sendall(data)
                file.close()
                
            else:
                conn.send('Παρακαλώ επαναλάβετε την εντολή'.encode('utf-8'))
        
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

