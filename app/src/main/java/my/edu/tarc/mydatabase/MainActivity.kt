package my.edu.tarc.mydatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       //Connect firebase to personal database
        var database = FirebaseDatabase.getInstance("https://solenoid-lock-f65e8.firebaseio.com")
        var myRef: DatabaseReference = database.getReference("Room").child("Room1")

        //specially writing to Room1 for the sanitizer :)
        /*In general case, the sanitizer system will have 100 drops or even more, due to presentation we will
        * be showing 10 drops in the sanitizer bottle and 3 drops per room */
        var sanitizerLeft: Int = 10
        var sanitizer: DatabaseReference = database.getReference("Room").child("Room1").child("SanitizerLeft")
        sanitizer.setValue(sanitizerLeft)

        //Creating data for room1
        var roomNo : String = "R01"
        var noOfPax : Int = 2
        var status : Boolean = false
        var code: String ="000000"
        //true = available, false = occupied
        val room1 = Room()
        room1.roomNo = roomNo
        room1.noOfPax = noOfPax
        room1.isStatus = status
        room1.code = code
        myRef.setValue(room1)

        //Creating data for room2
        roomNo  = "R02"
        noOfPax  = 2
        status  = true
        myRef = database.getReference("Room").child("Room2")
        val room2 = Room()
        room2.roomNo = roomNo
        room2.noOfPax = noOfPax
        room2.isStatus = status
        room2.code = code
        myRef.setValue(room2);

        //Creating data for room3
        roomNo  = "R03"
        noOfPax  = 4
        status  = true
        myRef = database.getReference("Room").child("Room3")
        val room3 = Room()
        room3.roomNo = roomNo
        room3.noOfPax = noOfPax
        room3.isStatus = status
        room3.code = code
        myRef.setValue(room3);

        //Creating data for room4
        roomNo  = "R04"
        noOfPax  = 4
        status  = true
        myRef = database.getReference("Room").child("Room4")
        val room4 = Room()
        room4.roomNo = roomNo
        room4.noOfPax = noOfPax
        room4.isStatus = status
        room4.code = code
        myRef.setValue(room4);
    }
}
