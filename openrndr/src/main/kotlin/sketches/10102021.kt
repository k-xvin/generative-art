package sketches;

import helpers.SineWave
import helpers.sineWave
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.Drawer
import org.openrndr.draw.LineCap
import org.openrndr.math.Vector2
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.sin

fun main() = application {
    configure {
        width = 800
        height = 800
    }

    program {
        // https://coolors.co/8c1c13-bf4342-e7d7c1-a78a7f-735751
        val hex = arrayOf("8c1c13", "bf4342", "e7d7c1", "a78a7f", "735751");
        val palette = hex.map { ColorRGBa.fromHex(it) }

        extend {
            drawer.translate(width / 2.0, height / 2.0)
            drawer.clear(ColorRGBa.WHITE)

            drawer.strokeWeight = 5.0
            drawer.stroke = palette[3]
            drawer.lineCap = LineCap.ROUND
            for(i in 0..99){
                drawer.stroke = palette[i%5]
                drawer.sineWave(
                    Vector2(0.0, 0.0),
                    Vector2(400.0, 0.0).rotate(i.toDouble()*5),
                    500,
                    SineWave(0.04, 0.0, 20.0)
                );
            }


        }
    }
}

fun Drawer.branch(start: Vector2, minAngleDegrees: Double, maxAngleDegrees: Double, numBranches: Int){

}





