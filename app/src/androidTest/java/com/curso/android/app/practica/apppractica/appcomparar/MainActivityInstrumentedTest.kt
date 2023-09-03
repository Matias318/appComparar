
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.curso.android.app.practica.apppractica.appcomparar.view.MainActivity
import com.curso.android.app.practica.apppractica.appcomparar.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun realizarComparacionCuandoSonIguales() {
        // Ingresa texto igual en ambas EditText
        Espresso.onView(ViewMatchers.withId(R.id.editTextA))
            .perform(ViewActions.typeText("Hola"))

        Espresso.onView(ViewMatchers.withId(R.id.editTextB))
            .perform(ViewActions.typeText("Hola"))

        // Haz clic en el botón de comparación
        Espresso.onView(ViewMatchers.withId(R.id.botonComparacion))
            .perform(ViewActions.click())

        // Verifica que el TextView muestre "ES IGUAL"
        Espresso.onView(ViewMatchers.withId(R.id.textViewResultado))
            .check(ViewAssertions.matches(ViewMatchers.withText("Texto(textoF=ES IGUAL)")))
    }
}
