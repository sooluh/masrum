package id.my.suluh.masrum.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.my.suluh.masrum.adapter.FeatureViewAdapter
import id.my.suluh.masrum.databinding.FragmentFeatureBinding
import id.my.suluh.masrum.model.FeatureModel

class FeatureFragment : Fragment() {

    private var _binding: FragmentFeatureBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeatureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val features = listOf(
            FeatureModel("cap-shape", "Bentuk payung jamur", "object"),
            FeatureModel("cap-surface", "Permukaan payung jamur", "object"),
            FeatureModel("cap-color", "Warna payung jamur", "object"),
            FeatureModel("bruises", "Apakah jamur memar atau tidak", "object"),
            FeatureModel("gill-size", "Ukuran insang jamur", "object"),
            FeatureModel("gill-color", "Warna insang jamur", "object"),
            FeatureModel("ring-number", "Jumlah cincin pada batang jamur", "object"),
            FeatureModel("ring-type", "Jenis cincin pada batang jamur", "object"),
            FeatureModel("spore-print-color", "Warna cetakan spora jamur", "object"),
            FeatureModel("population", "Kepadatan populasi jamur", "object"),
            FeatureModel("habitat", "Habitat tempat jamur tumbuh", "object"),
        )
        val adapter = FeatureViewAdapter(features)

        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
