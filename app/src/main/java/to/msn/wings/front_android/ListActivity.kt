package to.msn.wings.front_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import to.msn.wings.front_android.adapter.list.ListAdapter
import to.msn.wings.front_android.dao.list.Search
import to.msn.wings.front_android.vo.list.Item

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val searchDao = Search(resources)
        val data = searchDao.fetch().getData()
        val list = findViewById<ListView>(R.id.list)
        list.adapter = ListAdapter(
            this,
            data,
            R.layout.item,
        )

    }
}