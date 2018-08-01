module defender.tactics;
import model "Model" {Mail as M};

tactic filterEmail() {
    condition {
        exists lb : M.mail in M.newMail | lb.isPhishingEmail;
    }
    action {
        set lbs = {select l : M.mail in M.newMail | l.isPhishingEmail};
        for (M.mail l : lbs) {
            M.notify(l, false);
            M.block(l);
        }
    }
    effect {
        forall lb : M.mail in M.newMail | !lb.isPhishingEmail;
    }
}
 
tactic rebootServer() {
    condition {
        exists lb : D.ZNewsLBT in M.components | lb.time > M.threshold;
    }
    action {
        T.reboot(M);
        set M.time = 0;
    }
    effect {
        true;
    }
}
