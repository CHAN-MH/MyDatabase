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
        var database2 = FirebaseDatabase.getInstance()
        var myRef: DatabaseReference = database2.getReference("Room").child("Room1")
        var lcdRef: DatabaseReference = database2.getReference("bait2123-202010-03").child("PI_03_CONTROL")

        //var database1 = FirebaseDatabase.getInstance("https://bait2123-202010-03.firebaseio.com/")
        //var comRef: DatabaseReference = database1.getReference("bait2123-202010-03").child("Room")

        //test can write to common resources anot
        //var test: String = "test"
        //comRef.setValue(test)

        //Creating User 1
        var userRef: DatabaseReference = database2.getReference("UserProfile").child("User1")
        var email : String = "halo@gmail.com"
        var password : String = "123123"
        val user1 = User()
        user1.email = email
        user1.password = password
        userRef.setValue(user1)

        //Creating data for room1
        var roomNo: String = "R01"
        var noOfPax: Int = 2
        var status: Boolean = true
        var code: String = "000000"
        //true = available, false = occupied
        val room1 = Room()
        room1.roomNo = roomNo
        room1.noOfPax = noOfPax
        room1.isStatus = status
        room1.code = code
        myRef.setValue(room1)

        //specially writing to Room1 for the sanitizer :)
        /*In general case, the sanitizer system will have 100 drops or even more, due to presentation we will
        * be showing 10 drops in the sanitizer bottle and 3 drops per room */
        var sanitizerLeft: Int = 10
        var sanitizer: DatabaseReference =
            database2.getReference("Room").child("Room1").child("sanitizerLeft")
        var sanitizerUsed: DatabaseReference =
            database2.getReference("Room").child("Room1").child("sanitizerUsed")
        sanitizer.setValue(sanitizerLeft)
        sanitizerUsed.setValue(0)

        //Creating data for room2
        roomNo = "R02"
        noOfPax = 2
        status = true
        myRef = database2.getReference("Room").child("Room2")
        val room2 = Room()
        room2.roomNo = roomNo
        room2.noOfPax = noOfPax
        room2.isStatus = status
        room2.code = code
        myRef.setValue(room2);

        //Creating data for room3
        roomNo = "R03"
        noOfPax = 4
        status = true
        myRef = database2.getReference("Room").child("Room3")
        val room3 = Room()
        room3.roomNo = roomNo
        room3.noOfPax = noOfPax
        room3.isStatus = status
        room3.code = code
        myRef.setValue(room3);

        //Creating data for room4
        roomNo = "R04"
        noOfPax = 4
        status = false
        myRef = database2.getReference("Room").child("Room4")
        val room4 = Room()
        room4.roomNo = roomNo
        room4.noOfPax = noOfPax
        room4.isStatus = status
        room4.code = code
        myRef.setValue(room4);

        //reseting the data in PL-03-Control
        var lcdscr = ""
        var lcdtxt = ""
        var lcdbkR = ""
        var lcdbkG = ""
        var lcdbkB = ""

        lcdRef.child("lcdscr").setValue(lcdscr)
        lcdRef.child("lcdtxt").setValue(lcdtxt)
        lcdRef.child("lcdbkR").setValue(lcdbkR)
        lcdRef.child("lcdbkG").setValue(lcdbkG)
        lcdRef.child("lcdbkB").setValue(lcdbkB)
    }
}
