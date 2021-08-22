package danyil.karabinovskyi.studentproject.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseState
import danyil.karabinovskyi.studentproject.base.BaseStateFragment
import danyil.karabinovskyi.studentproject.databinding.FragmentPrimaryBinding
import danyil.karabinovskyi.studentproject.databinding.FragmentSplashBinding
import danyil.karabinovskyi.studentproject.ui.primary.PrimaryViewModel
import danyil.karabinovskyi.studentproject.ui.registration.RegistrationFragmentDirections
import danyil.karabinovskyi.studentproject.utils.setOnClickWithDebounce

@AndroidEntryPoint
class SplashFragment: BaseStateFragment<FragmentSplashBinding>() {
    override val layoutId = R.layout.fragment_splash


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fadeIn = ScaleAnimation(
            0f,
            1f,
            0f,
            1f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )

        fadeIn.duration = 1500
        fadeIn.fillAfter = true

        binding.splashImage.animation = fadeIn
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(SplashFragmentDirections.splashToEntrance())
        }, 2000)
    }

    sealed class State : BaseState() {
        object SuccessState : State()
        object LoadingState : State()
    }
}