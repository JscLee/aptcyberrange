// A is attacker, W is web server
tactic phishingEmail() {
    condition {
        exists lb : server in W.servers | !lb.credential;
    }
    action {
        set lbs = {select l : server in W.servers | !l.credential};
        for (server l : lbs) {
            A.sendPhishingEmail(l);
        }
    }
    effect {
        forall lb : server in W.servers | lb.credential;
    }
}
