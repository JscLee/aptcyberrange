module dos.strategies;

import lib "DefenderTactics.s";

// C is system under test (contractor), W is web server, P is payment server
define boolean hasSuspiciousEmail = exists c : C.Server in M.components | (c.suspicious == true);
define boolean webPasswdExpired = exists c : W.Server in M.components | (c.time > M.WEB_THRESHOLD);
define boolean paymentPasswdExpired = exists c : W.Server in P.components | (c.time > P.PAYMENT_THRESHOLD);
//define boolean hasSuspiciousEmail = false;
//define boolean webPasswdExpired = false;
//define boolean paymentPasswdExpired = false;

// If has suspicious email, filter it. Actually implemented by using a random number.
strategy FilterEmailStrategy
[hasSuspiciousEmail] {
    t0: (hasSuspiciousEmail) -> filterEmail() @[5000] {
        t1: (!hasSuspiciousEmail) -> done;
        t1a: (default) -> TNULL;
    }
    t2: (default) -> TNULL;
}

// If web server's password is expired (has not change in a long time), modify it.
strategy ChangeWebPasswordStrategy
[webPasswdExpired] {
    t0: (webPasswdExpired) -> changeWebPassword() @[5000] {
        t1: (!webPasswdExpired) -> done;
        t1a: (default) -> TNULL;
    }
    t2: (default) -> TNULL;
}

// If payment server's password is expired (has not change in a long time), modify it.
strategy ChangePaymentPasswordStrategy
[paymentPasswdExpired] {
    t0: (paymentPasswdExpired) -> changePaymentPassword() @[5000] {
        t1: (!paymentPasswdExpired) -> done;
        t1a: (default) -> TNULL;
    }
    t2: (default) -> TNULL;
}


