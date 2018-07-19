module dos.strategies; 
define boolean hasCredential = testVariable; // testVariable is stored in the Model

strategy Attack [true] { // while loop to check timer might be better
   t0: (!hasCredential) -> A.phishingEmail () @[5000 /*ms*/] { // when finished, execute this
       t1: (hasCredential) -> done; // could be changed to "done"
   }
}