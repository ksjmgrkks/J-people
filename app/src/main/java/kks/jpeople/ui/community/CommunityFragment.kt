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

    // binding 객체는 onCreateView와 onDestroyView 사이에서만 사용할 수 있습니다.
    // kotlin !!, ? 의 의미 : https://taetoungs-branch.tistory.com/73
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //공부해야할 리스트 정리 : ViewModel, ViewModelProvider, ::class.java, observe, Observer, it, viewLifecycleOwner, binding.root
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