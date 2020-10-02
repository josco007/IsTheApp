package com.github.midros.istheapp.data.model

class ChildSettings  {

    var goBackWords: List<String>? = null
    var firstGoBackDelay: Long = 0
    var goBackDelay: Long = 0
    var goBackEventNumber: Int = 0

    constructor() {}

    constructor(goBackWords: List<String>?, firstGoBackDelay: Long , goBackDelay: Long, goBackEventNumber: Int) {
        this.goBackWords = goBackWords
        this.firstGoBackDelay = firstGoBackDelay
        this.goBackDelay = goBackDelay
        this.goBackEventNumber = goBackEventNumber
    }

}