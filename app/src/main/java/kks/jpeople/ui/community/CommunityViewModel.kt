package kks.jpeople.ui.community
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommunityViewModel : ViewModel() {
/**    ## ViewModel 이란?
    ViewModel 은 Activity 나 Fragment 데이터를 준비하고 관리하는 클래스입니다.
    또한 나머지 응용프로그램과의 통신 (예: 비즈니스 로직 클래스 호출)도 처리합니다.
    비즈니스 로직이란?
    데이터를 원하는 형태로 가공하는 눈에 보이지 않는 처리과정

    ViewModel 은 항상 스코프(Activity 또는 Fragment)와 관련하여 생성되며
    스코프가 활성 상태인 한 유지됩니다.

    ex) Activity 인 경우 완료될 때까지. 즉, 구성 변경(예: 회전)으로 인해
    ViewModel 소유자가 소멸되는 경우에도 ViewModel 이 소멸되지 않습니다.
    새로 생성된 인스턴스가 기존 모델에 다시 연결되는 것입니다.

    ViewModel 의 목적은 Activity 또는 Fragment 에서 필요한 정보를 획득하고 유지하는 것입니다.
    Activity 또는 Fragment 는 ViewModel 의 변화를 관찰할 수 있어야 합니다.
    ViewModels 는 일반적으로 LiveData 또는 Android Data Binding 을 통해 이 정보를 노출합니다.

    당신이 선호하는 프레임워크에서 observability construct(변화를 관찰할 수 있는 구조)를 사용할 수도 있습니다.
    ViewModel 의 유일한 역할은 UI에 대한 데이터를 관리하는 것입니다.
    View 계층에 액세스하거나 Activity 또는 Fragment 에 대한 참조를 보류해서는 안 됩니다.
    Activity 관점에서 일반적으로 사용되는 용도는 다음과 같습니다.*/

/**       public class UserActivity extends Activity {

            @Override
           protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
               setContentView(R.layout.user_activity_layout);
               final UserModel viewModel = new ViewModelProvider(this).get(UserModel.class);
               viewModel.getUser().observe(this, new Observer<User>() {
                    @Override
                   public void onChanged(@Nullable User data) {
                       // 여기서 UI를 업데이트합니다.
                   }
               });
               findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                    @Override
                   public void onClick(View v) {
                        viewModel.doAction();
                   }
               });
           }
       }

    ViewModel :
       public class UserModel extends ViewModel {
           private final MutableLiveData<User> userLiveData = new MutableLiveData<>();

           public LiveData<User> getUser() {
               return userLiveData;
           }

           public UserModel() {
           }

           void doAction() {
                // 여기서 작업에 따라 필요한 비즈니스 로직을 처리하고,
               // userLiveData 를 업데이트 합니다.
           }
       }*/

/**    ViewModels 는 하나의 Activity 안에 있는 여러 다른 Fragment 들 간의
    통신 계층(communication layer)으로 사용될 수도 있습니다.
    각 Fragment 는 Activity 를 통해 동일한 키를 사용하여 ViewModel 을 획득할 수 있습니다.
    이렇게 하면 Fragments 간의 통신이 디커플 방식으로 이루어지므로
    다른 Fragment 와 직접 통신할 필요가 없습니다. (fragment 간의 의존성이 약해짐)*/

/**   public class MyFragment extends Fragment {
       public void onStart() {
           UserModel userModel = new ViewModelProvider(requireActivity()).get(UserModel.class);
       }
   }
*/

/**    kotlin let, with, run, apply, also 차이 비교 정리 : https://blog.yena.io/studynote/2020/04/15/Kotlin-Scope-Functions.html
      apply 는 간단하게 말하면 값을 할당하는 함수입니다.

      <apply 함수 사용 예시>
      val person = Person("", 0)
        val result = person.apply {
            name = "James"
            age = 56
        }
        println("$person")
        //Person(name=James, age=56)*/

    /**
     * LiveData 란?
     * LiveData 는 주어진 라이프사이클 내에서 관찰할 수 있는 데이터 홀더 클래스입니다.
     * 즉, observer 를 LifecycleOwner 와 쌍으로 추가할 수 있으며,
     * 쌍으로 구성된 LifecycleOwner 가 활성 상태인 경우에만
     * 이 observer 에게 래핑된 데이터의 수정에 대한 알림이 표시됩니다.
     * LifecycleOwner 는 상태가 Lifecycle.State.STARTED 또는 Lifecycle.State.RESUMED 인 경우 활성으로 간주됩니다.
     * observeForever(Observer) 함수를 통해 추가된 observer 는 항상 활성 상태로 간주되어 수정 사항에 대해 항상 통지됩니다.
     * 이러한 observer 의 경우 removeObserver(Observer)를 수동으로 호출해야 합니다.
     * Lifecycle 과 함께 생성된 observer 는 해당 Lifecycle 이 Lifecycle.State.DESTROYED 상태로 변경되면 자동적으로 제거됩니다.
     * 이 기능은 LiveData 를 안전하게 관찰하고 누출을 걱정할 필요가 없는 액티비티 및 프래그먼트에서 특히 유용합니다.
     * 이러한 액티비티 및 프래그먼트는 삭제되면 즉시 관찰(observe)이 해제됩니다.
     * 또한 LiveData 에는 활성 observer 수가 0과 1 사이에서 변경될 때 알림을 받을 수 있는 onActive() 및 OnInactive() 메서드가 있습니다.
     * 이를 통해 LiveData 는 현재 관찰 중인 observer 가 없을 때 무거운 리소스를 해제할 수 있습니다.
     * '이 클래스는 ViewModel 의 개별 데이터 필드를 보유하도록 설계되었지만,'
     * 응용 프로그램의 서로 다른 모듈 간에 분리된 방식으로 데이터를 공유하는 데도 사용할 수 있습니다.
     */

    /**
     * MutableLiveData 란?
     * LiveData 는 변하지 않지만(immutable) MutableLiveData 는 변할 수 있습니다.
     * 즉 값이 변할 수 있는 LiveData 입니다.
     * MutableLiveData 는 LiveData 를 상속받고 setValue(T), postValue(T) 같은 메서드를 제공합니다.
     */

/**  MutableLiveData 란? LiveData 와의 차이?
     LiveData : 변경 불가능
     MutableLiveData : 변경 가능한 LiveData
     링크 : https://onlyfor-me-blog.tistory.com/310
           https://hoyadev.tistory.com/110
           https://comoi.io/300
 */

    private val _text = MutableLiveData<String>().apply {
        value = "버튼을 클릭해주세요."
    }

    fun clickButton() {
        _text.apply {
            value = "버튼을 클릭했습니다."
        }
    }

    val text: LiveData<String> = _text


}