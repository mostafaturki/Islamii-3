package com.route.islamii3.home.fragments.hadith

import android.icu.text.Transliterator.Position
import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hadith(
    val title : String, val content: String
):Parcelable


/*
{
    constructor(parcel: Parcel) : this(
        title= parcel.readString()?:"",
        content = parcel.readString()?:""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hadith> {
        override fun createFromParcel(parcel: Parcel): Hadith {
            return Hadith(parcel)
        }

        override fun newArray(size: Int): Array<Hadith?> {
            return arrayOfNulls(size)
        }
    }
}


 */