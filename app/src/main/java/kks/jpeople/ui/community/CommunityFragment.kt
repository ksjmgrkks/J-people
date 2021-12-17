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
/**      ViewModelProvider 란?
         Activity 나 Fragment 에 ViewModel 을 제공하는 유틸리티 클래스입니다.
         Activity 나 Fragment 에 대한 기본 ViewModelProvider 를 생성자에게 전달하여 얻을 수 있습니다.*/

/**        :: -> 리플렉션
         링크 : https://medium.com/harrythegreat/%EC%BD%94%ED%8B%80%EB%A6%B0%EC%9D%98-%EB%8D%94%EB%B8%94%EC%BD%9C%EB%A1%A0-%EC%B0%B8%EC%A1%B0-73ff25484586
         코틀린 ::class.java 와 리플렉션(Reflection)
         링크 : https://yoon-dailylife.tistory.com/46*/

        /**
         * viewLifecycleOwner == getViewLifecycleOwner()
         * LifecycleOwner 는 프래그먼트의 View 라이프사이클을 의미합니다.
        대부분의 경우 이는 프래그먼트 자체의 라이프사이클을 반영하지만,
        분리된(detached) 프래그먼트의 경우 프래그먼트의 라이프사이클이 View 자체의 라이프사이클보다 상당히 길 수 있습니다.

        즉, 프래그먼트의 View 의 라이프사이클은 다음과 같습니다.

        onViewStateRestored(Bundle) 후에 created 되고,
        onStart() 후에 started 되고,
        onResume() 후에 resumed 되고,
        onPause()  전에 paused 되고,
        onStop() 전에 stopped 되고,
        onDestroyView() 전에 destroyed 됩니다.

        View lifecycle 에 안전하게 액세스할 수 있는 첫 번째 방법은
        Null 이 아닌 View 를 리턴 하는 조건 하에 onCreateView(LayoutInflater, ViewGroup, Bundle) 메서드에서 접근 할 수 있습니다.
        viewLifecycleOwner 메서드는 메인 스레드에서만 호출되어야 합니다.
         */

        communityViewModel =
            ViewModelProvider(this)[CommunityViewModel::class.java]

        _binding = FragmentCommunityBinding.inflate(inflater, container, false)

        /** binding.root -> fragment_community.xml 을 의미함 */
        val root: View = binding.root
        val textView: TextView = binding.textCommunity
        /**
         * 람다함수
         * 링크 : https://codechacha.com/ko/kotlin-lambda-expressions/
         */
        communityViewModel.text.observe(viewLifecycleOwner, Observer {
            /** kotlin it에 대하여
             * 출처 : https://tourspace.tistory.com/110
             * 인자가 하나일 때 람다식 내부에서 it 으로 치환이 가능함.
             * 즉, textString : String -> textView.text = textString 과 textView.text = it 은 같은 표현이다.
             */
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}