package danyil.karabinovskyi.studentproject.ui.other

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseStateFragment
import danyil.karabinovskyi.studentproject.databinding.FragmentOtherBinding
import danyil.karabinovskyi.studentproject.utils.setOnClickWithDebounce

@AndroidEntryPoint
class OtherFragment : BaseStateFragment<FragmentOtherBinding>() {

    override val layoutId = R.layout.fragment_other

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI(){

    binding.preferences.setOnClickWithDebounce {
        findNavController().navigate(OtherFragmentDirections.otherToPreferences())
    }
    }
}