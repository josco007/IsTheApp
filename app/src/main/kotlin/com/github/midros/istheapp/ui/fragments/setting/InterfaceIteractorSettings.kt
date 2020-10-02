package com.github.midros.istheapp.ui.fragments.setting

import com.github.midros.istheapp.di.PerActivity
import com.github.midros.istheapp.ui.activities.base.InterfaceInteractor

@PerActivity
interface InterfaceIteractorSettings <V : InterfaceViewSettings> : InterfaceInteractor<V> {

    fun getSettingsParams(goBackWord: List<String>, firstDelay: Long, delay: Long, goBackEventNumber: Int)

    fun valueEventGoBackWords()
}