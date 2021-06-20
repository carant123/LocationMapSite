package com.huawei.localizacionsitemapa.fragment

import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.huawei.hms.maps.CameraUpdateFactory
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.MapView
import com.huawei.hms.maps.OnMapReadyCallback
import com.huawei.hms.maps.model.*
import com.huawei.localizacionsitemapa.Constante
import com.huawei.localizacionsitemapa.R
import com.huawei.localizacionsitemapa.base.BaseFragment


class MapaFragment : BaseFragment() {

    override fun getLayout(): Int = R.layout.fragment_mapa

    override fun inicializar(view: View, savedInstanceState: Bundle?) {

    }

    private fun solicitarPermisosLocalizacion() {
        if (!hasLocationPermission()) {
            activity?.let { ActivityCompat.requestPermissions(it, LISTA_PERMISSION, Constante.REQUEST_CODE) }
        }
    }

    private fun hasLocationPermission(): Boolean {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            for (permission in LISTA_PERMISSION) {
                if (activity?.let { ActivityCompat.checkSelfPermission(it, permission) } != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
        }
        return true
    }

}