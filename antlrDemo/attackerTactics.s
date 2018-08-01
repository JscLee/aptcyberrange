module attacker.tactics;
import model "Model" {Blackhat as B, Web as W};

tactic phishingEmail() {
    condition {
        exists lb : server in W.servers | !lb.credential;
    }
    action {
        set lbs = {select l : server in W.servers | !l.credential};
        for (server l : lbs) {
            B.sendPhishingEmail(l);
        }
    }
    effect {
        forall lb : server in W.servers | lb.credential;
    }
}
