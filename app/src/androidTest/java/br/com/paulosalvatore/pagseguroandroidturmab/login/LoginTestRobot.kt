package br.com.paulosalvatore.pagseguroandroidturmab.login

import android.content.Context
import br.com.paulosalvatore.pagseguroandroidturmab.R
import br.com.paulosalvatore.pagseguroandroidturmab.robot.BaseTestRobot

class LoginTestRobot(private val context: Context) : BaseTestRobot() {
    fun setEmail(email: String) = apply {
        fillEditText(R.id.etEmail, email)
    }

    fun setPassword(pass: String) = apply {
        fillEditText(R.id.etPassword, pass)
    }

    fun clickLogin() = apply {
        clickButton(R.id.btLogin)
    }

    fun matchErrorText(err: Int) = matchText(
        textView(android.R.id.message),
        context.getString(err)
    )
}
