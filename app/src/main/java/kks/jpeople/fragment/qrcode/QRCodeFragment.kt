package kks.jpeople.fragment.qrcode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kks.jpeople.databinding.FragmentQrcodeBinding

class QRCodeFragment : Fragment() {

    private lateinit var qrcodeViewModel: QrcodeViewModel
    private var _binding: FragmentQrcodeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        qrcodeViewModel = ViewModelProvider(this)[QrcodeViewModel::class.java]

        _binding = FragmentQrcodeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textQrcode
        qrcodeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}