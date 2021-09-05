package danyil.karabinovskyi.studentproject.ui.posts

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import danyil.karabinovskyi.studentproject.ui.entrance.EntranceFragment
import danyil.karabinovskyi.studentproject.ui.login.LoginFragment
import danyil.karabinovskyi.studentproject.ui.posts.viewpager_fragments.all_posts.AllPostsFragment
import danyil.karabinovskyi.studentproject.ui.registration.RegistrationFragment


class PostsViewPagerAdapter(activity: FragmentActivity) :
        FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllPostsFragment()
            1 -> AllPostsFragment()
            else -> AllPostsFragment()
        }
    }

    override fun getItemCount(): Int {
        return 3
    }


}