package sketches

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.Drawer
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import org.openrndr.math.Vector2
import kotlin.math.cos
import kotlin.math.sin

fun main() = application {
    configure {
        width = 800
        height = 800
    }

    program {
        drawer.clear(ColorRGBa.WHITE)
        extend {
            drawer.strokeWeight = 1.0
            drawer.stroke = ColorRGBa.BLACK
            drawer.branch(100.0)
            drawer.lineSegment(
                0.0,
                0.0,
                0.0,
                100.0
            )
        }
    }
}

fun Drawer.branch(length: Double) {
    this.lineSegment(
        0.0,
        0.0,
        0.0,
        length
    )
    this.pushTransforms()
    this.popTransforms()
}