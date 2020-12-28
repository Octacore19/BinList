package com.octacoresoftwares.binlist.databinding

import android.graphics.Typeface
import android.view.View
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView
import com.octacoresoftwares.domain.model.Country

@BindingAdapter(value = ["makeBold"])
fun MaterialTextView.makeBold(bolden: Boolean?) {
    bolden?.let {
        if (it) {
            setTypeface(typeface, Typeface.BOLD)
        } else {
            setTypeface(typeface, Typeface.NORMAL)
        }
    }
}

@BindingAdapter(value = ["country"])
fun MaterialTextView.setCountry(country: Country?) {
    text = if (country != null) {
        "${country.emoji ?: ""} ${country.name ?: '?'}"
    } else {
        "?"
    }
}

@BindingAdapter(value = ["cardVisibility"])
fun CardView.setCardVisibility(visible: Boolean) {
    visibility = if (visible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}