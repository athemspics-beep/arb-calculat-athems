
package com.athems.arbcalculat

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*

class MainActivity : Activity() {

    private val bg = Color.rgb(18, 18, 18)
    private val panel = Color.rgb(32, 32, 32)
    private val green = Color.rgb(0, 220, 130)
    private val white = Color.WHITE

    private lateinit var odds1: EditText
    private lateinit var odds2: EditText
    private lateinit var odds3: EditText
    private lateinit var stake: EditText
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val page = LinearLayout(this)
        page.orientation = LinearLayout.VERTICAL
        page.setPadding(22, 24, 22, 24)
        page.setBackgroundColor(bg)

        val scroll = ScrollView(this)
        scroll.addView(page)

        val title = text("ARB CALCULAT ATHEMS", 25f, green)
        title.gravity = Gravity.CENTER
        page.addView(title)

        val subtitle = text("3-ODDS ARBITRAGE CALCULATOR", 14f, white)
        subtitle.gravity = Gravity.CENTER
        page.addView(subtitle)

        page.addView(space(20))

        odds1 = field("Odds 1 — mfano 2.10")
        odds2 = field("Odds 2 — mfano 3.50")
        odds3 = field("Odds 3 — mfano 4.00")
        stake = field("Jumla ya pesa — mfano 10000")

        page.addView(label("ODDS 1"))
        page.addView(odds1)
        page.addView(label("ODDS 2"))
        page.addView(odds2)
        page.addView(label("ODDS 3"))
        page.addView(odds3)
        page.addView(label("JUMLA YA PESA (TSh)"))
        page.addView(stake)

        val calculate = Button(this)
        calculate.text = "HESABU FAIDA"
        calculate.setTextColor(Color.BLACK)
        calculate.setBackgroundColor(green)
        page.addView(calculate)

        result = text("Ingiza odds zako kisha bonyeza HESABU FAIDA.", 17f, white)
        result.setPadding(14, 20, 14, 20)
        result.setBackgroundColor(panel)
        page.addView(result)

        calculate.setOnClickListener {
            calculateArbitrage()
        }

        setContentView(scroll)
    }

    private fun calculateArbitrage() {
        val o1 = odds1.text.toString().toDoubleOrNull()
        val o2 = odds2.text.toString().toDoubleOrNull()
        val o3 = odds3.text.toString().toDoubleOrNull()
        val total = stake.text.toString().toDoubleOrNull()

        if (o1 == null || o2 == null || o3 == null ||
            total == null || o1 <= 1 || o2 <= 1 ||
            o3 <= 1 || total <= 0
        ) {
            result.text = "Tafadhali weka odds zaidi ya 1 na kiasi cha pesa sahihi."
            return
        }

        val sum = 1.0 / o1 + 1.0 / o2 + 1.0 / o3
        val s1 = total * (1.0 / o1) / sum
        val s2 = total * (1.0 / o2) / sum
        val s3 = total * (1.0 / o3) / sum
        val payout = total / sum
        val profit = payout - total
        val roi = (profit / total) * 100.0

        val message = if (sum < 1.0) {
            "ARBITRAGE INAWEZEKANA\n\n"
        } else {
            "HAKUNA ARBITRAGE YA FAIDA KWA ODDS HIZI\n\n"
        }

        result.text = message +
            "Jumla ya odds inverse: ${fmt(sum * 100)}%\n" +
            "Weka kwenye Odds 1: TSh ${fmt(s1)}\n" +
            "Weka kwenye Odds 2: TSh ${fmt(s2)}\n" +
            "Weka kwenye Odds 3: TSh ${fmt(s3)}\n\n" +
            "Malipo yanayokadiriwa: TSh ${fmt(payout)}\n" +
            "Faida/Hasara inayokadiriwa: TSh ${fmt(profit)}\n" +
            "ROI: ${fmt(roi)}%"
    }

    private fun fmt(value: Double): String =
        String.format(java.util.Locale.US, "%,.2f", value)

    private fun field(hintText: String): EditText {
        val input = EditText(this)
        input.hint = hintText
        input.setHintTextColor(Color.LTGRAY)
        input.setTextColor(white)
        input.textSize = 16f
        input.inputType = 8194
        input.setSingleLine(true)
        input.setPadding(14, 8, 14, 8)
        input.setBackgroundColor(panel)

        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, 58
        )
        params.setMargins(0, 4, 0, 12)
        input.layoutParams = params
        return input
    }

    private fun label(value: String): TextView =
        text(value, 13f, green)

    private fun text(
        value: String,
        size: Float,
        color: Int
    ): TextView {
        val view = TextView(this)
        view.text = value
        view.textSize = size
        view.setTextColor(color)
        view.setPadding(4, 8, 4, 8)
        return view
    }

    private fun space(height: Int): TextView {
        val view = TextView(this)
        view.height = height
        return view
    }
}
