package sketches

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.extra.noise.random
import org.openrndr.math.Vector2
import kotlin.math.cos
import kotlin.math.sin

// sketch4 10/24/2021
fun main() = application {
    configure {
        width = 1280
        height = 720
    }

    program {

        val points = List(7) {
            val x = random(0.0, width.toDouble())
            val y = random(0.0, height.toDouble())
            Vector2(x, y)
        }
        val sortedByX = points.sortedBy { it.x }
        val sortedByY = points.sortedBy { it.y }


        extend {
            drawer.clear(ColorRGBa.WHITE)
            drawer.fill = ColorRGBa.BLACK

            // need to check closest DISTANCE
            for (i in 0..sortedByX.size-2) {
                drawer.lineSegment(sortedByX[i],sortedByX[i+1])
//                drawer.lineSegment(sortedByY[i],sortedByY[i+1])

                if(i < sortedByX.size-2){
                    drawer.lineSegment(sortedByX[i],sortedByX[i+2])
//                    drawer.lineSegment(sortedByY[i],sortedByY[i+2])
                }
            }



            for (point in points) {
                drawer.circle(point, 10.0)
            }
        }
    }
}

// Get a list of the points to point, sorted by distance
fun getClosestPoints(point: Vector2, points: List<Vector2>) : List<Vector2> {

}
