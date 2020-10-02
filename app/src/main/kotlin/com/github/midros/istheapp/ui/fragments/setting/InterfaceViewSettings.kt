package com.github.midros.istheapp.ui.fragments.setting

import com.github.midros.istheapp.ui.activities.base.InterfaceView
import com.github.midros.istheapp.ui.adapters.recordingadapter.RecordingRecyclerAdapter
import com.google.firebase.database.DataSnapshot

interface InterfaceViewSettings : InterfaceView {

    fun setSettingsParams(words: List<String>, firstDelay: Long, delay: Long, goBackEventNumber: Int)

}