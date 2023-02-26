package to.msn.wings.front_android.dao.list

import org.json.JSONException
import org.json.JSONObject
import to.msn.wings.front_android.vo.list.Item
import java.io.BufferedReader
import java.io.InputStreamReader

class Search (
    _resources: android.content.res.Resources
        ) {
    private val assetManager = _resources.assets
    private val data: MutableList<Item> = mutableListOf()
    private lateinit var rawData: String

    fun fetch(): Search {
        this.rawData = BufferedReader(InputStreamReader(assetManager.open("list.json"))).readText()

        return this
    }

    fun getData(): MutableList<Item> {
        try {
            val jsonObject = JSONObject(this.rawData)
            val jsonArray = jsonObject.getJSONArray("result")
            for (i in 0 until jsonArray.length()) {
                val jsonData = jsonArray.getJSONObject(i)
                this.data.add(
                    Item(
                        jsonData.getLong("id"),
                        jsonData.getString("title"),
                        jsonData.getString("summary"),
                        jsonData.getString("date")
                    )
                )
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return this.data
    }
}