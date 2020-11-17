package my.edu.tarc.mydatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    //Global variable
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //connect to personal database
        auth = FirebaseAuth.getInstance()

        //Creating data for room1
        var roomNo : String = "R01"
        var noOfPax : Int = 2
        var status : Boolean = true
        //true = available, false = occupied
        var database = FirebaseDatabase.getInstance()
        var myRef: DatabaseReference = database.getReference("Room").child("Room1")
        val room1 = Room()
        room1.setRoomNo(roomNo)
        room1.setNoOfPax(noOfPax)
        room1.setStatus(status)
        myRef.setValue(room1)

        //Creating data for room2
        roomNo  = "R02"
        noOfPax  = 2
        status  = true
        database = FirebaseDatabase.getInstance()
        myRef = database.getReference("Room").child("Room2")
        val room2 = Room()
        room2.setRoomNo(roomNo)
        room2.setNoOfPax(noOfPax)
        room2.setStatus(status)
        myRef.setValue(room2);

        //Creating data for room3
        roomNo  = "R03"
        noOfPax  = 4
        status  = true
        database = FirebaseDatabase.getInstance()
        myRef = database.getReference("Room").child("Room3")
        val room3 = Room()
        room3.setRoomNo(roomNo)
        room3.setNoOfPax(noOfPax)
        room3.setStatus(status)
        myRef.setValue(room3);

        //Creating data for room4
        roomNo  = "R04"
        noOfPax  = 4
        status  = true
        database = FirebaseDatabase.getInstance()
        myRef = database.getReference("Room").child("Room4")
        val room4 = Room()
        room4.setRoomNo(roomNo)
        room4.setNoOfPax(noOfPax)
        room4.setStatus(status)
        myRef.setValue(room4);
    }
}
