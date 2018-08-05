import json
import sys

def main(argv):
    textToReplace = argv[0]

    fileToSearch  = '/home/ubuntu/logInfo.json'

    with open(fileToSearch, 'r') as f:
        data = json.load(f)

    data['Password'] = textToReplace
    
    with open(fileToSearch, 'w') as f:
        json.dump(data, f)


if __name__ == "__main__":
    main(sys.argv[1:])