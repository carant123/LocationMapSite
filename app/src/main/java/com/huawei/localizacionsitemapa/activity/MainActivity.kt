package com.huawei.localizacionsitemapa.activity

import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.huawei.hms.location.ActivityIdentification
import com.huawei.hms.location.ActivityIdentificationService
import com.huawei.hms.location.FusedLocationProviderClient
import com.huawei.hms.location.LocationServices
import com.huawei.hms.site.api.SearchResultListener
import com.huawei.hms.site.api.SearchService
import com.huawei.hms.site.api.SearchServiceFactory
import com.huawei.hms.site.api.model.*
import com.huawei.hms.site.widget.SearchFilter
import com.huawei.hms.site.widget.SearchFragment
import com.huawei.hms.site.widget.SiteSelectionListener
import com.huawei.localizacionsitemapa.Constante
import com.huawei.localizacionsitemapa.R
import com.huawei.localizacionsitemapa.adapter.SiteAdapter
import com.huawei.localizacionsitemapa.base.BaseActivity
import com.huawei.localizacionsitemapa.broadcast.LocationBroadcastReceiver
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URLEncoder
import java.util.*


class MainActivity : BaseActivity() {

    private var adapterSite : SiteAdapter? = null

    init {
        activityIdent = this
    }

    companion object {
        lateinit var activityIdent: MainActivity
    }

    override fun getLayout(): Int = R.layout.activity_main

    override fun inicializar() {

    }

    private fun verificarPermisos() {
        if(!tieneLocationPermisos()) {
            ActivityCompat.requestPermissions(this, LISTA_PERMISSION, Constante.REQUEST_CODE)
        }
    }

    private fun tieneLocationPermisos() : Boolean {
        for (permisos in LISTA_PERMISSION) {
            if(baseContext?.let { ActivityCompat.checkSelfPermission(it, permisos) }
                != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

}