module dos.strategies;
import model "TargetModel";

tactic phishingEmail() {
    condition {
        true;
    }
    action {
        sendPhishingEmail(l);
    }
    effect {
        hasLogFile;
    }
}

// A.*() means operations on the 'attacker' server, i.e. the "blackhat" server
tactic crackWebCredential() {
    condition {
        true;
    }
    action {
        A.downloadLogFile(l);
        A.decodeLogFile(l);
    }
    effect {
        true;
    }
}

// A is attacker, W is web server, P is payment server
tactic shellInjection() {
    condition {
        true;
    }
    action {
        A.loginWeb(l.webCredential);
        A.injectShell(l.script); // l.script is the php script to be injected
    }
    effect {
        hasCardCredential;
    }
}

tactic crackCardPassword() {
    condition {
        true;
    }
    action {
        A.crackPasswd(l.cardCredential); // unshadow and crack the password
        A.storePasswd(l.cardPassword); // store the cracked password
        A.firmware(l.cardCredential); // execute firmware
        A.transaction(l.cardCredential); // execute transactions
    }
    effect {
        true;
    }
}

// F.*() means operations on the 'ftp' server
tactic deleteFiles() {
    condition {
        true;
    }
    action {
        A.deleteLogFile(l); // delete blackhat's log file
        A.deleteWebCredential(l); // delete blackhat's decoded log file(web credential)
        F.deleteLogFile(l); // delete ftp server's log file
    }
    effect {
        true;
    }
}


