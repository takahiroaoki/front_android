package to.msn.wings.front_android.adapter.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import to.msn.wings.front_android.R
import to.msn.wings.front_android.viewHelper.list.Item

class ListAdapter (
    private val context: Context,
    private val data: List<Item>,
    private val resource: Int
        ): BaseAdapter() {
    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(pos: Int): Item {
        return data[pos]
    }

    override fun getItemId(pos: Int): Long {
        return data[pos].id
    }

    override fun getView(pos: Int, convertView: View?, parent: ViewGroup?): View {
        val item = getItem(pos)
        val sview = convertView ?: inflater.inflate(resource, null)
        sview.findViewById<TextView>(R.id.title).text = item.title
        sview.findViewById<TextView>(R.id.summary).text = item.summary
        sview.findViewById<TextView>(R.id.date).text = item.date
        return sview
    }
}