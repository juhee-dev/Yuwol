package com.yuwol.fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.text.set
import androidx.core.text.toSpannable
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import com.yuwol.LinearGradientSpan
import com.yuwol.R
import com.yuwol.api.UserInfoServiceCreator
import com.yuwol.data.response.ResponseLoginData
import com.yuwol.data.response.ResponseUserInfoData
import com.yuwol.databinding.FragmentMyLikesBinding
import com.yuwol.databinding.FragmentMyProfileBinding
import kotlinx.android.synthetic.main.fragment_my_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyProfileFragment : Fragment() {
    lateinit var binding: FragmentMyProfileBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnSignUpSubmit.setOnClickListener {

            Log.d("userinfo","myprofile")

            val call: Call<ResponseLoginData> =
            UserInfoServiceCreator.userInfoService.postLogin()

//            call.enqueue(object : Callback<ResponseUserInfoData>{
//                override fun onResponse(
//                    call: Call<ResponseUserInfoData>,
//                    response: Response<ResponseUserInfoData>
//                ) {
//                    if(response.isSuccessful){
//                        Log.d("Test","Success")
//                        val data = response.body().toString()
//                        Log.d("Responsevalue","response 값=>"+data)
//                        if(data=="ResponseUserInfoData Success"){
//
//                        }
//                    }
//                    else{
//                        //에러
//                    }
//                }
//
//                override fun onFailure(call: Call<ResponseUserInfoData>, t: Throwable) {
//                    Log.d("Test","error")
//                }
//            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyProfileBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitleGradient("프로필 수정", binding.tvMyProfileTitle)

        binding.ivMyProfileBack.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fl_main,UserFragment()).commit()
        }
    }

    private fun setTitleGradient(text: String, tv: TextView) {
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, ContextCompat.getColor(requireContext(), R.color.pink_100), ContextCompat.getColor(requireContext(), R.color.purple_100))
        tv.text = spannable
    }


}