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

    /** Android Jetpack Navigation 내용 참고 링크 : https://namjackson.tistory.com/28*/

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**Navigation?
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

        /**프래그먼트 트랜잭션 (Fragment Transaction)
        트랜잭션(Transaction) 이란, 어떤 대상에 대해 추가, 제거, 변경 등의 작업들이 발생하는것을 묶어서 얘기하는 것입니다.
        프래그먼트 매니저는 액티비티가 사용자의 입력 이벤트에 따라 프래그먼트를 추가 및 삭제 그리고 교체 등의 작업들을 수행 할 수 있게 해줍니다.
        뿐만아니라 행해진 트랜잭션의 상태를 프래그먼트 백스택(Fragment Backstack) 을 통해 저장할 수 있습니다.

        프래그먼트 트랜잭션의 사전적 정의는 '프래그먼트를 추가, 삭제 및 교체를 할 수 있다.' 지만 실제 안드로이드 내의 프래그먼트 트랜잭션은
        '프래그먼트 백 스택관리', '프래그먼트 전환 애니메이션 설정' 등 생각보다 더 많은 일들을 수행 할 수 있습니다.*/

/**        Navigation 의 구성요소는 3가지입니다.
         - Navigation Graph
         - NavHost
         - NavController*/

/**       1. Navigation Graph
         Navigation Graph 는 res/navigation/ 폴더에 추가한 xml 파일입니다.
         화면 이동에 대한 모든 정보 (Action, 파라미터, 화면단위(fragment, Activity, Dialog 등)) 를 정의하는 곳입니다.
         <사용 가능한 태그>
         - <navigation> : NavGraph 의 기본 태그
         - <fragment> or <Activity> or <Dialog>등의 Destination : Destination 은 목적지가 되는 하나의 화면입니다. 그래프에서는 하나의 화면으로 구분됩니다.
         - <action> : 화면간의 이동을 정의하는 태그이며 화면 이동에 대한 액션을 정의할 수 있습니다. 그래프에서는 화살표로 표현됩니다.
         - <argument> : 화면 이동에 대한 파라미터를 정의합니다.
         - <deeplink> : 딥링크에 대한 내용을 정의합니다.*/

/**      2. NavHost
        NavHost 는 NavGraph 에 정의된 화면들을 보여주는 컨테이너의 역할을 합니다.
        화면이동에 대한 액션은 모두 NavHost 라는 Fragment 에게 위임됩니다.
        일반 Fragment 의 Name 에 NavHostFragment 를 정의해주어야하고,
        연결되는 navGraph 또한 정의해주어야합니다.
        (activity_maim.xml 파일 참고)*/

/**      3. NavController
        NavController 는 화면이동에 대한 컨트롤러 역할을 합니다.
        NavController 는 NavHost 에서 얻을 수 있습니다.
        NavController 는 아래처럼 여러 방법으로 가져올 수 있습니다.
            <!--navController fragment,activity,view 에서 find -->
            val navController = findNavController()

            <!--navController NavHost id로 가져오기 -->
            val navController = findNavController(R.id.nav_container)

            <!--navController - NavHost 에서 가져오기 -->
            val host: NavHostFragment = supportFragmentManager
                .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment? ?: return
            val navController = host.navController

         아래와 같이 navController 를 사용하여 간단하게 화면 전환이 가능합니다.
         <!--NavGraph(xml)에 정의된 R.id.flow_step_one_dest 에 해당하는 action 이 진행됩니다.-->

         findNavController().navigate(R.id.flow_step_one_dest)

        <!--
          NavGraph 에 정의된 Action(R.id.next_action)을 사용합니다.
          HomeFragmentDirections 은 intent 개념으로 이해하면됩니다.
          NavGraph(xml)에 action 을 정의하면 tool 내에서 자동으로 해당 클래스를 생성해즙니다.
        -->

        findNavController().navigate(HomeFragmentDirections.nextAction(1))

        <!--NavGraph 에 정의된 Action(R.id.next_action)으로 Listener 를 반환한다. -->

        Navigation.createNavigateOnClickListener(R.id.next_action, null)
            */




        val navView: BottomNavigationView = binding.navView

        /**findNavController 란?
        Navigation 에서의 이동은 NavController 를 이용해서 이루어집니다.
        NavController 는
        프래그먼트에서는 findNavController 를 통해서,
        View 에서는 Navigation.findNavController(view) 를 통해서 가져올 수 있습니다.*/

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
/**      각 메뉴를 top level destination 으로 간주해야 하므로 각 메뉴 ID를 ID 집합으로 전달합니다.
         AppBarConfiguration 안의 id는 top level destination 을 지정하는 것인데,
         top level 로 지정된 화면(destination) 의 상단 액션바에는 up button(←) 즉 뒤로가기 버튼이 생기지
         않습니다. 즉 top level destination 으로 지정된 화면은 앱이 꺼지기 전 최종 화면으로 생각하면 됩니다.*/
        val appBarConfiguration = AppBarConfiguration(
            setOf(
/**             setOf란?
                Set 은 정해진 순서가 없는 요소들의 집합을 나타내는 컬렉션입니다. 동일한 요소를 중복해서 가질 수 없습니다.
                코틀린 컬렉션 : https://codechacha.com/ko/collections-in-kotlin/
                자바 컬렉션 : http://www.tcpschool.com/java/java_collectionFramework_concept*/
                R.id.navigation_home, R.id.navigation_community, R.id.navigation_qrcode
            )
        )
         /** setupActionBarWithNavController 메서드를 사용하면, 탭이 클릭될 때마다 액션바의 제목이 변경됩니다.*/
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}