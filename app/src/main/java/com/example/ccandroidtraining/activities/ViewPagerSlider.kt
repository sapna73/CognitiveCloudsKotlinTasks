package com.example.ccandroidtraining.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.ccandroidtraining.R

class ViewPagerSlider : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_slider)

//        var toolbar = findViewById<Toolbar>(R.id.toolBarViewPager)
        var viewPager1 = findViewById<ViewPager>(R.id.viewPager)
//        var textViewView2 = findViewById<TextView>(R.id.descriptionTv)

//        toolbar.title = "Slider"
//        toolbar.subtitle = "Slide left/right to change..."
//        setSupportActionBar(toolbar)

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        viewPager1.adapter = mSectionsPagerAdapter

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.bottom_nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1)
        }

        override fun getCount(): Int {
            // Show 5 total pages.(we will use 5 pages so change it to 5)
            return 5
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val rootView = inflater.inflate(R.layout.items_view_pager_slides, container, false)

            val titletext = rootView.findViewById<TextView>(R.id.titleTv)
            val imageView = rootView.findViewById<ImageView>(R.id.vpImg1)
            val textView1 = rootView.findViewById<TextView>(R.id.descriptionTv)
            when(arguments?.getInt(ARG_SECTION_NUMBER)){
                1->{
                    titletext.text = "I'm Monkey"
                    imageView.setImageResource(R.drawable.vp_image1)
                    textView1.text = "Jump everywhere"
                }
                2->{
                    titletext.text = "I'm Eagle"
                    imageView.setImageResource(R.drawable.vp_image2)
                    textView1.text = "Fly high"
                }
                3->{
                    titletext.text = "I'm Dinosaur"
                    imageView.setImageResource(R.drawable.vp_image3)
                    textView1.text = "Forset Friends "
                }
                4->{
                    titletext.text = "I'm Panda"
                    imageView.setImageResource(R.drawable.vp_image4)
                    textView1.text = "Lazy"
                }
            }
            return rootView
        }

        companion object {

            private val ARG_SECTION_NUMBER = "section_number"

            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }
}