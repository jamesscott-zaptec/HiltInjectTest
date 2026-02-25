package com.zaptec.test.support

import javax.inject.Inject

class MyClass @Inject constructor(): MyInterface {

    override fun doSomething(): String {
        return "DevCompleteDebug"
    }
}