package danyil.karabinovskyi.studentproject.ui.posts

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.codeboy.pager2_transformers.Pager2_CubeOutScalingTransformer
import dagger.hilt.android.AndroidEntryPoint
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseStateFragment
import danyil.karabinovskyi.studentproject.databinding.FragmentPostsBinding
import danyil.karabinovskyi.studentproject.utils.setOnClickWithDebounce

@AndroidEntryPoint
class PostsFragment : BaseStateFragment<FragmentPostsBinding>() {

    override val layoutId = R.layout.fragment_posts

    var def: ColorStateList? = null
    lateinit var item1: TextView
    lateinit var item2: TextView
    lateinit var item3: TextView
    var select: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI(){

        val adapter = PostsViewPagerAdapter(requireActivity())

        binding.viewPager.adapter = adapter
        val transformation:ViewPager2.PageTransformer = Pager2_CubeOutScalingTransformer()
        binding.viewPager.setPageTransformer(transformation)

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        item1.performClick()
                    }
                    1 -> {
                        item2.performClick()
                    }
                    2 -> {
                        item3.performClick()
                    }
                }
            }
        })

        item1 = binding.customTab.item1
        item2 = binding.customTab.item2
        item3 = binding.customTab.item3
        select = binding.customTab.select
        def = item2.textColors

        binding.customTab.item1.setOnClickWithDebounce {
            select!!.animate().x(12f).duration = 100
            item1.setTextColor(Color.WHITE)
            item2.setTextColor(def)
            item3.setTextColor(def)
            binding.viewPager.setCurrentItem(0, false)
        }

        binding.customTab.item2.setOnClickWithDebounce {
            item1.setTextColor(def)
            item2.setTextColor(Color.WHITE)
            item3.setTextColor(def)
            val size = item2.width
            select!!.animate().x(size.toFloat()).duration = 100
            binding.viewPager.setCurrentItem(1, false)
        }
        binding.customTab.item3.setOnClickWithDebounce {
            item1.setTextColor(def)
            item3.setTextColor(Color.WHITE)
            item2.setTextColor(def)
            val size = item2.width * 2
            select!!.animate().x(size.toFloat()).duration = 100
            binding.viewPager.setCurrentItem(2, false)
        }
    }
}