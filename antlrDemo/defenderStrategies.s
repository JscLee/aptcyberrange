module dos.strategies;

import lib "defenderTactics.s";
define boolean webPasswdExpired = (currentTime > M.WEB_THRESHOLD);

// If has suspicious email, filter it. Actually implemented by using a random number.
strategy FilterEmailStrategy
[true] {
    t0: (true) -> filterEmail() @[5000] {
        t1: (success) -> done;
        t1a: (default) -> TNULL;
    }
    t2: (default) -> TNULL;
}

// If web server's password is expired (has not change in a long time), modify it.
strategy ChangeWebPasswordStrategy
[webPasswdExpired] {
    t0: (webPasswdExpired) -> changeWebPassword() @[5000] {
        t1: (success) -> done;
        t1a: (default) -> TNULL;
    }
    t2: (default) -> TNULL;
}

// If payment server's password is expired (has not change in a long time), modify it.
// strategy ChangePaymentPasswordStrategy
// [paymentPasswdExpired] {
//    t0: (paymentPasswdExpired) -> changePaymentPassword() @[5000] {
//        t1: (!paymentPasswdExpired) -> done;
//        t1a: (default) -> TNULL;
//    }
//    t2: (default) -> TNULL;
//}


