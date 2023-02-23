package logic.firstOrderPredicateLogic

import logic.LogicalFormula
import logic.Term

package syntax {

    class Name(val name:String) extends Term {
        override def toString(): String = name
    }

    class Variable(val name: Char) extends Term {
        override def toString(): String = name.toString
    }

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
    }

    class Predicate(val n:Int)(val p: Seq[Term] => Boolean) {
        require( n >= 0)
        def apply(t:Seq[Term]): AtomicPredicate = {
            require(t.length == n)
            new AtomicPredicate(n)(p)(t)
        }
    }

    class AppliedTruthFunction(n:Int)(lf: Seq[LogicalFormula]) extends LogicalFormula{
        require( n >= 0)
        require( lf.length == n)
    }
    abstract class TruthFunction(val n: Int) {
        require( n >= 0)
        def apply(lf: Seq[LogicalFormula]): AppliedTruthFunction = {
            require( lf.length == n)
            new AppliedTruthFunction(n)(lf)
        }
    } 

    abstract class ZeroPlaceTruthFunction extends TruthFunction(1)
    object True extends ZeroPlaceTruthFunction
    object False extends ZeroPlaceTruthFunction

    abstract class OnePlaceTruthFunction extends TruthFunction(1)
    object Not extends OnePlaceTruthFunction

    abstract class TwoPlaceTruthFunction extends TruthFunction(2)
    object And extends TwoPlaceTruthFunction
    object Or extends TwoPlaceTruthFunction
    object IfThen extends TwoPlaceTruthFunction
    object Iff extends TwoPlaceTruthFunction

    class AppliedQuantification(v:Variable)(lf: LogicalFormula) extends LogicalFormula 
    class AppliedAll(v:Variable)(lf: LogicalFormula) extends AppliedQuantification(v)(lf)
    class AppliedExists(v:Variable)(lf: LogicalFormula) extends AppliedQuantification(v)(lf)

    abstract class Quantification {
        def apply(v: Variable, lf: LogicalFormula) : AppliedQuantification = {
            new AppliedQuantification(v)(lf)
        }
    }
    object All extends Quantification
    object Exists extends Quantification

    def fv(t: Term) : Set[Variable]
    def fv(lf:LogicalFormula): Set[Variable]
    def bv(t: Term) : Set[Variable]
    def bv(lf:LogicalFormula): Set[Variable]
    def SubF(lf:LogicalFormula) : Set[Term]
}

package semantics{

    class Entity

    class 領域

    class 対応付け

    class Structure(D: 領域, F: 対応付け)

    class Assignment

}