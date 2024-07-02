package id.my.suluh.masrum.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.tensorflow.lite.Interpreter

class PlayViewModel : ViewModel() {

    private val _result = MutableLiveData<Float>()
    val result: LiveData<Float> = _result

    private val capShapeValues = mapOf(
        "Convex" to 5,
        "Bell" to 0,
        "Sunken" to 4,
        "Flat" to 2,
        "Knobbed" to 3,
        "Conical" to 1
    )

    private val capSurfaceValues =
        mapOf("Smooth" to 2, "Scaly" to 3, "Fibrous" to 0, "Grooves" to 1)

    private val capColorValues = mapOf(
        "Brown" to 4,
        "Yellow" to 9,
        "White" to 8,
        "Gray" to 3,
        "Red" to 2,
        "Pink" to 5,
        "Buff" to 0,
        "Purple" to 7,
        "Cinnamon" to 1,
        "Green" to 6
    )

    private val bruisesValues = mapOf("Yes" to 1, "No" to 0)

    private val gillSizeValues = mapOf("Narrow" to 1, "Broad" to 0)

    private val gillColorValues = mapOf(
        "Black" to 4,
        "Brown" to 5,
        "Gray" to 2,
        "Pink" to 7,
        "White" to 10,
        "Chocolate" to 3,
        "Purple" to 9,
        "Red" to 1,
        "Buff" to 0,
        "Green" to 8,
        "Yellow" to 11,
        "Orange" to 6
    )

    private val ringNumberValues = mapOf("One" to 1, "Two" to 2, "None" to 0)

    private val ringTypeValues =
        mapOf("Pendant" to 4, "Evanescent" to 0, "Large" to 2, "Flaring" to 1, "None" to 3)

    private val sporePrintColorValues = mapOf(
        "Black" to 2,
        "Brown" to 3,
        "Purple" to 6,
        "Chocolate" to 1,
        "White" to 7,
        "Green" to 5,
        "Orange" to 4,
        "Yellow" to 8,
        "Buff" to 0
    )

    private val populationValues = mapOf(
        "Scattered" to 3,
        "Numerous" to 2,
        "Abundant" to 0,
        "Several" to 4,
        "Solitary" to 5,
        "Clustered" to 1
    )

    private val habitatValues = mapOf(
        "Urban" to 5,
        "Grasses" to 1,
        "Meadows" to 3,
        "Wood" to 0,
        "Paths" to 4,
        "Waste" to 6,
        "Leaves" to 2
    )

    private fun doInference(array: IntArray, interpreter: Interpreter) {
        val input = FloatArray(11)

        if (array.size == 11) {
            for (i in 0..10) {
                input[i] = array[i].toFloat()
            }

            val output = Array(1) { FloatArray(1) }

            interpreter.run(input, output)
            _result.value = output[0][0]
        }
    }

    fun convert(array: Array<String>, interpreter: Interpreter) {
        val parsed = IntArray(11)

        parsed[0] = capShapeValues[array[0]] ?: 0
        parsed[1] = capSurfaceValues[array[1]] ?: 0
        parsed[2] = capColorValues[array[2]] ?: 0
        parsed[3] = bruisesValues[array[3]] ?: 0
        parsed[4] = gillSizeValues[array[4]] ?: 0
        parsed[5] = gillColorValues[array[5]] ?: 0
        parsed[6] = ringNumberValues[array[6]] ?: 0
        parsed[7] = ringTypeValues[array[7]] ?: 0
        parsed[8] = sporePrintColorValues[array[8]] ?: 0
        parsed[9] = populationValues[array[9]] ?: 0
        parsed[10] = habitatValues[array[10]] ?: 0

        doInference(parsed, interpreter)
    }

}
