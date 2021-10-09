package sketches;

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.Screenshots
import org.openrndr.math.Vector2
import org.openrndr.shape.Circle

fun main() = application {
    configure {
        width = 800
        height = 800
    }

    program {
//      val circleColor = ColorRGBa.WHITE;
        val circleColor = ColorRGBa.PINK;

        val circles = List(5000) {
            val x = Math.random() * width
            val y = Math.random() * height
            Circle(
                x,
                y,
                getScaledRadius(Vector2(width / 2.0, height / 2.0), Vector2(x, y))
            )
        }

        extend(Screenshots())
        extend {
//          drawer.clear(ColorRGBa.PINK)
            drawer.clear(ColorRGBa.WHITE)

            drawer.stroke = null;

            drawer.circles(circles);

            for ((index, circle) in circles.withIndex()) {
                drawer.fill = circleColor.shade(index.toDouble() / circles.size)
                drawer.circle(circle)
            }

//            drawer.fill = null
//            drawer.circle(400.0,400.0, 50.0)

        }
    }
}

fun getScaledRadius(center: Vector2, pos: Vector2): Double {
    val distance = center.distanceTo(pos)

    val maxDistance = 250.0;
    val maxRadius = 50.0;
    return maxRadius - maxRadius * (distance / maxDistance);


}


