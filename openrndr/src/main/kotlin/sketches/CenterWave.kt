package sketches

import org.openrndr.*
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.noise.simplex
import org.openrndr.extra.videoprofiles.ProresProfile
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2

fun main() = application {
    configure {
//        width = 800
//        height = 800
        width = 1920
        height = 1080
        fullscreen = Fullscreen.SET_DISPLAY_MODE
    }
    program {
//        oliveProgram {

        extend(ScreenRecorder()){
            profile = ProresProfile().apply {
                profile = ProresProfile.Profile.HQ4444
                codec = "prores_ks"
            }
        }

        val spacecadet = ColorRGBa.fromHex("2E2D4D")
        val grullo = ColorRGBa.fromHex("A99F96")
        val bloodred = ColorRGBa.fromHex("6E0E0A")


        //var radius = 80.0
        var radius = 10.0;
//        val amp = radius
//        var step = 0.003
        var step = -0.004

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
                val points = List(width / 2) {
                    val x = it.toDouble()
                    val offset = simplex(i, (step * it) + seconds / 1.2) * radius
                    Vector2(x, offset)
                }
                drawer.rotate(i.toDouble())
                drawer.lineStrip(points)
                drawer.popTransforms()
            }
            drawer.popTransforms()

            drawer.fill = bloodred
            drawer.circle(Vector2(width / 2.0, height / 2.0), 10.0)


        }
    }
}


