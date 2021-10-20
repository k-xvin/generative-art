package sketches

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.extra.noise.perlin
import org.openrndr.extra.noise.perlinLinear
import org.openrndr.extra.noise.random
import org.openrndr.extra.noise.simplex
import org.openrndr.extra.videoprofiles.ProresProfile
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.ffmpeg.VideoWriter
import org.openrndr.math.Polar
import org.openrndr.math.Vector2
import org.openrndr.shape.Circle
import org.openrndr.shape.contour
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun main() = application {
    configure {
        width = 800
        height = 800
    }

    program {

        val bone = ColorRGBa.fromHex("e3dac9")
        val red = ColorRGBa.fromHex("C33149")

        extend(ScreenRecorder()){
            profile = ProresProfile().apply {
                profile = ProresProfile.Profile.HQ4444
                codec = "prores_ks"
            }
        }
        extend {
            drawer.clear(red)
            drawer.fill = null
            drawer.stroke = bone
            drawer.strokeWeight = 2.0
            drawer.lineCap = LineCap.ROUND

            val amp = 150
            val step = 0.003
            val points = List(width) {
                val x = it.toDouble()
                val offset = simplex(0, (step * it) + seconds/1.2) * amp
                Vector2(x, (2*height / 3.0) + offset)
            }
            drawer.lineStrip(points)

            val circles = points.mapIndexedNotNull { i, v ->
                if(i%30 == 0){
                    Circle(
                        v,
                        sin(i.toDouble())* 15.0
                    )
                }
                else {
                    null
                }
            }
            drawer.circles(circles)

            val circPoints = List(361) {
                val degree = it.toDouble()
                val offset = simplex(0, (step * it) + seconds/0.5) * amp
                val baseRadius = 200.0;

                Vector2.fromPolar(Polar(degree, baseRadius))
            }

            drawer.pushStyle()
                drawer.translate(width / 2.0, (height / 2.0) + sin(seconds)*20.0)
                drawer.lineStrip(circPoints)
            drawer.popStyle()

        }
    }
}

