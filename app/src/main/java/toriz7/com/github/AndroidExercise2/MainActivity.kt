package toriz7.com.github.AndroidExercise2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import toriz7.com.github.AndroidExercise2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //인터넷 권한은 확인 받을 필요 없으며, 여기서는 확인 필요한(디폴트로 거부된) 권한만 검토한다.
    val SECOND_ACTIVITY=100
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        var view=binding.root // ? 흠
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(view)
        binding.textView.text=""
        binding.button.setOnClickListener{
            val second_intent= Intent(this,SecondActivity::class.java)
            //startActivity(second_intent)
            startActivityForResult(second_intent,100) //액티비티 코드
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            SECOND_ACTIVITY ->{
                binding.textView.text="SecondActivity 에서 돌아왔습니다"
            }
        }
    }
}