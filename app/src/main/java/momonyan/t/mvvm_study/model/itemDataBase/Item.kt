package momonyan.t.mvvm_study.model.itemDataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true) val itemId: Long,
    @ColumnInfo(name = "item_name") val itemName: String,
    @ColumnInfo(name = "item_price") val itemPrice: Long
)