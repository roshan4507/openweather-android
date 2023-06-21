package com.rpw.openweather.presentation

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rpw.openweather.R
import com.rpw.openweather.data.model.WeatherDataResponse
import com.rpw.openweather.data.util.AppConstants
import com.rpw.openweather.data.util.AppUtil
import com.rpw.openweather.databinding.ActivityMainBinding
import com.rpw.openweather.presentation.di.Injector
import com.rpw.openweather.presentation.weather.WeatherViewModel
import com.rpw.openweather.presentation.weather.WeatherViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: WeatherViewModelFactory
    private lateinit var weatherViewModel: WeatherViewModel

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as Injector).createWeatherSubComponent()
            .inject(this)

        weatherViewModel = ViewModelProvider(this, factory)[WeatherViewModel::class.java]


        activityMainBinding.edtSearch.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                activityMainBinding.progressBar.visibility = View.VISIBLE
                val responseData = weatherViewModel.getWeatherData((v as EditText).text.toString())
                responseData.observe(this, Observer {
                    activityMainBinding.progressBar.visibility = View.GONE
                    if (it != null) {
                        updateWeatherInfo(it)
                    }
                })
            }
            false
        }
    }

    private fun updateWeatherInfo(responseData: WeatherDataResponse) {

        activityMainBinding.tvCityLabel.visibility = View.GONE
        activityMainBinding.edtSearch.text?.clear()
        activityMainBinding.constraintLayoutShowingTemp.visibility = View.VISIBLE
        activityMainBinding.textTodaysDate.text =
            AppUtil.getCurrentDateTime(AppConstants.DATE_FORMAT)
        activityMainBinding.textTemperature.text = responseData.main.temp.toString()
        activityMainBinding.textCityName.text =
            "${responseData.name?.uppercase()}, ${responseData.sys.country}"
    }
}