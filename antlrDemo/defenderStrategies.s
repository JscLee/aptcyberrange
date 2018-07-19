module defender.strategies;
import lib "defenderTactics.s"
define boolean isPhishing = testVariable;

strategy FilterStrategy [true] {
   t0: (isPhishing) -> filterEmail () @[500 /*ms*/]{
       t1: (!isPhishing) -> done;
   }
}