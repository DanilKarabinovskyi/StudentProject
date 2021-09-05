package danyil.karabinovskyi.studentproject.ui.primary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseStateFragment
import danyil.karabinovskyi.studentproject.databinding.FragmentPrimaryBinding
import danyil.karabinovskyi.studentproject.domain.events.entity.EventEntity
import danyil.karabinovskyi.studentproject.domain.friends.entity.FriendEntity
import danyil.karabinovskyi.studentproject.domain.posts.entity.PostEntity
import danyil.karabinovskyi.studentproject.ui.primary.events_recommendation.EventsRecommendationAdapter
import danyil.karabinovskyi.studentproject.ui.primary.friends_recommendation.FriendsRecommendationAdapter
import danyil.karabinovskyi.studentproject.ui.primary.posts_recommendation.PostsRecommendationAdapter
import danyil.karabinovskyi.studentproject.utils.setOnClickWithDebounce

@AndroidEntryPoint
class PrimaryFragment: BaseStateFragment<FragmentPrimaryBinding>() {
    override val layoutId = R.layout.fragment_primary

    val viewModel:PrimaryViewModel by viewModels()
    private val adapterFriends = FriendsRecommendationAdapter { friend ->
    }
    private val adapterEvents = EventsRecommendationAdapter { post ->
    }
    private val adapterPosts = PostsRecommendationAdapter { event ->
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        binding.preferences.setOnClickWithDebounce {

        }
    }

    private fun setupUI(){
        hideKeyboard(requireActivity())
        binding.friendsRecommendationList.adapter = adapterFriends
        binding.postsRecommendationList.adapter = adapterPosts
        binding.eventsRecommendationList.adapter = adapterEvents
        var listFriends = mutableListOf<FriendEntity>(
                FriendEntity("","Category","Category","https://images.unsplash.com/photo-1630416268197-8e14b3770960?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
                FriendEntity("","Category","Category","https://images.unsplash.com/photo-1630416268197-8e14b3770960?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
                FriendEntity("","Category","Category","https://images.unsplash.com/photo-1630416268197-8e14b3770960?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
                FriendEntity("","Category","Category","https://images.unsplash.com/photo-1630416268197-8e14b3770960?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
                FriendEntity("","Category","Category","https://images.unsplash.com/photo-1630416268197-8e14b3770960?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
                FriendEntity("","Category","Category","https://images.unsplash.com/photo-1630416268197-8e14b3770960?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
                FriendEntity("","Category","Category","https://images.unsplash.com/photo-1630416268197-8e14b3770960?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
                FriendEntity("","Category","Category","https://images.unsplash.com/photo-1630416268197-8e14b3770960?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
                FriendEntity("","Category","Category","https://images.unsplash.com/photo-1630416268197-8e14b3770960?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
                FriendEntity("","Category","Category","https://images.unsplash.com/photo-1630416268197-8e14b3770960?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
                FriendEntity("","Category","Category","https://images.unsplash.com/photo-1630416268197-8e14b3770960?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
                FriendEntity("","Category","Category","https://images.unsplash.com/photo-1630416268197-8e14b3770960?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
        )
        var listEvents = mutableListOf<EventEntity>(
                EventEntity("","https://images.unsplash.com/photo-1630370939214-4c4041b5efc4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","Category","","16.08 01.09.2077","Vinnytzia"),
                EventEntity("","https://images.unsplash.com/photo-1630370939214-4c4041b5efc4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","Category","","16.08 01.09.2077","Vinnytzia"),
                EventEntity("","https://images.unsplash.com/photo-1630370939214-4c4041b5efc4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","Category","","16.08 01.09.2077","Vinnytzia"),
                EventEntity("","https://images.unsplash.com/photo-1630370939214-4c4041b5efc4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","Category","","16.08 01.09.2077","Vinnytzia"),
                EventEntity("","https://images.unsplash.com/photo-1630370939214-4c4041b5efc4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","Category","","16.08 01.09.2077","Vinnytzia"),
                EventEntity("","https://images.unsplash.com/photo-1630370939214-4c4041b5efc4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","Category","","16.08 01.09.2077","Vinnytzia"),
                EventEntity("","https://images.unsplash.com/photo-1630370939214-4c4041b5efc4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","Category","","16.08 01.09.2077","Vinnytzia"),
                EventEntity("","https://images.unsplash.com/photo-1630370939214-4c4041b5efc4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","Category","","16.08 01.09.2077","Vinnytzia"),
                EventEntity("","https://images.unsplash.com/photo-1630370939214-4c4041b5efc4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","Category","","16.08 01.09.2077","Vinnytzia"),
                EventEntity("","https://images.unsplash.com/photo-1630370939214-4c4041b5efc4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","Category","","16.08 01.09.2077","Vinnytzia"),
                EventEntity("","https://images.unsplash.com/photo-1630370939214-4c4041b5efc4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","Category","","16.08 01.09.2077","Vinnytzia"),
                EventEntity("","https://images.unsplash.com/photo-1630370939214-4c4041b5efc4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","Category","","16.08 01.09.2077","Vinnytzia"),
        )
        var listPosts = mutableListOf<PostEntity>(
                PostEntity("","https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","title","","16.08 01.09.2077"),
                PostEntity("","https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","title","","16.08 01.09.2077"),
                PostEntity("","https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","title","","16.08 01.09.2077"),
                PostEntity("","https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","title","","16.08 01.09.2077"),
                PostEntity("","https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","title","","16.08 01.09.2077"),
                PostEntity("","https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","title","","16.08 01.09.2077"),
                PostEntity("","https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","title","","16.08 01.09.2077"),
                PostEntity("","https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","title","","16.08 01.09.2077"),
                PostEntity("","https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","title","","16.08 01.09.2077"),
                PostEntity("","https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","title","","16.08 01.09.2077"),
                PostEntity("","https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","title","","16.08 01.09.2077"),
                PostEntity("","https://images.unsplash.com/photo-1630518615523-0d82e3985c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80","title","","16.08 01.09.2077"),
        )
        adapterFriends.submitList(listFriends)
        adapterPosts.submitList(listPosts)
        adapterEvents.submitList(listEvents)
    }

}