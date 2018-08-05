import sys
import datetime
import random
import os

PROB = 0.5

if __name__ == '__main__':

    path = '/home/ubuntu/mail/new/'
    log_file = open("filter.txt", 'a')

    try:
        with open('/home/ubuntu/mailpath.txt') as f:
            mv_path = f.readline().strip()
            if mv_path[-1] != '/':
                mv_path = mv_path + '/'
    except:
        mv_path = '/home/ubuntu/mail/new/'

    for file in os.listdir(path):
        if (os.path.isfile(path + file)):
            try:
                log_file.write(str(datetime.datetime.now()) + '\n')
                if (random.random() < PROB):
                    log_file.write("phishing email detected in " + str(path) + '\n')
                    os.remove(path + file);
                    log_file.write("phishing email deleted\n")
                else:
                    os.rename(path + file, mv_path + file)
                    log_file.write("move email\n")
            except:
                pass

    log_file.close()
