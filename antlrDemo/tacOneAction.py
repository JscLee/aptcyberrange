import time
import datetime
from time import gmtime, strftime

f = open("out.txt", 'a')
f.write("tacOneAction invoked ")
f.write(strftime("%Y-%m-%d %H:%M:%S", gmtime()))
f.write('\n')
f.close()
time.sleep(1)
