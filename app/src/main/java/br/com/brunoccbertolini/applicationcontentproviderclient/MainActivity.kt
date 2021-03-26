package br.com.brunoccbertolini.applicationcontentproviderclient

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var notesRecycler: RecyclerView
    lateinit var notesRefreshButton: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notesRecycler = findViewById(R.id.rv_client_list)
        notesRefreshButton = findViewById(R.id.fb_client_buttom_refresh)

        getContentProvider()

        notesRefreshButton.setOnClickListener {
            getContentProvider()
        }
    }
    private fun getContentProvider(){
        try {
            val url = "content://br.com.brunoccbertolini.applicationcontentprovider.provider/notes"
            val data = Uri.parse(url)
            val cursor: Cursor? =
                contentResolver.query(data, null, null, null, "title")
            notesRecycler.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = ClienteAdapter(cursor as Cursor)
            }
        }catch (ex: Exception){
            ex.printStackTrace()
        }
    }
}