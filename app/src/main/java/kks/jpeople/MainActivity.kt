package kks.jpeople

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kks.jpeople.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
/*    공부할 땐 코드를 한줄한줄 이해하기 전까진 기능구현을 멈추자 이해없는 코딩을 하게되면
      코드몽키가 될 뿐이다. 테스트 테스트*/

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

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