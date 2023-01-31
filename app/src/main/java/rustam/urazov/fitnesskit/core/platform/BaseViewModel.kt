package rustam.urazov.fitnesskit.core.platform

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rustam.urazov.fitnesskit.core.exception.Failure

abstract class BaseViewModel : ViewModel() {

    private val mutableFailure: MutableLiveData<Failure> = MutableLiveData()
    val failure: LiveData<Failure> = mutableFailure

    protected fun handleFailure(failure: Failure) {
        mutableFailure.value = failure
    }
}