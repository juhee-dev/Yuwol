package com.yuwol.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.mancj.materialsearchbar.MaterialSearchBar
import com.yuwol.adapter.SearchAdapter
import com.yuwol.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding
    var searchData = arrayOf("윤하", "BLACKPINK")
    lateinit var adapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

//        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, searchData)
//        binding.lvSearch.visibility = View.INVISIBLE
//        binding.lvSearch.adapter = adapter as ArrayAdapter<String>

//        adapter = SearchAdapter(searchData, requireContext())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        //enable searchbar callbacks
//        binding.sbSearch.setOnSearchActionListener(object : MaterialSearchBar.OnSearchActionListener{
//            override fun onButtonClicked(buttonCode: Int) {
//                TODO("Not yet implemented")
//            }
//            //검색창 누른 상태 여부 확인
//            override fun onSearchStateChanged(enabled: Boolean) {
//                //맞으면 리스트뷰 보이게 설정
//                if(enabled){
//                    binding.lvSearch.visibility = View.VISIBLE
//                }else{ //아니면 안 보이게
//                    binding.lvSearch.visibility = View.INVISIBLE
//                }
//            }
//
//            override fun onSearchConfirmed(text: CharSequence?) {
//                TODO("Not yet implemented")
//            }
//
//        })
//
//        binding.sbSearch.addTextChangeListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//            //검색어 변경하면 ListView 내용 변경
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                adapter.getFilter().filter(s)
//            }
//
//        })
    }
}