package com.yuwol

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import com.github.dhaval2404.imagepicker.util.FileUriUtils
import com.yuwol.api.ProfileServiceCreator
import com.yuwol.databinding.ActivitySignUpBinding
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    val TAG = "signup"
    lateinit var username: String
    lateinit var body: MultipartBody.Part
    lateinit var introduce: String
    lateinit var imageUri: Uri
    lateinit var imageFile: File
    lateinit var imagePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUpProfile.setOnClickListener {
            ImagePicker.with(this).galleryOnly().galleryMimeTypes(arrayOf("image/*")).crop(1f, 1f).compress(1024)
                .maxResultSize(400, 400).start()
        }

        // TODO: get default image file
        val resources: Resources = this.resources
        imageUri = Uri.parse(
            ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + resources.getResourcePackageName(
                R.drawable.cover_note) + '/' + resources.getResourceTypeName(
                R.drawable.cover_note) + '/' + resources.getResourceEntryName(
                R.drawable.cover_note)
        )
        imagePath = FileUriUtils.getRealPath(this, imageUri).toString()

        binding.btnSignUpSubmit.setOnClickListener {
            username = binding.etSignUpName.text.toString()
            introduce = binding.etSignUpIntroduce.text.toString()
            Log.d(TAG, "User: name-${username}, introduce-${introduce}, image-${imagePath}")

            if (username != "" && introduce != "") {
                // 서버 통신
                imagePath = FileUriUtils.getRealPath(this, imageUri).toString()
                Log.d(TAG, "path of image: $imagePath")
                val reqFile: RequestBody = RequestBody.create(MediaType.parse("image/*"), imagePath)
                Log.d(TAG, "reqFile: $reqFile")
                body = MultipartBody.Part.createFormData(
                    "image",
                    imageFile.name, reqFile
                )
                Log.d(TAG, "image file name: ${imageFile.name}") // okhttp3.MultipartBody$Part@4a1ff7e

                val token = intent.getStringExtra("token")!!
                Log.d(TAG, "token: $token")
                val req = ProfileServiceCreator.profileService.postProfile(token, username, body, introduce)
                req.enqueue(object:retrofit2.Callback<ResponseBody> {
                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        t.message?.let { Log.e(TAG, "Upload error: $it") } // Upload error: Failed to connect to localhost/127.0.0.1:8080
                    }

                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                        Log.d(TAG, "Upload success")
                        val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                        intent.putExtra("token", token)
                        startActivity(intent)
                    }

                })


            } else if (username == "") {
                Toast.makeText(this, "닉네임을 설정해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "소개글을 설정해주세요.", Toast.LENGTH_SHORT).show()
            }
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
            Log.d(TAG, "Image: ${profileImageBase64.toString()}")

            binding.ivSignUpProfile?.setImageURI(currentImageURL)
            try {
                //이미지 선택 후 처리
                val mediaPath = currentImageURL.toString()
                Log.d(TAG, "image path: $mediaPath")

                imageFile = File(currentImageURL.toString())
                if (currentImageURL != null) {
                    imageUri = currentImageURL
                }
                Log.d(TAG, "image file: $imageFile")

            }catch (e: Exception){
                e.printStackTrace()
            }
        } else{
            Log.d("ActivityResult", "something wrong")
        }

    }

//    private fun NameTextWatcher() {
//        var etName = binding.etSignUpName
//        etName.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
//
//            @SuppressLint("ResourceAsColor")
//            override fun afterTextChanged(s: Editable?) {
//                if (etName.text.length in 3..10) {
//                    etName.setTextColor(Color.parseColor(R.color.gray_100.toString()))
//                } else {
//                    etName.setTextColor(Color.parseColor(R.color.gray_400.toString()))
//                }
//
//            }
//
//        })
//    }
}