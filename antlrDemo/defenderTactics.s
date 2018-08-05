module dos.strategies;
import model "TargetModel";

tactic filterEmail() {
    condition {
        exists lb : mail in C.newMail | isPhishingEmail;
    }
    action {
        filterPhishingEmail(dummyParam);
    }
    effect {
        forall lb : mail in C.newMail | !isPhishingEmail;
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
         W.time > W.threshold;
    }
    action {
        W.resetPassword(l);
        increaseWebThreshold(l); // update web server's threshold by adding 20 seconds
    }
    effect {
        W.time < W.threshold;
    }
}


//tactic changePaymentPassword() {
//    condition {
//        // P.time > P.threshold;
//        exists lb : P.server in P.components | lb.time > P.threshold;
//        // within timewindow or true
//    }
//    action {
//        set lbs = {select l : P.server in W.components | l.time > P.threshold};
//        for (P.server l : lbs) {
//            P.resetPassword("passwd_of_payment_apt_18_summer");
//        }
//        increaseThreshold(P.threshold); // update payment server's threshold by adding 40 seconds
//    }
//    effect {
//        true;
//    }
//}


