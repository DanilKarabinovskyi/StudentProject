package danyil.karabinovskyi.studentproject.ui.registration

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseStateFragment
import danyil.karabinovskyi.studentproject.databinding.FragmentEntranceBinding
import danyil.karabinovskyi.studentproject.databinding.FragmentRegistrationBinding
import danyil.karabinovskyi.studentproject.ui.entrance.EntranceFragmentDirections
import danyil.karabinovskyi.studentproject.ui.primary.PrimaryViewModel
import danyil.karabinovskyi.studentproject.utils.setOnClickWithDebounce

@AndroidEntryPoint
class RegistrationFragment : BaseStateFragment<FragmentRegistrationBinding>() {

    override val layoutId = R.layout.fragment_registration

    val viewModel: PrimaryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickWithDebounce {
            findNavController().navigate(RegistrationFragmentDirections.registrationToGlobalActivity())
            requireActivity().finish()
        }
    }
}