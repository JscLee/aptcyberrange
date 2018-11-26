scp c:\APT\payment-server\pos_firmware.py update@sales.fazio.com:\APT\update\pos_firmware.py
ssh update@172.31.92.206
move /Y c:\APT\update\pos_firmware.py c:\APT\payment-server
pythonw /home/ubuntu/payment-server/pos_firmware.py 
exit