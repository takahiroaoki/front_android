package to.msn.wings.front_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import to.msn.wings.front_android.adapter.list.ListAdapter
import to.msn.wings.front_android.viewHelper.list.Item

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val data = mutableListOf(
            Item(1, "title1", "summary1", "2023-02-26"),
            Item(2, "title2", "summary2", "2023-02-26"),
            Item(3, "title3", "summary3", "2023-02-26"),
        )
        val list = findViewById<ListView>(R.id.list)
        list.adapter = ListAdapter(
            this,
            data,
            R.layout.item,
        )

    }
}