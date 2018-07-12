module dos.strategies; 
define boolean isPhishing = testVariable; // testVariable is stored in the Model

strategy Defense [true] {
   t0: (isPhishing) -> D.filterEmail () {
       t1: (!isPhishing) -> done;
   }
}