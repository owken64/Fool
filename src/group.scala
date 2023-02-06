abstract class Group[T](val S: List[T], val op: (T, T)=>T, val e:T, val inv:T=>T) extends Set[T] {
    require(S.forall(x => S.forall(y=> S.forall(z=> associativeLaw(op)(x,y,z)))))
    require(S.forall(x => (op(x, e) == op(e, x))&&(op(e,x) == x)))
    require(S.forall(x => (op(x, inv(x)) == op(inv(x), x))&&(op(inv(x), x) == e)))
}

abstract class FiniteGroup[T]() extends Group[T]

abstract class InfiniteGroup[T]() extends Group[T]

