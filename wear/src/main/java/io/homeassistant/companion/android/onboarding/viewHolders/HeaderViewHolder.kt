package io.homeassistant.companion.android.onboarding.viewHolders

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.homeassistant.companion.android.R

class HeaderViewHolder(v: View): RecyclerView.ViewHolder(v) {

    val headerTextView = v.findViewById<TextView>(R.id.headerTextView)
    var nodeId: Int = 0
}