package kks.jpeople.ui.community
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommunityViewModel : ViewModel() {
/*    ## ViewModel 이란?
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
/*       public class UserActivity extends Activity {

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

/*    ViewModels 는 하나의 Activity 안에 있는 여러 다른 Fragment 들 간의
    통신 계층(communication layer)으로 사용될 수도 있습니다.
    각 Fragment 는 Activity 를 통해 동일한 키를 사용하여 ViewModel 을 획득할 수 있습니다.
    이렇게 하면 Fragments 간의 통신이 디커플 방식으로 이루어지므로
    다른 Fragment 와 직접 통신할 필요가 없습니다. (fragment 간의 의존성이 약해짐)*/

/*   public class MyFragment extends Fragment {
       public void onStart() {
           UserModel userModel = new ViewModelProvider(requireActivity()).get(UserModel.class);
       }
   }*/

    //공부해야 할 리스트 : LiveData<T>, MutableLiveData<T>
    //kotlin let, with, run, apply, also 차이 비교 정리 : https://blog.yena.io/studynote/2020/04/15/Kotlin-Scope-Functions.html
    //apply 는 값을 할당하는 함수라고 생각하자. 밑은 사용 예시다.
/*  val person = Person("", 0)
    val result = person.apply {
        name = "James"
        age = 56
    }
    println("$person")
    //Person(name=James, age=56)*/

    /**
     * LiveData 란?
     *LiveData is a data holder class that can be observed within a given lifecycle. This means that an Observer can be added in a pair with a LifecycleOwner, and this observer will be notified about modifications of the wrapped data only if the paired LifecycleOwner is in active state. LifecycleOwner is considered as active, if its state is Lifecycle.State.STARTED or Lifecycle.State.RESUMED. An observer added via observeForever(Observer) is considered as always active and thus will be always notified about modifications. For those observers, you should manually call removeObserver(Observer).
    An observer added with a Lifecycle will be automatically removed if the corresponding Lifecycle moves to Lifecycle.State.DESTROYED state. This is especially useful for activities and fragments where they can safely observe LiveData and not worry about leaks: they will be instantly unsubscribed when they are destroyed.
    In addition, LiveData has onActive() and onInactive() methods to get notified when number of active Observers change between 0 and 1. This allows LiveData to release any heavy resources when it does not have any Observers that are actively observing.
    This class is designed to hold individual data fields of ViewModel, but can also be used for sharing data between different modules in your application in a decoupled fashion.
     */

    /**
     * MutableLiveData 란?
     * LiveData which publicly exposes setValue(T) and postValue(T) method.
    Type parameters:
    <T> – The type of data hold by this instance
     */

    //MutableLiveData 란? LiveData 와의 차이?
    //

    private val _text = MutableLiveData<String>().apply {
        value = "순모임 프래그먼트입니다."
    }
    val text: LiveData<String> = _text
}