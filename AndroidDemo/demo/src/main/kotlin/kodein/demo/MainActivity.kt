package kodein.demo

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.appKodein
import com.github.salomonbrys.kodein.description
import com.github.salomonbrys.kodein.instance
import kodein.demo.coffee.Coffee
import kodein.demo.coffee.Kettle

class MainActivity : Activity(), KodeinInjected {

    override val injector = KodeinInjector()

    val coffeeMaker: Kettle<Coffee> by instance()
    val log: Logger by instance()

    val textView: TextView by lazy { findViewById(R.id.text) as TextView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inject(appKodein())

        setContentView(R.layout.activity_main)

        log.callback = {
            textView.text = log.text
        }

        Handler().postDelayed({
            coffeeMaker.brew()
        }, 3000)

        Handler().postDelayed({
            coffeeMaker.brew()
        }, 6000)

        Log.i("Kodein", "=====================-BINDINGS-=====================")
        Log.i("Kodein", appKodein().container.bindings.description)
        Log.i("Kodein", "=====================----------=====================")
    }

}
