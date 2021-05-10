package toriz7.com.github.AndroidExercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import toriz7.com.github.AndroidExercise2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //인터넷 권한은 확인 받을 필요 없으며, 여기서는 확인 필요한(디폴트로 거부된) 권한만 검토한다.
    val permison_list= arrayOf( // Manifest 는 안드로이드 것 선택
        android.Manifest.permission.INTERNET,
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION,
        android.Manifest.permission.READ_CONTACTS,
        android.Manifest.permission.WRITE_CONTACTS,
        android.Manifest.permission.READ_EXTERNAL_STORAGE,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
    )
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        var view=binding.root // ? 흠
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(view)
        binding.textView.text=""


        /* 권한
        for(permission in permison_list){
            val chk=checkCallingOrSelfPermission(permission) //함수 기억할 것
            if(chk == PackageManager.PERMISSION_GRANTED){
                binding.textView.append("$permission : granted\n")
            }
            else if (chk==PackageManager.PERMISSION_DENIED){
                binding.textView.append("$permission : denied\n")
            }
        }

        binding.button.setOnClickListener{
            //거부되어 있는 권한들을 사용자에게 확인
            requestPermissions(permison_list,0)
        }

         */
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //XML 로 메뉴를 구성
        //menuInflater.inflate(R.menu.main_menu,menu)

        //코드로 구성
        val sub=menu?.addSubMenu("코드메뉴1")
        sub?.add(Menu.NONE,Menu.FIRST+10,Menu.NONE,"코드 메뉴1_1")
        sub?.add(Menu.NONE,Menu.FIRST+11,Menu.NONE,"코드 메뉴1_2")

        menu?.add(Menu.NONE,Menu.FIRST+1,Menu.NONE,"코드 메뉴2")
        menu?.add(Menu.NONE,Menu.FIRST+2,Menu.NONE,"코드 메뉴3")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //메뉴 선택  xml 로
        when(item.itemId){
            R.id.item1->{
                binding.textView.text="메뉴1을 눌렀습니다."
            }
            R.id.item2->{
                binding.textView.text="메뉴2을 눌렀습니다."
            }
            R.id.item3->{
                binding.textView.text="메뉴3을 눌렀습니다."
            }
            R.id.item1->{
                binding.textView.text="메뉴1_1을 눌렀습니다."
            }
            R.id.item1_2->{
                binding.textView.text="메뉴1_2을 눌렀습니다."
            }
        }

        when(item.itemId){
            Menu.FIRST ->{
                binding.textView.text="코드 메뉴1을 눌렀습니다."
            }
            Menu.FIRST+10 ->{
                binding.textView.text="코드 메뉴1_1을 눌렀습니다."
            }
            Menu.FIRST+11 ->{
                binding.textView.text="코드 메뉴1_2을 눌렀습니다."
            }
            Menu.FIRST+1 ->{
                binding.textView.text="코드 메뉴2을 눌렀습니다."
            }
            Menu.FIRST+2 ->{
                binding.textView.text="코드 메뉴3을 눌렀습니다."
            }

        }
        return super.onOptionsItemSelected(item)
    }
     /*권한
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        binding.textView.text=""
        for(idx in grantResults.indices){  //indices 검색
            if(grantResults[idx]==PackageManager.PERMISSION_GRANTED){
                binding.textView.append("${permissions[idx]}: 허용\n")
            }
            else{
                binding.textView.append("${permissions[idx]}: 거부\n")
            }
        }
    }

     */
}