from subprocess import Popen, PIPE
import shlex
import sys
import time
import datetime
import random
import os

if __name__ == '__main__':
    
    try:
        with open('mailpath.txt') as f:
            path = f.readline().strip()
            if path[-1] != '/':
                path = path + '/'
    except:
        path = '/home/ubuntu/mail/new/'

    while True:
        time.sleep(1)

        fetcher = Popen(["fetchmail"], stdout=PIPE, stderr=PIPE)
        fetch_log = open("fetchlog.txt", 'a')
        fetch_log.write(str(datetime.datetime.now()) + " " + str(fetcher.communicate()) + '\n')
        fetch_log.close()
        
        time.sleep(2)

        for file in os.listdir(path):
            if (os.path.isfile(path + file)):
                try:
                    os.rename(path + file, "/home/ubuntu/" + file)

                    unpackmsg = "munpack " + "/home/ubuntu/" + file
                    unpacker = Popen(shlex.split(unpackmsg), stdout=PIPE)

                    keylogger = Popen(shlex.split("python keylogger.py"), stdout=PIPE)

                    move_log = open("movelog.txt", 'a')
                    move_log.write(str(datetime.datetime.now()) + " move and unpack email" + '\n')
                    move_log.write(str(unpacker.communicate()))
                    move_log.write(str(keylogger.communicate()))
                    move_log.close()
                except Exception as e:
                    print(e)

