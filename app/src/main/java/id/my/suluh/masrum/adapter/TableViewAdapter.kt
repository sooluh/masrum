package id.my.suluh.masrum.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.my.suluh.masrum.model.FeatureModel
import id.my.suluh.masrum.R

class TableViewAdapter(private val featureLists: ArrayList<FeatureModel>) :
    RecyclerView.Adapter<TableViewAdapter.RowViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_table, parent, false)
        return RowViewHolder(itemView)
    }

    private fun setHeaderBg(view: View) {
    }

    private fun setContentBg(view: View) {
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        val rowPosition = holder.adapterPosition

        if (rowPosition == 0) {
            holder.apply {
                setHeaderBg(columnClass)
                setHeaderBg(columnCapShape)
                setHeaderBg(columnCapSurface)
                setHeaderBg(columnCapColor)
                setHeaderBg(columnBruises)
                setHeaderBg(columnOdor)
                setHeaderBg(columnGillAttachment)
                setHeaderBg(columnGillSpacing)
                setHeaderBg(columnGillSize)
                setHeaderBg(columnGillColor)
                setHeaderBg(columnStalkShape)
                setHeaderBg(columnStalkRoot)
                setHeaderBg(columnStalkSurfaceAboveRing)
                setHeaderBg(columnStalkSurfaceBelowRing)
                setHeaderBg(columnStalkColorAboveRing)
                setHeaderBg(columnStalkColorBelowRing)
                setHeaderBg(columnVeilType)
                setHeaderBg(columnVeilColor)
                setHeaderBg(columnRingNumber)
                setHeaderBg(columnRingType)
                setHeaderBg(columnSporePrintColor)
                setHeaderBg(columnPopulation)
                setHeaderBg(columnHabitat)

                columnClass.text = "class"
                columnCapShape.text = "cap-shape"
                columnCapSurface.text = "cap-surface"
                columnCapColor.text = "cap-color"
                columnBruises.text = "bruises"
                columnOdor.text = "odor"
                columnGillAttachment.text = "gill-attachment"
                columnGillSpacing.text = "gill-spacing"
                columnGillSize.text = "gill-size"
                columnGillColor.text = "gill-color"
                columnStalkShape.text = "stalk-shape"
                columnStalkRoot.text = "stalk-root"
                columnStalkSurfaceAboveRing.text = "stalk-surface-above-ring"
                columnStalkSurfaceBelowRing.text = "stalk-surface-below-ring"
                columnStalkColorAboveRing.text = "stalk-color-above-ring"
                columnStalkColorBelowRing.text = "stalk-color-below-ring"
                columnVeilType.text = "veil-type"
                columnVeilColor.text = "veil-color"
                columnRingNumber.text = "ring-number"
                columnRingType.text = "ring-type"
                columnSporePrintColor.text = "spore-print-color"
                columnPopulation.text = "population"
                columnHabitat.text = "habitat"
            }
        } else {
            val model = featureLists[rowPosition - 1]

            holder.apply {
                setContentBg(columnClass)
                setContentBg(columnCapShape)
                setContentBg(columnCapSurface)
                setContentBg(columnCapColor)
                setContentBg(columnBruises)
                setContentBg(columnOdor)
                setContentBg(columnGillAttachment)
                setContentBg(columnGillSpacing)
                setContentBg(columnGillSize)
                setContentBg(columnGillColor)
                setContentBg(columnStalkShape)
                setContentBg(columnStalkRoot)
                setContentBg(columnStalkSurfaceAboveRing)
                setContentBg(columnStalkSurfaceBelowRing)
                setContentBg(columnStalkColorAboveRing)
                setContentBg(columnStalkColorBelowRing)
                setContentBg(columnVeilType)
                setContentBg(columnVeilColor)
                setContentBg(columnRingNumber)
                setContentBg(columnRingType)
                setContentBg(columnSporePrintColor)
                setContentBg(columnPopulation)
                setContentBg(columnHabitat)

                columnClass.text = model.columnClass
                columnCapShape.text = model.columnCapShape
                columnCapSurface.text = model.columnCapSurface
                columnCapColor.text = model.columnCapColor
                columnBruises.text = model.columnBruises
                columnOdor.text = model.columnOdor
                columnGillAttachment.text = model.columnGillAttachment
                columnGillSpacing.text = model.columnGillSpacing
                columnGillSize.text = model.columnGillSize
                columnGillColor.text = model.columnGillColor
                columnStalkShape.text = model.columnStalkShape
                columnStalkRoot.text = model.columnStalkRoot
                columnStalkSurfaceAboveRing.text = model.columnStalkSurfaceAboveRing
                columnStalkSurfaceBelowRing.text = model.columnStalkSurfaceBelowRing
                columnStalkColorAboveRing.text = model.columnStalkColorAboveRing
                columnStalkColorBelowRing.text = model.columnStalkColorBelowRing
                columnVeilType.text = model.columnVeilType
                columnVeilColor.text = model.columnVeilColor
                columnRingNumber.text = model.columnRingNumber
                columnRingType.text = model.columnRingType
                columnSporePrintColor.text = model.columnSporePrintColor
                columnPopulation.text = model.columnPopulation
                columnHabitat.text = model.columnHabitat
            }
        }
    }

    override fun getItemCount(): Int {
        return featureLists.size + 1
    }

    inner class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val columnClass: TextView = itemView.findViewById(R.id.column_class)
        val columnCapShape: TextView = itemView.findViewById(R.id.column_cap_shape)
        val columnCapSurface: TextView = itemView.findViewById(R.id.column_cap_surface)
        val columnCapColor: TextView = itemView.findViewById(R.id.column_cap_color)
        val columnBruises: TextView = itemView.findViewById(R.id.column_bruises)
        val columnOdor: TextView = itemView.findViewById(R.id.column_odor)
        val columnGillAttachment: TextView = itemView.findViewById(R.id.column_gill_attachment)
        val columnGillSpacing: TextView = itemView.findViewById(R.id.column_gill_spacing)
        val columnGillSize: TextView = itemView.findViewById(R.id.column_gill_size)
        val columnGillColor: TextView = itemView.findViewById(R.id.column_gill_color)
        val columnStalkShape: TextView = itemView.findViewById(R.id.column_stalk_shape)
        val columnStalkRoot: TextView = itemView.findViewById(R.id.column_stalk_root)
        val columnStalkSurfaceAboveRing: TextView =
            itemView.findViewById(R.id.column_stalk_surface_above_ring)
        val columnStalkSurfaceBelowRing: TextView =
            itemView.findViewById(R.id.column_stalk_surface_below_ring)
        val columnStalkColorAboveRing: TextView =
            itemView.findViewById(R.id.column_stalk_color_above_ring)
        val columnStalkColorBelowRing: TextView =
            itemView.findViewById(R.id.column_stalk_color_below_ring)
        val columnVeilType: TextView = itemView.findViewById(R.id.column_veil_type)
        val columnVeilColor: TextView = itemView.findViewById(R.id.column_veil_color)
        val columnRingNumber: TextView = itemView.findViewById(R.id.column_ring_number)
        val columnRingType: TextView = itemView.findViewById(R.id.column_ring_type)
        val columnSporePrintColor: TextView = itemView.findViewById(R.id.column_spore_print_color)
        val columnPopulation: TextView = itemView.findViewById(R.id.column_population)
        val columnHabitat: TextView = itemView.findViewById(R.id.column_habitat)
    }
}
