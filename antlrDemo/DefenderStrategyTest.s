module dos.strategies;

import lib "defenderTactics.s";
define boolean webPasswdExpired = (currentTime > WEB_THRESHOLD);

// If has suspicious email, filter it. Actually implemented by using a random number.
strategy FilterEmailStrategy
[true] {
    t0: (true) -> filterEmail() @[5000] {
        t1: (true) -> done;
        t1a: (false) -> TNULL;
    }
    t2: (false) -> TNULL;
}
