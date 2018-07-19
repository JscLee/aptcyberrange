// testTactic.s
module dos.strategies; 
// import M? no
tactic tacOne() {
    condition {
        true;
    }
    action {
        M.tacOneAction(arg); // TODO: type checking, make a new visitor
    }
    effect {
        true;
    }
}
