module dos.strategies; 
define boolean hasCredential = testVariable; // testVariable is stored in the Model

strategy Attack [true] {
   t0: (!hasCredential) -> A.phishingEmail () {
       t1: (hasCredential) -> done;
   }
}