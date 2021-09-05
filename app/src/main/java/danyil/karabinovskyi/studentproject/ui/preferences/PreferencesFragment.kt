package danyil.karabinovskyi.studentproject.ui.preferences

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseStateFragment
import danyil.karabinovskyi.studentproject.databinding.FragmentPreferencesBinding
import danyil.karabinovskyi.studentproject.domain.preferences.entity.PreferenceEntity
import danyil.karabinovskyi.studentproject.ui.login.LoginViewModel

class PreferencesFragment : BaseStateFragment<FragmentPreferencesBinding>() {

    override val layoutId = R.layout.fragment_preferences

    val viewModel: LoginViewModel by viewModels()
    private val adapter = PreferencesAdapter { preference ->
        preference.state = !preference.state
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        initListeners()
    }

    private fun setupUI(){
        binding.preferencesList.adapter = adapter
        var list = mutableListOf<PreferenceEntity>(
            PreferenceEntity("","Category",false),
            PreferenceEntity("","Category",false),
            PreferenceEntity("","Category",false),
            PreferenceEntity("","Category",false),
            PreferenceEntity("","Category",true),
            PreferenceEntity("","Category",true),
            PreferenceEntity("","Category",true),
            PreferenceEntity("","Category",true),
            PreferenceEntity("","Category",true),
            PreferenceEntity("","Category",false),
            PreferenceEntity("","Category",false),
            PreferenceEntity("","Category",false),
        )
        adapter.submitList(list)
    }
    private fun initListeners(){
    }
}