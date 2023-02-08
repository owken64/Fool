abstract class Set[T]{
    def in (obj:Any):Boolean
    def all : Seq[T]
    def many: Seq[T]
    val order: Num
}

abstract class FiniteSet[T] extends Set[T]{

}

abstract class InfiniteSet[T] extends Set[T]{
    def all:Seq[T] = throw new InfiniteException
    val order: Num = Infinity
}

object C extends InfiniteSet[Complex]
object R extends InfiniteSet[Real]
object Q extends InfiniteSet[Rational]
object Z extends InfiniteSet[Integer]
object N extends InfiniteSet[Natural]
object P extends InfiniteSet[Prime]