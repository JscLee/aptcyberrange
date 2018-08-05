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

// If attacker does not have web credential but has log file, crack the log
// file to get password.
strategy WebCredentialStrategy
[!hasWebCredential && hasLogFile] {
    t0: (!hasWebCredential) -> crackWebCredential() @[5000] {
        t1: (!hasWebCredential) -> TNULL;
        t1a: (hasWebCredential) -> done;
    }
    t2: (hasWebCredential) -> TNULL;
}

// If already has web credential but does not have credit card's credentials,
// implement shell injection to web server and query credentials from LDAP using
// the shell on web server.
strategy ShellInjectionStrategy
[hasWebCredential && !hasCardCredential] {
    t0: (!hasCardCredential) -> shellInjection() @[5000] {
        t1: (hasCardCredential) -> done;
        t1a: (!hasCardCredential) -> deleteFiles() @[5000] {
            t2a: (hasCardCredential) -> done;
            t2b: (!hasCardCredential) -> TNULL;
        }
    }
}

// If already has credit card's credentials but does not have the decrypted password,
// crack the password from LDAP.
strategy CrackPasswordStrategy
[hasCardCredential] {
    t0: (hasCardCredential) -> crackCardPassword() @[5000] {
        t1: (hasCardPassword) -> done;
        t1a: (!hasCardPassword) -> TNULL;
    }
}


