package danyil.karabinovskyi.studentproject.ui.events

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseStateFragment
import danyil.karabinovskyi.studentproject.databinding.FragmentChatsBinding
import danyil.karabinovskyi.studentproject.databinding.FragmentEventsBinding
import danyil.karabinovskyi.studentproject.ui.primary.PrimaryViewModel

@AndroidEntryPoint
class EventsFragment : BaseStateFragment<FragmentEventsBinding>() {

    override val layoutId = R.layout.fragment_events


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}