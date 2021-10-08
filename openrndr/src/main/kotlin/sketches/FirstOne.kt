package sketches;

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.shape.Circle

fun main() = application {
    configure {
        width = 800
        height = 800
    }

    program {

        val circles = List(100) {
            Circle(
                Math.random() * width / 2.0 + width / 4.0,
                Math.random() * height / 2.0 + height / 4.0,
                Math.random() * 30.0 + 10.0
            )
        }

        extend {
            drawer.clear(ColorRGBa.PINK)
            drawer.fill = ColorRGBa.WHITE
            drawer.stroke = null;

            drawer.circles(circles);

        }
    }
}
