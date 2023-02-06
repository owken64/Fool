def associativeLaw[T](op: (T,T)=>T)(a:T, b:T, c:T): Boolean = {
    op(op(a, b), c) == op(a, op(b, c))
}

def commutativeLaw[T](op: (T,T)=>T)(a:T, b:T): Boolean = {
    op(a, b) == op(b, a)
}

