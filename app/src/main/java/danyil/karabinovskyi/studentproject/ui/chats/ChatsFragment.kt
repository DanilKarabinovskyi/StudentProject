package danyil.karabinovskyi.studentproject.ui.chats

import android.os.Bundle
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseStateFragment
import danyil.karabinovskyi.studentproject.databinding.FragmentChatsBinding

@AndroidEntryPoint
class ChatsFragment : BaseStateFragment<FragmentChatsBinding>() {

    override val layoutId = R.layout.fragment_chats


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}