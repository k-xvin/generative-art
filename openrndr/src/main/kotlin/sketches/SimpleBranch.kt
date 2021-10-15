package sketches

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.Drawer
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import org.openrndr.math.Vector2
import java.util.*
import kotlin.math.cos
import kotlin.math.sin

fun main() = application {
    configure {
        width = 800
        height = 800
    }

    program {
        extend {
            drawer.clear(ColorRGBa.WHITE)
            drawer.strokeWeight = 10.0
            drawer.stroke = ColorRGBa.BLACK
            drawer.fill = null
            drawer.circle(400.0, 400.0, 40.0)
            drawer.branch(Vector2(400.0, 400.0), 100.0)
        }
    }
}

fun Drawer.branch(start: Vector2, length: Double) {
    if(length < 40.0) return

//    val end = Vector2(0.0, start.y - length)
//    this.pushTransforms()
    this.translate(start)
    this.circle(0.0,0.0, 20.0)
    this.lineSegment(
        Vector2(0.0,0.0),
        Vector2(0.0, -length)
    )
//    this.popTransforms()

//    this.pushTransforms()
//    this.rotate(-10.0)
    this.branch(Vector2(0.0,-length/2.0), length/2.0)
//    this.popTransforms()
}