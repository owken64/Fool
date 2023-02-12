
package set

import scala.math

abstract class Set[T <: Type0] extends Type1{
    def in (obj:Any):Boolean
    def all : Option[Seq[T]] = None
    def almost: Seq[T] = Range(0, nMany) map (_ => generate())
    protected def generate(): T
    override def equals(that: Any): Boolean
    val order: Num
}

class TypeSet[T <: Type0] extends Set[T] {
    def in (obj:Any): Boolean = obj.isInstanceOf[T]
    override def equals(that: Any): Boolean = that match {
        case _ : TypeSet[T] => true
        case _ => false
    }
    val order:Num = ???
}

class LogicalSet[T <: Type0](val predicates: Seq[Predicate]) extends Set[T] {
    def in(obj:Any):Boolean = obj.isInstanceOf[T] && predicates.forall(p => p(obj))
    override def equals(that: Any): Boolean = that match {
        case ls : LogicalSet[T] => this.predicates == ls.predicates
        case _ => false
    }
    val order:Num = ???
}

trait FiniteSet[T <: Type0] extends Set[T] {
    var order:Num = Natural(all.length)
}

trait InfiniteSet[T <: Type0] extends Set[T] {
    val order: Num = Infinity
}

object Set {
    def apply[T <: Type0]( ): Set[T] = new TypeSet[T]
    def apply[T <: Type0]( logic: Predicate): Set[T] = new LogicalSet[T](List(logic))
}

object C extends TypeSet[Complex] with InfiniteSet[Complex] {
    def generate() = Complex(math.random() * 10 , math.random() * 10)
}

object R extends TypeSet[Real] with InfiniteSet[Real]{
    def generate() = Real(math.random() * 10)
}

object Q extends TypeSet[Rational] with InfiniteSet[Rational] {
    def generate() = Rational(math.float(math.random()*10).toInt, math.float(math.random()*10).toInt)
}

object Z extends TypeSet[Integer] with InfiniteSet[Integer] {
    def generate() = Integer(math.float(math.random()*10).toInt)
}

object N extends TypeSet[Natural] with InfiniteSet[Natural] {
    def generate() = Natural(math.float(math.random()*10).toInt)
}

object P extends TypeSet[Prime] with InfiniteSet[Prime] {
    def generate() = Prime(2)
}
