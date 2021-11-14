package sketches

import org.openrndr.*
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.noise.simplex
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


        //var radius = 80.0
        var radius = 10.0;
//        val amp = radius
//        var step = 0.003
        var step = -0.001

        keyboard.keyDown.listen {
            // -- it refers to a KeyEvent instance here
            // -- compare the key value to a predefined key constant
            if (it.key == KEY_ARROW_UP) {
                step += 0.001;
                println(step)
            }
            if (it.key == KEY_ARROW_DOWN) {
                step -= 0.001;
                println(step)
            }
            if (it.key == KEY_ARROW_RIGHT) {
                radius += 5.0
                println(radius)
            }
            if (it.key == KEY_ARROW_LEFT) {
                radius -= 5.0
                println(radius)
            }
        }

        keyboard.keyRepeat.listen {
            // -- it refers to a KeyEvent instance here
            // -- compare the key value to a predefined key constant
            if (it.key == KEY_ARROW_UP) {
                step += 0.001;
                println(step)
            }
            if (it.key == KEY_ARROW_DOWN) {
                step -= 0.001;
                println(step)
            }
            if (it.key == KEY_ARROW_RIGHT) {
                radius += 5.0
                println(radius)
            }
            if (it.key == KEY_ARROW_LEFT) {
                radius -= 5.0
                println(radius)
            }
        }

        extend {
            drawer.clear(grullo)
            drawer.stroke = bloodred
            drawer.fill = grullo



            drawer.strokeWeight = 1.0;
            drawer.pushTransforms()
            drawer.translate(width / 2.0, height / 2.0)
            for (i in 0..360) {
                drawer.pushTransforms()
                val points = List(width /*/ 2*/) {
                    val x = it.toDouble()
                    val offset = simplex(i, (step * it) + seconds / 1.2) * radius
                    Vector2(x, /*height / 2 +*/ offset)
                }
                drawer.rotate(i.toDouble())
                drawer.lineStrip(points)
                drawer.popTransforms()
            }
            drawer.popTransforms()


//            drawer.strokeWeight = 5.0;
////            drawer.circle(Vector2(width / 2.0, height / 2.0), radius)
//
//            drawer.strokeWeight = 2.0;
//            drawer.circle(Vector2(width / 2.0, height / 2.0), radius / 2)
//
            drawer.fill = bloodred
            drawer.circle(Vector2(width / 2.0, height / 2.0), 10.0)


        }
    }


}