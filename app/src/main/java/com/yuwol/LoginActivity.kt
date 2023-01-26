package com.yuwol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.set
import androidx.core.text.toSpannable
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import com.yuwol.api.LoginServiceCreator
import com.yuwol.data.request.RequestLoginData
import com.yuwol.data.response.ResponseLoginData
import com.yuwol.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityLoginBinding
    val TAG = "kakao"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val keyHash = Utility.getKeyHash(this)
        Log.d("Hash", keyHash)

        setTitleGradient(binding.TextView.text.toString(), binding.TextView)

        binding.ivLoginSignInKakao.setOnClickListener {
            val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null) {
                    Log.e(TAG, "카카오계정으로 로그인 실패", error)
                } else if (token != null) {
                    Log.i(TAG, "카카오계정으로 로그인 성공 ${token.accessToken}")
                    SucceedKakaoLogin()
                }
            }

            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
                UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                    if (error != null) {
                        Log.e(TAG, "카카오톡으로 로그인 실패", error)
                        if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                            return@loginWithKakaoTalk
                        }
                        UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
                    } else if (token != null) {
                        Log.i(TAG, "카카오톡으로 로그인 성공 ${token.accessToken}")
                        SucceedKakaoLogin()
                    }
                }
            } else {
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
        }
    }

    fun SucceedKakaoLogin() {
        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Log.e(TAG, "사용자 정보 요청 실패", error)
            }
            else if (user != null) {
                Log.i(TAG, "사용자 정보 요청 성공" +
                        "\n회원번호: ${user.id}" +
                        "\n이메일: ${user.kakaoAccount?.email}" +
                        "\n닉네임: ${user.kakaoAccount?.profile?.nickname}" +
                        "\n프로필사진: ${user.kakaoAccount?.profile?.thumbnailImageUrl}")
                val requestLoginData = RequestLoginData("${user.id}_kakao")
                val call: Call<ResponseLoginData> = LoginServiceCreator.loginService.postLogin(requestLoginData)
                call.enqueue(object : Callback<ResponseLoginData> {
                    override fun onResponse(
                        call: Call<ResponseLoginData>,
                        response: Response<ResponseLoginData>
                    ) {
                        if (response.isSuccessful) {
                            Log.d(TAG, "kakao login onResponse: success")
                            Log.d(TAG, "data value: ${requestLoginData}")
                            val data = response.body()?.accessToken
                            Log.d(TAG, "response value - token: ${data.toString()}")
                            // 로그인 성공
                            val isFirst = response.body()?.isFirst
                            Log.d(TAG, "response value - isFirst: ${isFirst.toString()}")
                            if (isFirst != null) {
                                val intent: Intent
                                if (isFirst == true) {
                                    intent = Intent(this@LoginActivity, SignUpActivity::class.java)
                                } else {
                                    intent = Intent(this@LoginActivity, MainActivity::class.java)
                                }
                                intent.putExtra("token", data.toString())
                                startActivity(intent)
                                finish()
                            } else {
                                // 로그인 실패
                            }
                        } else {
                            // 에러 발생
                        }
                    }
                    // 네트워크 통신 실패
                    override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                        Log.d(TAG, "network error!")
                    }
                })
            }
        }


    }

    private fun setTitleGradient(text: String, tv: TextView) {
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, ContextCompat.getColor(this, R.color.pink_100), ContextCompat.getColor(this, R.color.purple_100))
        tv.text = spannable
    }
}