package danyil.karabinovskyi.studentproject.ui.posts.viewpager_fragments.all_posts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseStateFragment
import danyil.karabinovskyi.studentproject.databinding.FragmentPostsAllBinding
import danyil.karabinovskyi.studentproject.domain.posts.entity.PostEntity
import danyil.karabinovskyi.studentproject.ui.primary.PrimaryViewModel
import danyil.karabinovskyi.studentproject.ui.primary.posts_recommendation.PostsRecommendationAdapter

class AllPostsFragment: BaseStateFragment<FragmentPostsAllBinding>() {
    override val layoutId = R.layout.fragment_posts_all

    val viewModel: PrimaryViewModel by viewModels()

    private val adapterPosts = PostsRecommendationAdapter { event ->
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        hideKeyboard(requireActivity())
        binding.postsRecommendationList.adapter = adapterPosts
        binding.postsRecommendationList.layoutManager =  GridLayoutManager(requireContext(), 2)
        var listPosts = mutableListOf<PostEntity>(
            PostEntity(
                "",
                "https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                "title",
                "",
                "16.08 01.09.2077"
            ),
            PostEntity(
                "",
                "https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                "title",
                "",
                "16.08 01.09.2077"
            ),
            PostEntity(
                "",
                "https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                "title",
                "",
                "16.08 01.09.2077"
            ),
            PostEntity(
                "",
                "https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                "title",
                "",
                "16.08 01.09.2077"
            ),
            PostEntity(
                "",
                "https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                "title",
                "",
                "16.08 01.09.2077"
            ),
            PostEntity(
                "",
                "https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                "title",
                "",
                "16.08 01.09.2077"
            ),
            PostEntity(
                "",
                "https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                "title",
                "",
                "16.08 01.09.2077"
            ),
            PostEntity(
                "",
                "https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                "title",
                "",
                "16.08 01.09.2077"
            ),
            PostEntity(
                "",
                "https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                "title",
                "",
                "16.08 01.09.2077"
            ),
            PostEntity(
                "",
                "https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                "title",
                "",
                "16.08 01.09.2077"
            ),
            PostEntity(
                "",
                "https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                "title",
                "",
                "16.08 01.09.2077"
            ),
            PostEntity(
                "",
                "https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                "title",
                "",
                "16.08 01.09.2077"
            ),
        )
        adapterPosts.submitList(listPosts)
    }
}