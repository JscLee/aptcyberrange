import sys
import time
import datetime
import random
from watchdog.observers import Observer
from watchdog.events import PatternMatchingEventHandler

# from .models import Media

PROB = 0.5

class MyHandler(PatternMatchingEventHandler):
    patterns=["*.desc"]

    def process(self, event):
        """
        event.event_type
            'modified' | 'created' | 'moved' | 'deleted'
        event.is_directory
            True | False
        event.src_path
            path/to/observed/file
        """

        log_file = open("watchdogOutput.txt", 'a')
        log_file.write(str(datetime.datetime.now()) + " " + str(event.event_type) + '\n')
        if (random.random() < PROB):
            log_file.write("phishing email detected\n")
        log_file.close()

    # for testing purpose only, only need to detect newly found files
    #def on_modified(self, event):
    #    self.process(event)

    def on_created(self, event):
        self.process(event)


if __name__ == '__main__':
    args = sys.argv[1:]
    observer = Observer()
    observer.schedule(MyHandler(), path=args[0] if args else '.', recursive=True)
    observer.start()

    try:
        while True:
            time.sleep(1)
    except KeyboardInterrupt:
        observer.stop()

    observer.join()