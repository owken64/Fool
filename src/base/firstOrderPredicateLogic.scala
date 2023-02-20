package logic.firstOrderPredicateLogic

package syntax {

    abstract class Term
    abstract class LogicalFormula {
        val semantic: Boolean
    }

    class Name extends Term

    class Variable extends Term

    class AppliedOperator(val n: Int)(val t: Seq[Term]) extends Term 

    class Operator(val n :Int) {
        require(n >= 0)
        def apply(t: Seq[Term] ) : AppliedOperator = {
            require(t.length == n)
            new AppliedOperator(n)(t)
        }
    }

    class AtomicPredicate(n: Int)(p: Seq[Term] => Boolean)(t: Seq[Term]) extends LogicalFormula {
        require( n >= 0)
        require( t.length == n)
        val semantic: Boolean = p(t)
    }

    class Predicate(val n:Int)(val p: Seq[Term] => Boolean) {
        require( n >= 0)
        def apply(t:Seq[Term]): AtomicPredicate = {
            require(t.length == n)
            new AtomicPredicate(n)(p)(t)
        }
    }

    class AppliedTruthFunction(n:Int)(f: Seq[LogicalFormula]=>Boolean)(lf: Seq[LogicalFormula]) extends LogicalFormula{
        require( n >= 0)
        require( lf.length == n)
        val semantic: Boolean = f(lf)
    }
    abstract class TruthFunction(val n: Int)(val f: Seq[LogicalFormula] => Boolean) {
        require( n >= 0)
        def apply(lf: Seq[LogicalFormula]): AppliedTruthFunction = {
            require( lf.length == n)
            new AppliedTruthFunction(n)(f)(lf)
        }
    } 

    abstract class ZeroPlaceTruthFunction(f: Seq[LogicalFormula] => Boolean) extends TruthFunction(1)(f)
    object True extends ZeroPlaceTruthFunction( _=>true ) 
    object False extends ZeroPlaceTruthFunction(_=>false)

    abstract class OnePlaceTruthFunction(f: Seq[LogicalFormula] => Boolean) extends TruthFunction(1)(f)
    object Not extends OnePlaceTruthFunction( x => !x.head.semantic)

    abstract class TwoPlaceTruthFunction(f: Seq[LogicalFormula] => Boolean) extends TruthFunction(2)(f)
    object And extends TwoPlaceTruthFunction( x => x match  { case a :: b :: tail => a.semantic & b.semantic})
    object Or extends TwoPlaceTruthFunction( x => x match  { case a :: b :: tail => a.semantic | b.semantic})
    object IfThen extends TwoPlaceTruthFunction( x => x match  { case a :: b :: tail => !(a.semantic & !b.semantic)})
    object Iff extends TwoPlaceTruthFunction( x => x match  { case a :: b :: tail => a.semantic == b.semantic})

    class AppliedQuantification(v:Variable)(lf: LogicalFormula) extends LogicalFormula {
        val semantic: Boolean = throw new NotImplementedException
    }
    abstract class Quantification {
        def apply(v: Variable, lf: LogicalFormula) : AppliedQuantification = {
            new AppliedQuantification(v)(lf)
        }
    }
    object All extends Quantification
    object Exists extends Quantification
}

package semantics{

    
}