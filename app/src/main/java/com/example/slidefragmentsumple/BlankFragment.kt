package com.example.slidefragmentsumple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

inline fun FragmentActivity.setContentFragment(
    containerViewId: Int,
    backStack: Boolean = false,
    isAnimate: Boolean = false,
    f: () -> Fragment
): Fragment? {
    val manager = supportFragmentManager
    return f().apply {
        manager.beginTransaction().let {
            if (isAnimate) it.setCustomAnimations(R.anim.slid_in_botm, R.anim.slide_out_botm)

            val rep = it.replace(containerViewId, this, "Fr")

            if (backStack) rep.addToBackStack("Fr").commit() else rep.commit()
        }
    }
}

class BlankFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_blank, container, false)


}
