module dos.strategies;
define boolean isPhishing = testVariable; // testVariable is stored in the Model
strategy Defense [true] {
   t0: (isPhishing) -> filterEmail () { // change to done?
       done
   }
}