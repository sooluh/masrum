package id.my.suluh.masrum.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.my.suluh.masrum.model.FeatureModel
import id.my.suluh.masrum.R

class FeatureViewAdapter(private val features: List<FeatureModel>) :
    RecyclerView.Adapter<FeatureViewAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_feature, parent, false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FeatureViewAdapter.ListViewHolder, position: Int) {
        val item = features[position]

        holder.apply {
            feature.text = item.feature
            description.text = item.description
            dataType.text = item.dataType
        }
    }

    override fun getItemCount(): Int = features.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val feature: TextView = itemView.findViewById(R.id.feature)
        val description: TextView = itemView.findViewById(R.id.description)
        val dataType: TextView = itemView.findViewById(R.id.data_type)
    }

}
