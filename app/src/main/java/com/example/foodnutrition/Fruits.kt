package com.example.foodnutrition

import android.os.Parcel
import android.os.Parcelable


data class Fruits(
    val name: String?,
    val description: String?,
    val photo: Int,
    val calories: Int,
    val calcium: Int,
    val carbs: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(photo)
        parcel.writeInt(calories)
        parcel.writeInt(calcium)
        parcel.writeDouble(carbs)
    }

    override fun describeContents(): Int {
        return 0
    }


    companion object CREATOR : Parcelable.Creator<Fruits> {
        override fun createFromParcel(parcel: Parcel): Fruits {
            return Fruits(parcel)
        }

        override fun newArray(size: Int): Array<Fruits?> {
            return arrayOfNulls(size)
        }
    }
}
