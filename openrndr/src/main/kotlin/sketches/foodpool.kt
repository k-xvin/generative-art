package sketches

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadImage
import org.openrndr.extensions.Screenshots

fun main() = application {
    configure {
        width = 800
        height = 800
    }

    program {
        val image = loadImage("data/images/green_logo_no_bk.png")

        extend(Screenshots())
        extend {

            for (x in 0 until width) {
                for (y in 0 until height) {
                    if (x % 20 == 0 && y % 20 == 0) {
//                        drawer.drawStyle.colorMatrix =
//                            tint(rgb(random(0.0, 1.0), random(0.0, 1.0), random(0.0, 1.0)))
                        drawer.image(image, x.toDouble(), y.toDouble(), 20.0, 20.0)
                    }
                }
            }
//            drawer.image(image)


            drawer.fill = ColorRGBa.WHITE
        }
    }
}