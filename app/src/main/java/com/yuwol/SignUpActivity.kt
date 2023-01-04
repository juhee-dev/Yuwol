package com.yuwol

import android.app.Activity
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import com.github.dhaval2404.imagepicker.ImagePicker
import com.yuwol.databinding.ActivitySignUpBinding
import com.yuwol.fragment.HomeFragment
import java.io.ByteArrayOutputStream
import java.io.InputStream

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUpProfile.setColorFilter(Color.WHITE)
        binding.btnSignUpProfile.setOnClickListener {
            ImagePicker.with(this).galleryOnly().galleryMimeTypes(arrayOf("image/*")).crop(1f, 1f).compress(1024)
                .maxResultSize(400, 400).start()
        }

        binding.btnSignUpSubmit.setOnClickListener {
            val intent = Intent(this@SignUpActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ImagePicker.REQUEST_CODE && resultCode == Activity.RESULT_OK){
            var currentImageURL = data?.data
            // Base64 인코딩부분
            val ins: InputStream? = currentImageURL?.let {
                applicationContext.contentResolver.openInputStream(
                    it
                )
            }
            val img: Bitmap = BitmapFactory.decodeStream(ins)
            ins?.close()
            val resized = Bitmap.createScaledBitmap(img, 256, 256, true)
            val byteArrayOutputStream = ByteArrayOutputStream()
            resized.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream)
            val byteArray: ByteArray = byteArrayOutputStream.toByteArray()
            val outStream = ByteArrayOutputStream()
            val res: Resources = resources
            var profileImageBase64 = Base64.encodeToString(byteArray, Base64.NO_WRAP)
            Log.d("TestLog", "Image: ${profileImageBase64.toString()}")

            binding.ivSignUpProfile?.setImageURI(currentImageURL)
            try {
                //이미지 선택 후 처리
            }catch (e: Exception){
                e.printStackTrace()
            }
        } else{
            Log.d("ActivityResult", "something wrong")
        }

    }
}