
abstract class Group[T](val S: List[T], val op: (T, T)=>T, val e:T, val inv:T=>T) {
    require(S.forall(x => S.forall(y=> S.forall(z=> associativeLaw(op)(x,y,z)))))
    require(S.forall(x => (op(x, e) == op(e, x))&&(op(e,x) == x)))
    require(S.forall(x => (op(x, inv(x)) == op(inv(x), x))&&(op(inv(x), x) == e)))
}

def add(a:Int, b:Int): Int = a + b
def inv(a:Int):Int = -a

class Z extends Group[Int](List.range(-100, 100), add, 0, inv)

abstract class Ring[T](val: plus:(T,T)=>T, val dot:(T,T)=>T, val e:T, val inv:T=>T) extends Group[T](dot, e, inv)

abstract class Field[T](val: plus:(T,T)=>T, val dot:(T,T)=>T, val e:T, val zero:T, val invPlus:T=>T, val invDot: T=>T) extends Ring[T](plus, dot, e, invPlus)

