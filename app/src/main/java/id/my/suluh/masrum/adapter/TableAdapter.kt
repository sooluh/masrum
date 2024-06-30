package id.my.suluh.masrum.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.my.suluh.masrum.R

class TableAdapter(private val data: List<List<String>>) :
    RecyclerView.Adapter<TableAdapter.TableViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_table_row, parent, false)
        return TableViewHolder(view)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        val rowData = data[position]
        val rowLayout = holder.itemView as LinearLayout

        rowLayout.removeAllViews()

        for (cellData in rowData) {
            val textView = TextView(holder.itemView.context).apply {
                text = cellData
                setPadding(8, 8, 8, 8)
                setTextAppearance(android.R.style.TextAppearance_Material_Body1)
            }
            rowLayout.addView(textView)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
