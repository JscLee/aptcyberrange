module dos.strategies;

import lib "attackerTactics.s";

// If no web credential and log file exist, send a phishing email.
// format is a little bit similar to EliminateStrategy in dosStrategies.s
strategy PhishingEmailStrategy
[!hasWebCredential && !hasLogFile] {
    t0: (!hasLogFile) -> phishingEmail() @[5000] {
        t1: (hasLogFile) -> done;
        t1a: (!hasLogFile) -> phishingEmail() @[10000] {
            t2a: (!hasLogFile) -> TNULL;
            t2b: (hasLogFile) -> done;
        }
    }
    t3: (hasLogFile) -> TNULL;
}
