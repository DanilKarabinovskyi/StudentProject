package danyil.karabinovskyi.studentproject.ui.entrance

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseStateFragment
import danyil.karabinovskyi.studentproject.databinding.FragmentEntranceBinding
import danyil.karabinovskyi.studentproject.ui.primary.PrimaryViewModel
import danyil.karabinovskyi.studentproject.utils.setOnClickWithDebounce

@AndroidEntryPoint
class EntranceFragment : BaseStateFragment<FragmentEntranceBinding>() {

    override val layoutId = R.layout.fragment_entrance

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupAnimations()
        initListeners()
        setupUI()
    }

    private fun initListeners(){
        binding.professorCardView.setOnClickWithDebounce {
            findNavController().navigate(EntranceFragmentDirections.entranceToRegistration())
        }
        binding.studentCardView.setOnClickWithDebounce {
            findNavController().navigate(EntranceFragmentDirections.entranceToLogin())
        }
        binding.anonymousCardView.setOnClickWithDebounce {
            findNavController().navigate(EntranceFragmentDirections.entranceToGlobalActivity())
            requireActivity().finish()
        }
    }

    private fun setupAnimations(){
        binding.anonymousCardView.translationX = 800F
        binding.studentCardView.translationX = 800F
        binding.professorCardView.translationX = 800F

        binding.anonymousCardView.alpha = 0F
        binding.studentCardView.alpha = 0F
        binding.professorCardView.alpha = 0F

        binding.professorCardView.animate()
            .translationX(0F).alpha(1F).setDuration(600).setStartDelay(300).start()

        binding.studentCardView.animate()
            .translationX(0F).alpha(1F).setDuration(600).setStartDelay(350).start()

        binding.anonymousCardView.animate()
            .translationX(0F).alpha(1F).setDuration(600).setStartDelay(400).start()
    }

    private fun setupUI(){
        hideKeyboard(requireActivity())
    }
}