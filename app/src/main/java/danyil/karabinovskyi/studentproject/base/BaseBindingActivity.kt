package danyil.karabinovskyi.studentproject.base

import android.app.Activity
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import danyil.karabinovskyi.studentproject.R


abstract class BaseBindingActivity<Binding : ViewDataBinding> : AppCompatActivity() {

    lateinit var binding: Binding

    @MenuRes
    var menuId = -1

    private var toast: Toast? = null
    protected abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)
    }

    fun showMessage(@StringRes messageId: Int?) {
        messageId?.let { showMessage(getString(messageId)) }
    }

    fun showMessage(message: String?) {
        if (message.isNullOrBlank()) {
            return
        }
        toast?.cancel()
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast?.show()
    }

    fun Any.showErrorToast() {
        when (this) {
            is Int -> {
                showMessage(this)
            }

            is String -> {
                showMessage(this)
            }

            else -> {
                showMessage("unknown error type")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (menuId != -1) {
            menuInflater.inflate(menuId, menu)
            return true
        } else {
            menu?.clear()
            return false
        }
    }

    fun hideKeyboard(view: View) {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}