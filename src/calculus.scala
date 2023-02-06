
var delta: Double = 0.001

def isDifferentiable(f: Double=> Double)(x: Double): Boolean = {
    ((f(x + delta) - f(x))/ delta) -  ((f(x-delta) - f(x) / -delta)) < delta
}

def differential(f: Double => Double)(x: Double): Double = {
    require(isDifferentiable(f)(x))
    (f(x + delta) - f(x))/delta
}

/*
def Integral(f: Double=>Double)(min: Double, max:Double): Double = {
    def _Integral(f:Double=>Double)(max: Double)(current: Double): Double = {
        if (current > max) 0
        else (delta * f(current)) + _Integral(f)(max)(current + delta)
    }

    _Integral(f)(max)(min)
}
*/

def Integral(f: Double=>Double)(min: Double, max:Double): Double = {
    var ans: Double = 0.0
    var cur: Double = min
    while( cur < max ) {
        ans += (delta * f(cur))
        cur += delta
    }
    ans
}
