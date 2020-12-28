package com.octacoresoftwares.binlist.databinding

import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textview.MaterialTextView
import com.octacoresoftwares.binlist.R
import com.octacoresoftwares.domain.model.Country
import java.util.*

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

@BindingAdapter(
    value = ["snackBarText", "snackBarActionText", "snackBarListener"],
    requireAll = false
)
fun ViewGroup.makeSnackBar(text: String?, actionText: String?, listener: View.OnClickListener?) {
    text?.let {
        if (it.isNotEmpty()) {
            if (actionText != null && actionText.isEmpty()) {
                Snackbar.make(this, it, Snackbar.LENGTH_LONG).apply {
                    val layout = this.view.layoutParams as CoordinatorLayout.LayoutParams
                    layout.gravity = Gravity.TOP
                    this.view.layoutParams = layout
                    show()
                }
            }

            if (actionText != null && listener != null) {
                Snackbar.make(this, it, Snackbar.LENGTH_INDEFINITE).apply {
                    setAction(actionText, listener)
                    setActionTextColor(ContextCompat.getColor(context, R.color.teal_200))
                    val layout = this.view.layoutParams as CoordinatorLayout.LayoutParams
                    layout.gravity = Gravity.TOP
                    this.view.layoutParams = layout
                    show()
                }
            }
            /*Snackbar.make(this, it, Snackbar.LENGTH_INDEFINITE).apply {
                if (actionText != null && listener != null) {
                    setAction(actionText, listener)
                    setActionTextColor(ContextCompat.getColor(context, R.color.teal_200))
                }
                val layout = this.view.layoutParams as CoordinatorLayout.LayoutParams
                layout.gravity = Gravity.TOP
                this.view.layoutParams = layout
                show()
            }*/
        }
    }
}

@BindingAdapter(value = ["scheme", "icons"])
fun ImageView.setLogo(scheme: String?, icons: List<Int>) {
    scheme?.let {
        when (it.toLowerCase(Locale.getDefault())) {
            "mastercard" -> {
                this.setImageResource(icons[0])
            }
            "visa" -> {
                this.setImageResource(icons[1])
            }
        }
    }
}