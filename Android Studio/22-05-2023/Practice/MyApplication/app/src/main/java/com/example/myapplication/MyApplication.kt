package com.example.myapplication

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplication:Application()
{
    override fun onCreate()
    {
        super.onCreate()

        Realm.init(this)

        var conf:RealmConfiguration= RealmConfiguration.Builder().name("tops.db")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(conf)
    }
}