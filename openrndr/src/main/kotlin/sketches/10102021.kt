package sketches;

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.Drawer
import org.openrndr.draw.LineCap
import org.openrndr.math.Vector2
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.sin

fun main() = application {
    configure {
        width = 800
        height = 800
    }

    program {
        // https://coolors.co/8c1c13-bf4342-e7d7c1-a78a7f-735751
        val hex = arrayOf("8c1c13", "bf4342", "e7d7c1", "a78a7f", "735751");
        val palette = hex.map { ColorRGBa.fromHex(it) }

        extend {
            drawer.translate(width / 2.0, height / 2.0)
            drawer.clear(ColorRGBa.WHITE)

            drawer.strokeWeight = 5.0
            drawer.stroke = palette[3]
            drawer.lineCap = LineCap.ROUND
            drawer.sineWave(
                Vector2(0.0, 100.0),
                Vector2(300.0, -300.0),
                500,
                SineWave(0.04, 0.0, 20.0)
            );


        }
    }
}

fun Drawer.sineWave(start: Vector2, end: Vector2, numPoints: Int, sineWave: SineWave) {
    this.lineSegment(start, end);

    val distance = start.distanceTo(end)
    val step = distance / numPoints

    // need angle of vector start to end
    // to get vector start to end:
    // figure out
    val angleInDegrees = (atan2(end.y, end.x) * 180) / PI

    val points = List(numPoints) { t ->
        val movedStartX = start.x + (step * t)
        val movedStartY = start.y +( sineWave.amp * sin(sineWave.freq * t.toDouble()))
        Vector2(movedStartX, movedStartY).rotate(angleInDegrees, start)
    }
    println(angleInDegrees)
    println(points.last())
    println(end);



    this.lineStrip(points)
}

data class SineWave(val freq: Double, val shift: Double, val amp: Double) {
//    fun value(t: Double, x: Double) = amp * sin(t * freq + shift * x)
}



