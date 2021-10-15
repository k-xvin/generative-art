package helpers

import org.openrndr.draw.Drawer
import org.openrndr.math.Vector2
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.sin

fun Drawer.sineWave(start: Vector2, end: Vector2, numPoints: Int, sineWave: SineWave) {
    //this.lineSegment(start, end);
    val distance = start.distanceTo(end)
    val step = distance / numPoints

    // angle of vector start to end
    val angleInDegrees = (atan2(end.y - start.y, end.x - start.x) * 180) / PI

    val points = List(numPoints) { t ->
        val movedStartX = start.x + (step * t)
        val movedStartY = start.y +( sineWave.amp * sin(sineWave.freq * t.toDouble()))
        Vector2(movedStartX, movedStartY).rotate(angleInDegrees, start)
    }

    this.lineStrip(points)
}

data class SineWave(val freq: Double, val shift: Double, val amp: Double) {
//    fun value(t: Double, x: Double) = amp * sin(t * freq + shift * x)
}

fun Drawer.perlinWave(start: Vector2, end: Vector2, numPoints: Int){

}

data class PerlinWave(val amp: Double){

}