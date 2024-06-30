package id.my.suluh.jamurize.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import id.my.suluh.jamurize.databinding.FragmentFeatureBinding
import id.my.suluh.jamurize.viewmodel.FeatureViewModel

class FeatureFragment : Fragment() {

    private var _binding: FragmentFeatureBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val featureViewModel = ViewModelProvider(this)[FeatureViewModel::class.java]

        _binding = FragmentFeatureBinding.inflate(inflater, container, false)

        val root: View = binding.root
        val textView: TextView = binding.textFeature

        featureViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
