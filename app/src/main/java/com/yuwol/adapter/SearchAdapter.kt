package com.yuwol.adapter

class SearchAdapter
//    (var song: Array<String>, var con: Context) : BaseAdapter(), Filterable
{
//    var searchFilter = SearchFilter()
//    var filteredSong = ArrayList<Song>()
//
//    override fun getFilter(): Filter {
//        return searchFilter
//    }
//
//    inner class SearchFilter: Filter() {
//        override fun performFiltering(constraint: CharSequence?): FilterResults {
//            val filterString = constraint.toString()
//            val results = FilterResults()
//
//            //검색이 필요없을 경우를 위해 원본배열 복제
//            val filterList : ArrayList<Song> = ArrayList<Song>()
//
//            //공벡제외 아무런 값도 입력하지 않았을 경우 ->원본배열
//            if (filterString.trim { it <= ' '}.isEmpty()) {
//                //필터링 작업으로 계산된 모든 값
//                results.values = song
//                //필터링 작업으로 계산된 값의 수
//                results.count = song.size
//                return results
//
//                //20글자 수 이하일 때 -> 이메일로 검색
//            } else if (filterString.trim {it <= ' '}.length <= 20) {
//                for (searchSong in song) {
//                    if (searchSong.title.contains(filterString)) {
//                        filterList.add(searchSong)
//                    }
//                }
//            }
//            results.values = filterList
//            results.count = filterList.size
//
//            return results
//        }
//
//        @SuppressLint("NotifyDataSetChanged")
//        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//            filteredSong.clear()
//            filteredSong.addAll(results?.values as ArrayList<Song>)
//            notifyDataSetChanged()
//        }
//
//    }
//
//    override fun getCount(): Int {
//        return filteredSong.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return filteredSong[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val item: Song = song[position]
//        convertView!!.tv_item_search_auto.text = item.artist
//
//        return convertView
//    }
}