
package set

abstract class Set[T] extends Type1{
    def in (obj:Any):Boolean
    def all : Seq[T]
    def many: Seq[T]
    override def equals(that: Any): Boolean
    val order: Num
}

class TypeSet[T] extends Set[T] {
    def in (obj:Any): Boolean = obj.isInstanceOf[T]
    def all: Seq[T] = ???
    def many: Seq[T] = ???
    override def equals(that: Any): Boolean = that match {
        case _ : TypeSet[T] => true
        case _ => false
    }
    val order:Num = ???
}

class LogicalSet[T](val predicates: Seq[Predicate]) extends Set[T] {
    def in(obj:Any):Boolean = obj.isInstanceOf[T] && predicates.forall(p => p(obj))
    def all: Seq[T] = ???
    def many: Seq[T] = ???
    override def equals(that: Any): Boolean = that match {
        case ls : LogicalSet[T] => this.predicates == ls.predicates
        case _ => false
    }
    val order:Num = ???
}

trait FiniteSet{

}

trait InfiniteSet {
    def all:Seq[T] = throw new InfiniteException
    val order: Num = Infinity
}

object Set {
    def apply[T <: Type0]( ): Set[T] = new TypeSet[T]
    def apply[T <: Type0]( logic: Predicate): Set[T] = new LogicalSet[T](List(logic))
}

object C extends InfiniteSet[Complex]
object R extends InfiniteSet[Real]
object Q extends InfiniteSet[Rational]
object Z extends InfiniteSet[Integer]
object N extends InfiniteSet[Natural]
object P extends InfiniteSet[Prime]