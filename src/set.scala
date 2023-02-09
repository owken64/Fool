
abstract class Set[T] extends Type1{
    def in (obj:Any):Boolean
    def all : Seq[T]
    def many: Seq[T]
    val order: Num
}

trait FiniteSet{

}

trait InfiniteSet {
    def all:Seq[T] = throw new InfiniteException
    val order: Num = Infinity
}

object Set {
    def apply[T <: Type0]( logic: T=> Boolean): Set[T] 
}

object C extends InfiniteSet[Complex]
object R extends InfiniteSet[Real]
object Q extends InfiniteSet[Rational]
object Z extends InfiniteSet[Integer]
object N extends InfiniteSet[Natural]
object P extends InfiniteSet[Prime]