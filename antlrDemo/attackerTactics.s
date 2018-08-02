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
        exists lc : server in A.servers | !lc.webCredential;
    }
    action {
        set lbs = {select l : server in F.servers | l.logFile};
        for (server l : lbs) {
            A.downloadLogFile(l);
            A.decodeLogFile(l);
        }
    }
    effect {
        forall lc : server in A.servers | lc.webCredential;
    }
}

// A is attacker, W is web server, P is payment server
tactic shellInjection() {
    condition {
        exists lb : server in A.servers | lb.webCredential; // credential for web server
        exists lc : server in A.servers | !lc.cardCredential && !lc.cardPassword; // no credential and password for payment server
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
        exists lb : server in A.servers | lb.cardCredential && !lb.cardPassword; // credential for payment server
        
    }
    action {
        set lbs = {select l : server in A.servers | l.cardCredential && !l.cardPassword};
        for (server l : lbs) {
            A.crackPasswd(l.cardCredential); // unshadow and crack the password
            A.storePasswd(l.cardPassword); // store the cracked password
        }
    }
    effect {
        forall lb : server in A.servers | lb.cardCredential && lb.cardPassword;
    }
}

tactic pirateCard() {
    condition {
        exists lb : server in A.servers | lb.cardCredential && lb.cardPassword && !lb.gotMoney; // credential for payment server
    }
    action {
        set lbs = {select l : server in A.servers | l.cardCredential && l.cardPassword && !l.gotMoney};
        for (server l : lbs) {
            A.firmware(l.cardCredential, l.cardPassword); // execute firmware
            A.tracsaction(l.cardCredential, l.cardPassword); // execute transactions
        }
    }
    effect {
        forall lb : server in A.servers | lb.cardCredential && lb.cardPassword && lb.gotMoney;
    }
}

