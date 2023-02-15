package logic

import truthValue
import something
import exception

abstract class LogicalFormula {
    def name: Option[String] = None
    val formula: String
    def eval: TruthValue = Unsolved

    override def toString(): String = formula
}

class AssignedPredicate(n: String, val p: Something => TruthValue, val s: Something) extends LogicalFormula {
    override def name: Option[String] = Some(n)
    val formula: String = name.get + "(" + s.toString + ")"
    override def eval: TruthValue = p(s)
}

class Predicate(n: String, val p: Something => TruthValue) extends LogicalFormula {
    override def name: Option[String] = Some(n)
    val formula: String = name.get + "(x)"
    override def eval: TruthValue = throw new NotAssignedException
    def apply(s: Something) : AssignedPredicate  = new AssignedPredicate(n, p, s)
} 

class AnonymousPredicate(val p: Something=>TruthValue) extends LogicalFormula {
    val formula: String = "Anon(x)"
    override def eval: TruthValue = throw new NotAssignedException
    def apply(s: Something) : AssignedPredicate = new AssignedPredicate("Anon", p, s)
}

object Predicate {
    def apply(): AnonymousPredicate = new AnonymousPredicate(x => Unsolved)
}
