package danyil.karabinovskyi.studentproject.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer


abstract class BaseStateFragment< B : ViewDataBinding> :
    BaseVMFragment< B>() {

}