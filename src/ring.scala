abstract class Ring[T](val: plus:(T,T)=>T, val dot:(T,T)=>T, val e:T, val inv:T=>T) extends Group[T](dot, e, inv)

