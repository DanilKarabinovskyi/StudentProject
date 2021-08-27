package danyil.karabinovskyi.studentproject.ui.login

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseStateFragment
import danyil.karabinovskyi.studentproject.databinding.FragmentLoginBinding
import danyil.karabinovskyi.studentproject.ui.primary.PrimaryViewModel
import danyil.karabinovskyi.studentproject.utils.setOnClickWithDebounce

@AndroidEntryPoint
class LoginFragment : BaseStateFragment<FragmentLoginBinding>() {

    override val layoutId = R.layout.fragment_login

    val viewModel: PrimaryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        initListeners()
    }

    private fun setupUI(){
        binding.cardView.foreground = ContextCompat.getDrawable(requireActivity(), R.drawable.shape_left_panel);
    }
    private fun initListeners(){
        binding.loginButton.setOnClickWithDebounce {
            findNavController().navigate(LoginFragmentDirections.loginToGlobalActivity())
            requireActivity().finish()
        }
        binding.signUpText.setOnClickWithDebounce {
            findNavController().navigate(LoginFragmentDirections.loginToRegistration())
        }

        binding.signUpTop.setOnClickWithDebounce {
            findNavController().navigate(LoginFragmentDirections.loginToRegistration())
        }
    }
}