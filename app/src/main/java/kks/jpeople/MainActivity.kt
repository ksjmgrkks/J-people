package kks.jpeople

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceControl
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kks.jpeople.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Android Jetpack Navigation 참고 링크 : https://namjackson.tistory.com/28

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*Navigation?
        네비게이션은 앱 내의 화면 이동 구현을 도와주는 AAC 라이브러리입니다.
        AAC 라이브러리는 기존에 없었던 기능이 아니라, 개발자들이 구현하기 쉽게 도와주는 컴포넌트라고 생각하면됩니다.
        -Fragment 트랜잭션을 관리
        -Up, Back 버튼의 작업 등(백스택 관리)을 간단하게 처리
        -화면 전환시, Animation 이나 Transition 을 위한 표준화된 리소스를 제공
        -딥링크 구현 및 처리
        -Navigation UI 패턴을 사용한 Navigation drawers, Bottom Navigation 의 연동을 쉽게 구현 가능하게 지원
        -fragment 간의 이동시 안전하게 데이터를 전달 가능
        -Navigation Editor 를 통해 화면흐름을 시각적으로 관리 가능
        -기본 FragmentManager, Intent , Bundle 등의 사용을 대체 가능
        */

        /*프래그먼트 트랜잭션 (Fragment Transaction)
        트랜잭션(Transaction) 이란, 어떤 대상에 대해 추가, 제거, 변경 등의 작업들이 발생하는것을 묶어서 얘기하는 것입니다.
        프래그먼트 매니저는 액티비티가 사용자의 입력 이벤트에 따라 프래그먼트를 추가 및 삭제 그리고 교체 등의 작업들을 수행 할 수 있게 해줍니다.
        뿐만아니라 행해진 트랜잭션의 상태를 프래그먼트 백스택(Fragment Backstack) 을 통해 저장할 수 있습니다.

        프래그먼트 트랜잭션의 사전적 정의는 '프래그먼트를 추가, 삭제 및 교체를 할 수 있다.' 지만 실제 안드로이드 내의 프래그먼트 트랜잭션은
        '프래그먼트 백 스택관리', '프래그먼트 전환 애니메이션 설정' 등 생각보다 더 많은 일들을 수행 할 수 있습니다.*/

        val navView: BottomNavigationView = binding.navView

        /*findNavController란?
        Navigation에서의 이동은 NavController 를 이용해서 이루어집니다.
        NavController는
        프래그먼트에서는 findNavController 를 통해서,
        View에서는 Navigation.findNavController(view) 를 통해서 가져올 수 있습니다.*/

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // 각 메뉴를 최상위 대상으로 간주해야 하므로 각 메뉴 ID를 ID 집합으로 전달합니다.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_community, R.id.navigation_qrcode
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}