package danyil.karabinovskyi.studentproject.ui.primary

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseState
import danyil.karabinovskyi.studentproject.base.BaseStateFragment
import danyil.karabinovskyi.studentproject.databinding.PrimaryFragmentBinding
import danyil.karabinovskyi.studentproject.utils.setOnClickWithDebounce

@AndroidEntryPoint
class PrimaryFragment: BaseStateFragment<PrimaryFragmentBinding>() {
    override val layoutId = R.layout.primary_fragment

    val viewModel:PrimaryViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickWithDebounce {
            findNavController()?.navigate(R.id.action_primaryFragment_to_loginFragment3)
        }
    }

    sealed class State : BaseState() {
        object SuccessState : State()
        object LoadingState : State()
    }
}