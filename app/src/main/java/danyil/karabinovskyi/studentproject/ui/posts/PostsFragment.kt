package danyil.karabinovskyi.studentproject.ui.posts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseStateFragment
import danyil.karabinovskyi.studentproject.databinding.FragmentOtherBinding
import danyil.karabinovskyi.studentproject.databinding.FragmentPostsBinding
import danyil.karabinovskyi.studentproject.ui.primary.PrimaryViewModel

@AndroidEntryPoint
class PostsFragment : BaseStateFragment<FragmentPostsBinding>() {

    override val layoutId = R.layout.fragment_posts


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}