package com.github.midros.istheapp.ui.fragments.setting

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.github.midros.istheapp.data.model.ChildSettings
import com.github.midros.istheapp.data.rxFirebase.InterfaceFirebase
import com.github.midros.istheapp.ui.activities.base.BaseInteractor
import com.github.midros.istheapp.utils.Consts
import com.pawegio.kandroid.e
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class InteractorSettings<V: InterfaceViewSettings>
@Inject constructor(supportFragment: FragmentManager,
                    context: Context,
                    firebase: InterfaceFirebase) : BaseInteractor<V>(supportFragment, context,firebase), InterfaceIteractorSettings<V> {


    override fun valueEventGoBackWords() {
        firebase().valueEventModel("${Consts.SETTINGS}/${Consts.PARAMS}", ChildSettings::class.java)
                .observeOn(AndroidSchedulers.mainThread())
                .take(1)
                .subscribe({ child ->
                    if (!child.goBackWords.isNullOrEmpty()) {
                        getView()!!.setSettingsParams(child.goBackWords!!,
                                child.firstGoBackDelay,
                                child.goBackDelay,
                                child.goBackEventNumber)
                    }

                }, { error -> e(Consts.TAG, error.message.toString()) })

    }

    override fun getSettingsParams(goBackWord: List<String>, firstDelay: Long, delay: Long, goBackEventNumber: Int) {
        val childGoBackWords = ChildSettings(goBackWord, firstDelay, delay, goBackEventNumber)
        firebase().getDatabaseReference("${Consts.SETTINGS}/${Consts.PARAMS}").setValue(childGoBackWords)
    }



}