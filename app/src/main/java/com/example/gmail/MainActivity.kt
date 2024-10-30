package com.example.gmail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val listView: ListView = findViewById(R.id.listView)
        val emails = arrayListOf(
            Email("Apple", "Exclusive Offer for MacBook Buyers", "2:45 PM"),
            Email("Google Support", "Account Verification Required", "1:30 PM"),
            Email("Coursera", "New AI Courses Just Launched!", "12:15 PM"),
            Email("PayPal", "Update on Your Recent Transaction", "11:50 AM"),
            Email("Netflix", "Your Subscription Renewal Reminder", "11:30 AM")
        )
        val adapter = EmailAdapter(this, emails)
        listView.adapter = adapter

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            // Xử lý sự kiện khi nhấn nút
        }
    }
}

data class Email(val sender: String, val subject: String, val time: String)

class EmailAdapter(private val context: Context, private val dataSource: ArrayList<Email>) : ArrayAdapter<Email>(context, R.layout.list_item_email, dataSource) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_email, parent, false)
        val senderTextView = rowView.findViewById<TextView>(R.id.senderTextView)
        val subjectTextView = rowView.findViewById<TextView>(R.id.subjectTextView)
        val timeTextView = rowView.findViewById<TextView>(R.id.timeTextView)
        val email = getItem(position)
        senderTextView.text = email?.sender
        subjectTextView.text = email?.subject
        timeTextView.text = email?.time
        return rowView
    }
}
