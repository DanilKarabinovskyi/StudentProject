package danyil.karabinovskyi.studentproject.utils

import android.R
import android.animation.LayoutTransition
import android.os.SystemClock
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}

fun View.disableClick() {
    isClickable = false
}

fun View.enableClick() {
    isClickable = true
}

fun View.isVisible() = visibility == View.VISIBLE


fun View.switchVisibility() {
    if (isVisible()) {
        gone()
    } else {
        visible()
    }
}

fun View.setOnClickWithDebounce(debounceTime: Long = 600L, action: () -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0

        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
            else action()
            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}

@Suppress("UNCHECKED_CAST")
fun <T> ViewGroup.getAllChildTag() : List<T> {
    val tempList = mutableListOf<T>()
    children.forEach {
        tempList.add(it.tag as T)
    }
    return tempList
}

fun ViewGroup.enableTransition(){
    layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
}

fun View.addRipple() = with(TypedValue()) {
    context.theme.resolveAttribute(R.attr.selectableItemBackground, this, true)
    setBackgroundResource(resourceId)
}

fun View.addCircleRipple() = with(TypedValue()) {
    context.theme.resolveAttribute(R.attr.selectableItemBackgroundBorderless, this, true)
    setBackgroundResource(resourceId)
}