package danyil.karabinovskyi.studentproject.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import kotlin.reflect.KClass

abstract class BaseVMFragment<B : ViewDataBinding> :
    BaseBindingFragment<B>() {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this

        }
    }

//    fun ParsedError.showErrorToast() {
//        this.errorResId?.let {
//            showMessage(it)
//        }
//        this.error?.let {
//            showMessage(it)
//        }
//   }
