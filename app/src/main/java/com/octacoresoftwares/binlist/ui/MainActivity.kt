package com.octacoresoftwares.binlist.ui

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.binlist.R
import com.octacoresoftwares.binlist.databinding.ActivityMainBinding
import com.octacoresoftwares.binlist.viewmodels.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val model by viewModels<MainViewModel> { factory }

    private lateinit var binding: ActivityMainBinding

    private var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = model
        binding.listener = listener
        binding.lifecycleOwner = this
        checkInternetAvailability()
        model.logoList = getImageResources()
    }

    private fun checkInternetAvailability() {
        try {
            val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
            connectivityManager?.registerDefaultNetworkCallback(object :
                ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    model.isInternetAvailable = true
                    dialog?.let {
                        if (it.isShowing)
                            it.dismiss()
                    }
                }

                override fun onLost(network: Network) {
                    model.showSnackBar = "Check internet connection."
                    model.snackBarActionText = "Settings"
                    model.isInternetAvailable = false
                }

                override fun onUnavailable() {
                    model.showSnackBar = "Check internet connection."
                    model.snackBarActionText = "Settings"
                    model.isInternetAvailable = false
                }
            })
        } catch (e: Exception) {
            Log.e("MainActivity", "Exception occurred in checkNetwork method", e)
        }
    }

    private val listener = View.OnClickListener {
        val intent = Intent(Settings.ACTION_SETTINGS)
        startActivityForResult(intent, 100)
    }

    private fun getImageResources(): List<Int> {
        val array = resources.obtainTypedArray(R.array.image_array)
        var list = emptyList<Int>()
        try {
            val length = array.length()
            for (i in 0 until length) {
                list = list.toMutableList().apply {
                    add(array.getResourceId(i, 0))
                }
            }
        } catch (e: Exception) {

        } finally {
            array.recycle()
        }
        return list
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_CANCELED) {
            return
        }
        if (resultCode == RESULT_OK) {
            if (requestCode == 100) {
                model.isInternetAvailable = true
            }
        }
    }
}