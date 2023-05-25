package com.example.myapplication

import io.realm.Realm
import io.realm.RealmObject

open class Model:RealmObject()
{
    var id=0
    var name=""
    var num=""
}