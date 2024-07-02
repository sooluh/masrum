package id.my.suluh.masrum.ui.fragment

import android.annotation.SuppressLint
import android.content.res.AssetManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import id.my.suluh.masrum.R
import id.my.suluh.masrum.databinding.FragmentPlayBinding
import id.my.suluh.masrum.viewmodel.PlayViewModel
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

class PlayFragment : Fragment() {

    private lateinit var binding: FragmentPlayBinding

    private lateinit var interpreter: Interpreter
    private val modelPath = "masrum.tflite"

    private var answers = Array(11) { "" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_play, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPlayBinding.bind(view)
        init()

        val capShape = ArrayAdapter(
            requireContext(),
            R.layout.item_question,
            resources.getStringArray(R.array.cap_shape)
        )
        val capSurface = ArrayAdapter(
            requireContext(),
            R.layout.item_question,
            resources.getStringArray(R.array.cap_surface)
        )
        val capColor = ArrayAdapter(
            requireContext(),
            R.layout.item_question,
            resources.getStringArray(R.array.cap_color)
        )
        val bruises = ArrayAdapter(
            requireContext(),
            R.layout.item_question,
            resources.getStringArray(R.array.bruises)
        )
        val gillSize = ArrayAdapter(
            requireContext(),
            R.layout.item_question,
            resources.getStringArray(R.array.gill_size)
        )
        val gillColor = ArrayAdapter(
            requireContext(),
            R.layout.item_question,
            resources.getStringArray(R.array.gill_color)
        )
        val ringNumber = ArrayAdapter(
            requireContext(),
            R.layout.item_question,
            resources.getStringArray(R.array.ring_number)
        )
        val ringType = ArrayAdapter(
            requireContext(),
            R.layout.item_question,
            resources.getStringArray(R.array.ring_type)
        )
        val sporePrintColor = ArrayAdapter(
            requireContext(),
            R.layout.item_question,
            resources.getStringArray(R.array.spore_print_color)
        )
        val population = ArrayAdapter(
            requireContext(),
            R.layout.item_question,
            resources.getStringArray(R.array.population)
        )
        val habitat = ArrayAdapter(
            requireContext(),
            R.layout.item_question,
            resources.getStringArray(R.array.habitat)
        )

        binding.apply {
            inputCapShape.setAdapter(capShape)
            inputCapSurface.setAdapter(capSurface)
            inputCapColor.setAdapter(capColor)
            inputBruises.setAdapter(bruises)
            inputGillSize.setAdapter(gillSize)
            inputGillColor.setAdapter(gillColor)
            inputRingNumber.setAdapter(ringNumber)
            inputRingType.setAdapter(ringType)
            inputSporePrintColor.setAdapter(sporePrintColor)
            inputPopulation.setAdapter(population)
            inputHabitat.setAdapter(habitat)

            autoListener(inputCapShape, 0)
            autoListener(inputCapSurface, 1)
            autoListener(inputCapColor, 2)
            autoListener(inputBruises, 3)
            autoListener(inputGillSize, 4)
            autoListener(inputGillColor, 5)
            autoListener(inputRingNumber, 6)
            autoListener(inputRingType, 7)
            autoListener(inputSporePrintColor, 8)
            autoListener(inputPopulation, 9)
            autoListener(inputHabitat, 10)
        }

        val mainViewModel = ViewModelProvider(this)[PlayViewModel::class.java]

        binding.predict.setOnClickListener {
            print(answers)

            if (answers.contains("")) {
                Toast.makeText(
                    requireContext(),
                    "Silahkan lengkapi data terlebih dahulu",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            mainViewModel.convert(answers, interpreter)

            mainViewModel.result.observe(viewLifecycleOwner) { result ->
                if (result > 0.5) {
                    MaterialAlertDialogBuilder(
                        requireContext(),
                        com.google.android.material.R.style.ThemeOverlay_Material3_MaterialAlertDialog_Centered
                    )
                        .setTitle("Hasil Prediksi")
                        .setMessage("Hati-hati! Jamur ini tidak layak untuk dimakan.")
                        .setNegativeButton("Tutup") { dialog, _ ->
                            dialog.cancel()
                            reset()
                        }
                        .show()
                } else {
                    MaterialAlertDialogBuilder(
                        requireContext(),
                        com.google.android.material.R.style.ThemeOverlay_Material3_MaterialAlertDialog_Centered
                    )
                        .setTitle("Hasil Prediksi")
                        .setMessage("Jamur ini layak dimakan, namun pastikan untuk memasaknya dengan benar.")
                        .setNegativeButton("Tutup") { dialog, _ ->
                            dialog.cancel()
                            reset()
                        }
                        .show()
                }
            }
        }
    }

    private fun init() {
        val options = Interpreter.Options()

        options.setNumThreads(5)
        options.setUseNNAPI(true)

        interpreter = Interpreter(load(requireActivity().assets), options)
    }

    @SuppressLint("SetTextI18n")
    private fun reset() {
        binding.apply {
            inputCapShape.setText("")
            inputCapSurface.setText("")
            inputCapColor.setText("")
            inputBruises.setText("")
            inputGillSize.setText("")
            inputGillColor.setText("")
            inputRingNumber.setText("")
            inputRingType.setText("")
            inputSporePrintColor.setText("")
            inputPopulation.setText("")
            inputHabitat.setText("")
        }
    }

    private fun load(assets: AssetManager): MappedByteBuffer {
        val file = assets.openFd(modelPath)
        val stream = FileInputStream(file.fileDescriptor)
        val channel = stream.channel
        val startOffset = file.startOffset
        val declaredLength = file.declaredLength

        return channel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
    }

    private fun autoListener(autoComplete: AutoCompleteTextView, index: Int) {
        autoComplete.setOnItemClickListener { _, _, position, _ ->
            answers[index] = autoComplete.adapter.getItem(position).toString()
        }
    }

}
