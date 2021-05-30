package toriz7.com.github.AndroidExercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import toriz7.com.github.AndroidExercise2.databinding.ActivityMainBinding

class
MainActivity : AppCompatActivity() {
    //인터넷 권한은 확인 받을 필요 없으며, 여기서는 확인 필요한(디폴트로 거부된) 권한만 검토한다.

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        var view=binding.root // ? 흠
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(view)
        binding.textView.text=""
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        //길게 누른 view 의 id 로 분기한다.
        when(v?.id){
            R.id.textView -> {
                menu?.setHeaderTitle("1번")
                menuInflater.inflate(R.menu.menu1,menu)
            }
        }
    }
}