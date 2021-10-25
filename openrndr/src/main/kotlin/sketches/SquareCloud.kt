package sketches

import org.openrndr.Fullscreen
import org.openrndr.Program
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.extra.noise.simplex
import org.openrndr.extra.olive.Olive
import org.openrndr.extra.videoprofiles.GIFProfile
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2
import org.openrndr.shape.Rectangle
import org.openrndr.shape.ShapeContour
import org.openrndr.shape.contour
import kotlin.math.cos
import kotlin.math.sin

// sketch3 10/23/2021
fun main() = application {
    configure {
        width = 800
        height = 600
    }

    program {
//        extend(Olive<Program>())
        extend(ScreenRecorder()) {
            profile = GIFProfile()
        }
        val oldlavender = ColorRGBa.fromHex("7C6C77")
        val grullo = ColorRGBa.fromHex("AAA694")
        val palespringbud = ColorRGBa.fromHex("D1D0A3")
        val eggshell = ColorRGBa.fromHex("F2E9D8")
        val yellowcrayola = ColorRGBa.fromHex("FFE787")

        // make a list of rectangles
        val scale = 20.0
        val rectangles = mutableListOf<Rectangle>()
        for (x in 0..width) {
            for (y in 0..height) {
                if (x % scale.toInt() == 0 && y % scale.toInt() == 0) {
                    val rectangle = Rectangle(x.toDouble(), y.toDouble(), scale, scale)
                    rectangles.add(rectangle)
                }
            }
        }



        extend {
            drawer.clear(oldlavender)

            drawer.fill = grullo
//            drawer.stroke = eggshell
            drawer.stroke = null


            val step = seconds * 0.3;
            for((index, rectangle) in rectangles.withIndex()) {
                val scaleFactor = simplex(0, rectangle.x + step, rectangle.y + step) * 4.0
                drawer.rectangle(rectangle.scale(scaleFactor))
                drawer.fill = grullo.shade(1.0 + index/rectangles.size.toDouble() + scaleFactor/5.0)
            }

        }
    }
}
