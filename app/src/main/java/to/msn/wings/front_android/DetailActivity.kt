package to.msn.wings.front_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import to.msn.wings.front_android.dao.detail.Detail

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getStringExtra("id")
        if (id != null && id != "") {
            val data = Detail(resources).setId(id).fetch().getData()
            findViewById<TextView>(R.id.detail_title).text = data.title
            findViewById<TextView>(R.id.detail_date).text = data.date
            findViewById<TextView>(R.id.detail_content).text = data.content
        }
    }
}