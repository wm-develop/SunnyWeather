package com.sunnyweather.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.LogUtil
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.model.Result

class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<String>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { city ->
        LogUtil.d("PlaceViewModel", "switchMap方法已被调用")
        Repository.searchPlaces(city)
    }

    fun searchPlaces(city: String) {
        searchLiveData.value = city
        LogUtil.d("PlaceViewModel", searchLiveData.value.toString())
    }

    fun savePlace(city: String) = Repository.savePlace(city)

    fun getSavedPlace() = Repository.getSavedPlace()

    fun isPlaceSaved() = Repository.isPlaceSaved()

}