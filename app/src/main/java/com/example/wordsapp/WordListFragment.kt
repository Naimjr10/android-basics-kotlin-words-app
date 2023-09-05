package com.example.wordsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.FragmentWordListBinding

class WordListFragment : Fragment() {
    var _binding: FragmentWordListBinding? = null
    val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var letterId: String

    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Let melakukan looping pada { arguments }
        // kemudian ambil argumen yang diteruskan dari fungsi
        // { LetterListFragmentDirections.actionLetterListFragmentToWordListFragment() }
        // dan tetapkan ke variabel letterId
        arguments?.let {
            letterId = it.getString(LETTER).toString()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager( requireContext() )
        recyclerView.adapter = WordAdapter( letterId, requireContext() )
        recyclerView.addItemDecoration(
            DividerItemDecoration( requireContext(), DividerItemDecoration.VERTICAL )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}