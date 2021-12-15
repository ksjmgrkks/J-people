package kks.jpeople.ui.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kks.jpeople.databinding.FragmentCommunityBinding

class CommunityFragment : Fragment() {

    private lateinit var communityViewModel: CommunityViewModel
    private var _binding: FragmentCommunityBinding? = null

/**     binding 객체는 onCreateView와 onDestroyView 사이에서만 사용할 수 있습니다.
     kotlin !!, ? 의 의미 : https://taetoungs-branch.tistory.com/73*/
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //공부해야할 리스트 정리 :  observe, it, viewLifecycleOwner
/**      ViewModelProvider 란?
         Activity 나 Fragment 에 ViewModel 을 제공하는 유틸리티 클래스입니다.
         Activity 나 Fragment 에 대한 기본 ViewModelProvider 를 생성자에게 전달하여 얻을 수 있습니다.*/

/**        :: -> 리플렉션
         링크 : https://medium.com/harrythegreat/%EC%BD%94%ED%8B%80%EB%A6%B0%EC%9D%98-%EB%8D%94%EB%B8%94%EC%BD%9C%EB%A1%A0-%EC%B0%B8%EC%A1%B0-73ff25484586
         코틀린 ::class.java 와 리플렉션(Reflection)
         링크 : https://yoon-dailylife.tistory.com/46*/

        //kotlin it
        //

        //viewLifecycleOwner

        //binding.root -> fragment_community.xml 을 의미함
        communityViewModel =
            ViewModelProvider(this)[CommunityViewModel::class.java]

        _binding = FragmentCommunityBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCommunity
        communityViewModel.text.observe(viewLifecycleOwner, Observer {

            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}