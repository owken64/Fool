abstract class Set[T]{
    def in (obj:Any):Boolean
    def all : Seq[T]
    def many: Seq[T]
    val order: Num
}

abstract class FiniteSet[T]{

}

abstract class InfiniteSet[T]{
    val order: Num = Infinity
}
