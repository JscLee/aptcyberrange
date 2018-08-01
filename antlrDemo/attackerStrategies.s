module attacker.strategies;
import lib "attackerTactics.s";
define boolean hasCredential = testVariable;

strategy PhishingStrategy [true] {
   t0: (!hasCredential) -> phishingEmail () @[500 /*ms*/] {
       t1: (hasCredential) -> done;
   }
}