package to.msn.wings.front_android.dao.detail

import org.json.JSONException
import org.json.JSONObject
import to.msn.wings.front_android.vo.detail.Item
import java.io.BufferedReader
import java.io.InputStreamReader

class Detail (
    _resources: android.content.res.Resources
) {
    private val assetManager = _resources.assets
    private lateinit var data: Item
    private lateinit var rawData: String
    private lateinit var id: String

    fun setId(id: String): Detail {
        this.id = id
        return this
    }

    fun fetch(): Detail {
        this.rawData = BufferedReader(InputStreamReader(assetManager.open("detail.json"))).readText()
        return this
    }

    fun getData(): Item {
        try {
            val jsonObject = JSONObject(this.rawData).getJSONObject(this.id)
            this.data = Item(
                jsonObject.getLong("id"),
                jsonObject.getString("title"),
                jsonObject.getString("date"),
                jsonObject.getString("content")
            )
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return this.data
    }
}