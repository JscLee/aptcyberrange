module dos.strategies; 
// A is attacker, W is web server
tactic phishingEmail() {
    // do this tactic if: there exists a web server (currently only one)
    // which has no credential
    condition {
        exists lb : server in W.servers | !lb.credential;
    }
    action {
    // create a list of web servers, which are the targets of phishing emails
        set lbs = {select l : server in W.servers | !l.credential};
        for (server l : lbs) {
            A.sendPhishingEmail(l);
        }
    }
    effect {
    // check this condition in a loop, if true, then break
        forall lb : server in W.servers | lb.credential;
    }
}
