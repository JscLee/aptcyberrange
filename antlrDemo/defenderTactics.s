module dos.strategies;

import model "TargetModel";

// C is mail server (contractor), D is defender, W is web server, P is payment server
tactic filterEmail() {
    condition {
        exists lb : C.mail in C.newMail | lb.isPhishingEmail;
    }
    action {
        set lbs = {select l : C.mail in C.newMail | l.isPhishingEmail};
        for (C.mail l : lbs) {
            D.block(l);
        }
    }
    effect {
        forall lb : C.mail in C.newMail | !lb.isPhishingEmail;
    }
}

//// D is defender
//tactic rebootServer() {
//    condition {
//        // C.time > C.webThreshold;
//        exists lb : D.ZNewsLBT in C.components | lb.time > C.webThreshold;
//        // within timewindow or true
//    }
//    action {
//        T.reboot(C);
//        set C.time = 0;
//    }
//    effect {
//        true;
//    }
//}

tactic changeWebPassword() {
    condition {
        // W.time > W.threshold;
        exists lb : W.server in W.components | lb.time > W.threshold;
        // within timewindow or true
    }
    action {
        set lbs = {select l : W.server in W.components | l.time > W.threshold};
        for (W.server l : lbs) {
            W.resetPassword("passwd_of_web_apt_18_summer");
        }
    }
    effect {
        true;
    }
}


tactic changePaymentPassword() {
    condition {
        // P.time > P.threshold;
        exists lb : P.server in P.components | lb.time > P.threshold;
        // within timewindow or true
    }
    action {
        set lbs = {select l : P.server in W.components | l.time > P.threshold};
        for (P.server l : lbs) {
            P.resetPassword("passwd_of_payment_apt_18_summer");
        }
    }
    effect {
        true;
    }
}


