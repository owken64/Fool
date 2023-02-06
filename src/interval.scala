abstract class Interval {
    def in(a: Double): Bool
}

class OpenInterval(val min:Double, val max:Double) extends Interval {
    def in(a: Double): Bool = min < a && a < max 
}

class ClosedInterval(val min:Double, val max:Double) extends Interval {
    def in(a: Double): Bool = min <= a && a <= max
}

