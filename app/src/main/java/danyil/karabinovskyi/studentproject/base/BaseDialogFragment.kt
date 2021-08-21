package danyil.karabinovskyi.studentproject.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

abstract class BaseDialogFragment : DialogFragment() {

    protected abstract val layoutId: Int

    private var toast: Toast? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(layoutId, container, false)
    }

    fun showMessage(@StringRes messageId: Int?) {
        messageId?.let { showMessage(getString(messageId)) }
    }

    fun showMessage(message: String?) {
        if (message.isNullOrBlank()) {
            return
        }
        toast?.cancel()
        toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast?.show()
    }


    fun hideKeyboard(activity: Activity?) {
        if (activity != null) {
            val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            var view = activity.currentFocus
            if (view == null) {
                view = View(activity)
            }
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun hideKeyboardDialogs(activity: Activity?, view: View) {
        if (activity != null) {
            val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    inline operator fun SingleLiveEvent<Void>.invoke(crossinline block: () -> Unit) {
        this.observe(this@BaseDialogFragment, Observer { block() })
    }
    fun <T> LiveData<T>.nonNullObserve(owner : LifecycleOwner, observer : (t : T) -> Unit) {
        this.observe(owner, Observer {
            it?.let(observer)
        })
    }
    inline fun <T> LiveData<T>.observeNotNull(crossinline action: (T) -> Unit) {
        this.observe(this@BaseDialogFragment, Observer {
            if (it != null) action(it)
        })
    }

    inline fun <T> LiveData<T>.observe(crossinline action: (T?) -> Unit) {
        this.observe(this@BaseDialogFragment, Observer {
            action(it)
        })
    }

    inline fun <T> LiveData<T>.observeWithContext(crossinline action: Context.(T) -> Unit) =
            this.observe(this@BaseDialogFragment, Observer { value ->
                if (value != null) context?.action(value)
            })
}