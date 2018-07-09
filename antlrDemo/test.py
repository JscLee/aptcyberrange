import time
while(True):
	f = open("out.txt", 'a')
	f.write("hi")
	f.close()
	time.sleep(1)
