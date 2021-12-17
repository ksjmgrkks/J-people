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
         * viewLifecycleOwner
         * Get a LifecycleOwner that represents the Fragment's View lifecycle. In most cases, this mirrors the lifecycle of the Fragment itself, but in cases of detached Fragments, the lifecycle of the Fragment can be considerably longer than the lifecycle of the View itself.
        Namely, the lifecycle of the Fragment's View is:
        created after onViewStateRestored(Bundle)
        started after onStart()
        resumed after onResume()
        paused before onPause()
        stopped before onStop()
        destroyed before onDestroyView()
        The first method where it is safe to access the view lifecycle is onCreateView(LayoutInflater, ViewGroup, Bundle) under the condition that you must return a non-null view (an IllegalStateException will be thrown if you access the view lifecycle but don't return a non-null view).
        The view lifecycle remains valid through the call to onDestroyView(), after which getView() will return null, the view lifecycle will be destroyed, and this method will throw an IllegalStateException. Consider using getViewLifecycleOwnerLiveData() or FragmentTransaction.runOnCommit(Runnable) to receive a callback for when the Fragment's view lifecycle is available.
        This should only be called on the main thread.
        Overriding this method is no longer supported and this method will be made final in a future version of Fragment.
        Returns:
        A LifecycleOwner that represents the Fragment's View lifecycle.
        Throws:
        IllegalStateException – if the Fragment's View is null.
         */
        communityViewModel =
            ViewModelProvider(this)[CommunityViewModel::class.java]

        _binding = FragmentCommunityBinding.inflate(inflater, container, false)

        /** binding.root -> fragment_community.xml 을 의미함 */
        val root: View = binding.root

        val textView: TextView = binding.textCommunity
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