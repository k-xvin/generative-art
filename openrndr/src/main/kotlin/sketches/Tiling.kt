package sketches

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.Drawer
import org.openrndr.extra.olive.oliveProgram
import org.openrndr.math.Vector2

fun main() = application {
    configure {
        width = 800
        height = 800
    }
    //program {
    oliveProgram {

        val spacecadet = ColorRGBa.fromHex("2E2D4D")
        val grullo = ColorRGBa.fromHex("A99F96")
        val bloodred = ColorRGBa.fromHex("6E0E0A")

        val scale = 80;
        val radius = 20.0;

        extend {
            drawer.clear(grullo)
            drawer.stroke = bloodred
            drawer.strokeWeight = 5.0;
            drawer.fill = grullo

            for ((col, x) in (0..width step scale).withIndex()) {
                for (y in 0..height step scale) {
                    val staggerY = if (col % 2 == 0) y + scale / 2 else y
                    drawer.lineSegment(
                        Vector2(x.toDouble(), staggerY + radius),
                        Vector2(x.toDouble(), staggerY - radius)
                    )
                    drawer.lineSegment(
                        Vector2(x - radius, staggerY.toDouble()),
                        Vector2(x + radius, staggerY.toDouble())
                    )
                }
            }
        }
    }


}

fun Drawer.tileShape(x: Double, y: Double, radius: Double) {
    this.circle(x, y, radius)
    this.circle(x, y + 5.0, radius)
}


