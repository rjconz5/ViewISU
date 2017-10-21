package com.isu.view.viewisu;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.isu.view.viewisu.R.id.buttonLogout;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private TextView textViewUserEmail;
    private Button buttonLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        //displaying logged in user name
        textViewUserEmail.setText("Welcome "+user.getEmail());

        //adding listener to button
        buttonLogout.setOnClickListener(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /*** Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng gilman = new LatLng(42.029525, -93.648627);
        mMap.addMarker(new MarkerOptions().position(gilman).title("Gilman Hall").snippet("Feel science-y? It should."));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gilman));
        LatLng agronomy = new LatLng(42.028242, -93.642507);
        mMap.addMarker(new MarkerOptions().position(agronomy).title("Agronomy Hall").snippet("Text Nathan? (319)-827-2327"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(agronomy));
        LatLng memUnion = new LatLng(42.023650, -93.645959);
        mMap.addMarker(new MarkerOptions().position(memUnion).title("Memorial Union").snippet("Text Tyler? (319)-123-4567"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(memUnion));
        LatLng campanile = new LatLng(42.026619, -93.646465);
        mMap.addMarker(new MarkerOptions().position(campanile).title("Campanile").snippet("Text Ryan? (319)-765-4321"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(campanile));
        LatLng lakeLaverne = new LatLng(42.023705, -93.647987);
        mMap.addMarker(new MarkerOptions().position(lakeLaverne).title("Lake Laverne").snippet("Text Ryan? (319)-765-4321"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lakeLaverne));
        LatLng library = new LatLng(42.028125, -93.648814);
        mMap.addMarker(new MarkerOptions().position(library).title("Parks Library").snippet("Text Ryan? (319)-765-4321"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(library));
        LatLng stateGym = new LatLng(42.025076, -93.653605);
        mMap.addMarker(new MarkerOptions().position(stateGym).title("State Gym").snippet("Text Ryan? (319)-765-4321"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(stateGym));
        LatLng liedRec = new LatLng(42.026350, -93.637990);
        mMap.addMarker(new MarkerOptions().position(liedRec).title("Lied Rec Center").snippet("Text Ryan? (319)-765-4321"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(liedRec));
        LatLng stadium = new LatLng(42.016052, -93.635651);
        mMap.addMarker(new MarkerOptions().position(stadium).title("Jack Trice Stadium").snippet("Text Ryan? (319)-765-4321"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(stadium));
        LatLng howe = new LatLng(42.026797, -93.652409);
        mMap.addMarker(new MarkerOptions().position(howe).title("Howe Hall").snippet("Text Ryan? (319)-765-4321"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(howe));
        LatLng coover = new LatLng(42.028406, -93.651529);
        mMap.addMarker(new MarkerOptions().position(coover).title("Coover Hall").snippet("Text Ryan? (319)-765-4321"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coover));
        LatLng friley = new LatLng(42.024326, -93.650757);
        mMap.addMarker(new MarkerOptions().position(friley).title("Friley Hall").snippet("Text Ryan? (319)-765-4321"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(friley));
        LatLng seasons = new LatLng(42.024079, -93.638218);
        mMap.addMarker(new MarkerOptions().position(seasons).title("Seasons Dining Hall").snippet("Text Ryan? (319)-765-4321"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seasons));
        LatLng udcc = new LatLng(42.025187, -93.651250);
        mMap.addMarker(new MarkerOptions().position(udcc).title("Union Drive Community Center").snippet("Text Ryan? (319)-765-4321"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(udcc));



        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }
    public void onClick(View view) {
        //if logout is pressed
        if(view == buttonLogout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}