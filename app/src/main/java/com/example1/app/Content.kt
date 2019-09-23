package com.example1.app

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Content : RealmObject() {
    @PrimaryKey
    var key:Int?= null
    var content:String?= null
}