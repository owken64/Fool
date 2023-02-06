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
