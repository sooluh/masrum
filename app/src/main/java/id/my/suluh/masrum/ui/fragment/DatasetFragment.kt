package id.my.suluh.masrum.ui.fragment

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
import id.my.suluh.masrum.model.TableModel

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
                val uri = Uri.parse("https://kaggle.com/datasets/uciml/mushroom-classification")

                intent.data = uri
                startActivity(intent)
            }
        }
    }

    private val featureLists = ArrayList<TableModel>().apply {
        add(TableModel("p", "x", "s", "n", "t", "p", "f", "c", "n", "k", "e", "e", "s", "s", "w", "w", "p", "w", "o", "p", "k", "s", "u"))
        add(TableModel("e", "x", "s", "y", "t", "a", "f", "c", "b", "k", "e", "c", "s", "s", "w", "w", "p", "w", "o", "p", "n", "n", "g"))
        add(TableModel("e", "b", "s", "w", "t", "l", "f", "c", "b", "n", "e", "c", "s", "s", "w", "w", "p", "w", "o", "p", "n", "n", "m"))
        add(TableModel("p", "x", "y", "w", "t", "p", "f", "c", "n", "n", "e", "e", "s", "s", "w", "w", "p", "w", "o", "p", "k", "s", "u"))
        add(TableModel("e", "x", "s", "g", "f", "n", "f", "w", "b", "k", "t", "e", "s", "s", "w", "w", "p", "w", "o", "e", "n", "a", "g"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
