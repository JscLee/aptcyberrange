module dos.strategies;
define boolean isPhishing = testVariable; // testVariable is stored in the Model
// TODO import
strategy Attack [true] { // while loop to check timer might be better
   t0: (isPhishing) -> tacOne() @[5000] { // when @[] finished, execute this // TODO: how long to wait - arbitrary
       (success) -> done // if tacOne() successful execute this (?)
       (fail) -> done
   }
   t1: (isPhishing) -> done; // if tacOne() fails execute this? NO, only one of t0, t1 is executed in 
   							 // the strategy
}
