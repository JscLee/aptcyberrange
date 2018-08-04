module dos.strategies;
import model "Model.java" {Model.java as M};
//import model "ZNewsSys:Acme" { ZNewsSys as M, ZNewsFam as T, ZNewsDosFam as D} ;
// A is attacker, W is web server
tactic phishingEmail() {
    condition {
        exists lb : server in W.servers | !lb.logFile;
    }
    action {
        set lbs = {select l : server in W.servers | !l.logFile};
        for (server l : lbs) {
            A.sendPhishingEmail(l);
        }
    }
    effect {
        forall lb : server in W.servers | lb.logFile;
    }
}

// F is FTP server
tactic crackWebCredential() {
    condition {
        exists lb : server in F.servers | lb.logFile;
    }
    action {
        set lbs = {select l : server in F.servers | l.logFile};
        for (server l : lbs) {
            A.downloadLogFile(l);
            A.decodeLogFile(l);
        }
    }
    effect {
        true;
    }
}

// A is attacker, W is web server, P is payment server
tactic shellInjection() {
    condition {
        exists lb : server in A.servers | lb.webCredential; // credential for web server
    }
    action {
        set lbs = {select l : server in A.servers | l.webCredential};
        for (server l : lbs) {
            A.login(l.webCredential);
            A.inject(l.script); // l.script is the php script to be injected
        }
    }
    effect {
        forall lc : server in A.servers | lc.cardCredential;
    }
}

tactic crackCardPassword() {
    condition {
        exists lb : server in A.servers | lb.cardCredential; // credential for payment server
        
    }
    action {
        set lbs = {select l : server in A.servers | l.cardCredential};
        for (server l : lbs) {
            A.crackPasswd(l.cardCredential); // unshadow and crack the password
            A.storePasswd(l.cardPassword); // store the cracked password
            A.firmware(l.cardCredential); // execute firmware
            A.tracsaction(l.cardCredential); // execute transactions
        }
    }
    effect {
        true;
    }
}

tactic deleteFiles() {
    condition {
        true;
    }
    action {
        set lbs = {select l : server in A.servers | l.webCredential};
        for (server l : lbs) {
            A.deleteFiles(l.logFile); // delete blackhat's log file
            A.deleteFiles(l.webCredential); // delete blackhat's decoded log file(web credential)
            A.deleteFiles(l.cardCredential); // delete blackhat's card credential files
            F.deleteFiles(l.logFile); // delete ftp server's log file
        }
    }
    effect {
        true;
    }
}


