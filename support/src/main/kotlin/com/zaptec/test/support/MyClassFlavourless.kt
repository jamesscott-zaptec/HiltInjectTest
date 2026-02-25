package com.zaptec.test.support

import javax.inject.Inject

class MyClassFlavourless @Inject constructor(): MyInterface {

    override fun doSomething(): String {
        return "Flavourless"
    }
}