module dos.strategies;

import lib "attackerTactics.s";

// If no web credential and log file exist, send a phishing email.
// format is a little bit similar to EliminateStrategy in dosStrategies.s
strategy PhishingEmailStrategy
[!hasWebCredential && !hasLogFile] {
    t0: (!hasLogFile) -> phishingEmail() @[5000] {
        t1: (success) -> done;
        t1a: (default) -> phishingEmail() @[10000] {
            t2a: (default) -> TNULL;
            t2b: (success) -> done;
        }
    }
    t3: (default) -> TNULL;
}

// If attacker does not have web credential but has log file, crack the log
// file to get password.
strategy WebCredentialStrategy
[!hasWebCredential && hasLogFile] {
    t0: (!hasWebCredential) -> crackWebCredential() @[5000] {
        t1: (default) -> TNULL;
        t1a: (success) -> done;
    }
    t2: (default) -> TNULL;
}

// If already has web credential but does not have credit card's credentials,
// implement shell injection to web server and query credentials from LDAP using
// the shell on web server.
strategy ShellInjectionStrategy
[hasWebCredential && !hasCardCredential] {
    t0: (!hasCardCredential) -> shellInjection() @[5000] {
        t1: (success) -> done;
        t1a: (default) -> deleteFiles() @[5000] {
            t2a: (success) -> done;
            t2b: (default) -> TNULL;
        }
    }
    t3: (default) -> TNULL;
}

// If already has credit card's credentials but does not have the decrypted password,
// crack the password from LDAP.
strategy CrackPasswordStrategy
[hasCardCredential] {
    t0: (!validCardPassword) -> crackCardPassword() @[5000] {
        t1: (validCardPassword) -> done;
        t1a: (default) -> TNULL;
    }
    t2: (default) -> TNULL;
}


