module attacker.strategies;
import lib "attackerTactics.s";
// define boolean hasCredential = testVariable; // we do not need this because model will have it constantly updated

strategy PhishingStrategy [true] {
   t0: (!hasCredential) -> phishingEmail () @[500 /*ms*/] {
       t1: (hasCredential) -> done;
   }
}