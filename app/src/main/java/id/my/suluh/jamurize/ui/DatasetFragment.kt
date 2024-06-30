package id.my.suluh.jamurize.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import id.my.suluh.jamurize.databinding.FragmentDatasetBinding
import id.my.suluh.jamurize.viewmodel.DatasetViewModel

class DatasetFragment : Fragment() {

    private var _binding: FragmentDatasetBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val datasetViewModel = ViewModelProvider(this)[DatasetViewModel::class.java]

        _binding = FragmentDatasetBinding.inflate(inflater, container, false)

        val root: View = binding.root
        val textView: TextView = binding.textDataset

        datasetViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
