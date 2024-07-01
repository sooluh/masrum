package id.my.suluh.masrum.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.my.suluh.masrum.adapter.TableViewAdapter
import id.my.suluh.masrum.databinding.FragmentDatasetBinding
import id.my.suluh.masrum.model.FeatureModel

class DatasetFragment : Fragment() {

    private var _binding: FragmentDatasetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDatasetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = TableViewAdapter(featureLists)

            openKaggle.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                val uri = Uri.parse("https://kaggle.com/datasets/uciml/mushrom-classification")

                intent.data = uri
                startActivity(intent)
            }
        }
    }

    private val featureLists = ArrayList<FeatureModel>().apply {
        add(FeatureModel("e", "x", "s", "n", "t", "p", "f", "c", "n", "k", "e", "e", "s", "s", "w", "w", "p", "w", "o", "p", "k", "s", "u"))
        add(FeatureModel("p", "x", "y", "n", "f", "a", "f", "c", "n", "b", "e", "c", "s", "s", "w", "w", "p", "w", "o", "p", "k", "n", "g"))
        add(FeatureModel("e", "x", "s", "g", "f", "c", "a", "d", "n", "g", "b", "b", "k", "k", "y", "y", "p", "y", "t", "p", "b", "m", "d"))
        add(FeatureModel("p", "b", "y", "y", "f", "l", "a", "w", "b", "y", "e", "f", "m", "h", "w", "h", "f", "w", "o", "e", "w", "v", "d"))
        add(FeatureModel("e", "a", "s", "n", "t", "a", "a", "c", "n", "h", "e", "b", "y", "m", "y", "h", "f", "y", "t", "p", "n", "y", "g"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
