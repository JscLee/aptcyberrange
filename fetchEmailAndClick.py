from subprocess import Popen, PIPE
import shlex
import sys
import time
import datetime
import random
import os
from watchdog.observers import Observer
from watchdog.events import PatternMatchingEventHandler

class MyHandler(PatternMatchingEventHandler):
    patterns=["*.contractor"]

    def process(self, event):
        """
        event.event_type
            'modified' | 'created' | 'moved' | 'deleted'
        event.is_directory
            True | False
        event.src_path
            path/to/observed/file
        """

        print("process run")
        time.sleep(2) # so that watchdogExample.py can run

        if (os.path.isfile(event.src_path)): # if the file still exists
            print("email still exists, move\n")
            mvmsg = "mv " + str(event.src_path)[2:] + " /home/ubuntu"
            # print(mvmsg)
            unpackmsg = "munpack " + str(event.src_path)[11:]
            # print(unpackmsg)
            mover = Popen(shlex.split(mvmsg), stdout=PIPE)
            unpacker = Popen(shlex.split(unpackmsg), stdout=PIPE)
            move_log = open("movelog.txt", 'a')
            move_log.write(str(datetime.datetime.now()) + " move and unpack email" + '\n')
            move_log.write(str(mover.communicate()))
            move_log.write(str(unpacker.communicate()))
            move_log.close()
            # could run the attachment, or in a separate file

    def on_created(self, event):
        self.process(event)

if __name__ == '__main__':
    args = sys.argv[1:]
    observer = Observer()
    observer.schedule(MyHandler(), path=args[0] if args else './mail/new', recursive=True)
    observer.start()

    try:
        while True:
            time.sleep(1)
            fetcher = Popen(["fetchmail"], stdout=PIPE, stderr=PIPE)
            fetch_log = open("fetchlog.txt", 'a')
            fetch_log.write(str(datetime.datetime.now()) + " " + str(fetcher.communicate()) + '\n')
            fetch_log.close()
    except KeyboardInterrupt:
        observer.stop()

    observer.join()
