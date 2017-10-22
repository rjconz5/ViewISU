package com.isu.view.viewisu;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQuery;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.isu.view.viewisu.R.id.buttonLogout;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, com.google.android.gms.location.LocationListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    LocationRequest mLocationRequest;
    //firebase auth object
    private FirebaseAuth firebaseAuth;

    private int score = 0;
    private boolean Gilman;
    private boolean Agronomy;
    private boolean MU;
    private boolean Camp;
    private boolean Lake;
    private boolean Lib;
    private boolean State;
    private boolean Lied;
    private boolean Stadium;
    private boolean Howe;
    private boolean Coover;
    private boolean Friley;
    private boolean Seasons;
    private boolean UDCC;
    private boolean Vermeer;
    private boolean[] checkbool;


    //view objects
    private TextView textViewScore;
    private Button buttonLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Gilman = true;
        Agronomy = true;
        MU = true;
        Camp = true;
        Lake = true;
        Lib = true;
        State = true;
        Lied = true;
        Stadium = true;
        Howe = true;
        Coover = true;
        Friley = true;
        Seasons = true;
        UDCC = true;
        Vermeer = true;

        checkbool = new boolean[15];
        boolean[] temp = {Gilman, Agronomy, MU, Camp, Lake, Lib, State, Lied, Stadium,
                Howe, Coover, Friley, Seasons, UDCC, Vermeer};
        checkbool = temp;



        setContentView(R.layout.activity_maps);
        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        textViewScore = (TextView) findViewById(R.id.textViewScore);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        //displaying logged in user name
        textViewScore.setText(String.format("Score: %d", score));

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
        mMap.addMarker(new MarkerOptions().position(gilman).title("Gilman Hall").snippet("+10 Points"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gilman));
        LatLng agronomy = new LatLng(42.028242, -93.642507);
        mMap.addMarker(new MarkerOptions().position(agronomy).title("Agronomy Hall").snippet("+10 Points"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(agronomy));
        LatLng memUnion = new LatLng(42.023650, -93.645959);
        mMap.addMarker(new MarkerOptions().position(memUnion).title("Memorial Union").snippet("+10 Points"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(memUnion));
        LatLng campanile = new LatLng(42.026619, -93.646465);
        mMap.addMarker(new MarkerOptions().position(campanile).title("Campanile").snippet("+10 Points"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(campanile));
        LatLng lakeLaverne = new LatLng(42.023705, -93.647987);
        mMap.addMarker(new MarkerOptions().position(lakeLaverne).title("Lake Laverne").snippet("+10 Points"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lakeLaverne));
        LatLng library = new LatLng(42.028125, -93.648814);
        mMap.addMarker(new MarkerOptions().position(library).title("Parks Library").snippet("+10 Points"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(library));
        LatLng stateGym = new LatLng(42.025076, -93.653605);
        mMap.addMarker(new MarkerOptions().position(stateGym).title("State Gym").snippet("+10 Points"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(stateGym));
        LatLng liedRec = new LatLng(42.026350, -93.637990);
        mMap.addMarker(new MarkerOptions().position(liedRec).title("Lied Rec Center").snippet("+10 Points"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(liedRec));
        LatLng stadium = new LatLng(42.016052, -93.635651);
        mMap.addMarker(new MarkerOptions().position(stadium).title("Jack Trice Stadium").snippet("+10 Points"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(stadium));
        LatLng howe = new LatLng(42.026797, -93.652409);
        mMap.addMarker(new MarkerOptions().position(howe).title("Howe Hall").snippet("+10 Points"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(howe));
        LatLng coover = new LatLng(42.028406, -93.651529);
        mMap.addMarker(new MarkerOptions().position(coover).title("Coover Hall").snippet("+10 Points"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coover));
        LatLng friley = new LatLng(42.024326, -93.650757);
        mMap.addMarker(new MarkerOptions().position(friley).title("Friley Hall").snippet("+10 Points"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(friley));
        LatLng seasons = new LatLng(42.024079, -93.638218);
        mMap.addMarker(new MarkerOptions().position(seasons).title("Seasons Dining Hall").snippet("+10 Points"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seasons));
        LatLng udcc = new LatLng(42.025187, -93.651250);
        mMap.addMarker(new MarkerOptions().position(udcc).title("Union Drive Community Center").snippet("+10 Points"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(udcc));
        LatLng vermeer = new LatLng(41.997865, -93.632737);
        mMap.addMarker(new MarkerOptions().position(vermeer).title("Vermeer").snippet("+10 Points"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(vermeer));








        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        buildGoogleApiClient();
        mMap.setMyLocationEnabled(true);
    }

    protected synchronized void buildGoogleApiClient(){
        mGoogleApiClient =  new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this).addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
        mGoogleApiClient.connect();
    }

    public void onClick(View view) {
        //if logout is pressed
        if (view == buttonLogout) {
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        getClosestCheckpoint(location);
        textViewScore.setText(String.format("Score: %d", score));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16)); //1-21 value




    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(100);
        mLocationRequest.setFastestInterval(100);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void getClosestCheckpoint(Location x){
//        DatabaseReference loc = FirebaseDatabase.getInstance().getReference("locations");
//        GeoFire geoFire = new GeoFire(loc);
//        geoFire.setLocation("Gilman Hall", new GeoLocation(42.029525, -93.648627));
//        geoFire.setLocation("Agronomy Hall", new GeoLocation(42.028242, -93.642507));
//        geoFire.setLocation("Memorial Union", new GeoLocation(42.023650, -93.645959));
//        geoFire.setLocation("Campanile", new GeoLocation(42.026619, -93.646465));
//        geoFire.setLocation("Lake Laverne", new GeoLocation(42.023705, -93.647987));
//        geoFire.setLocation("Parks Library", new GeoLocation(42.028125, -93.648814));
//        geoFire.setLocation("State Gym", new GeoLocation(42.025076, -93.653605));
//        geoFire.setLocation("Lied Recreation Center", new GeoLocation(42.026350, -93.637990));
//        geoFire.setLocation("Jack Trice Stadium", new GeoLocation(42.016052, -93.635651));
//        geoFire.setLocation("Howe Hall Atrium", new GeoLocation(42.026797, -93.652409));
//        geoFire.setLocation("Coover Hall", new GeoLocation(42.028406, -93.651529));
//        geoFire.setLocation("Friley Hall", new GeoLocation(42.024326, -93.650757));
//        geoFire.setLocation("Seasons Dining Hall", new GeoLocation(42.024079, -93.638218));
//        geoFire.setLocation("Union Drive Community Center", new GeoLocation(42.025187, -93.651250));

        Location GilmanHall = new Location("");
        GilmanHall.setLatitude(42.029525);
        GilmanHall.setLongitude(-93.648627);

        Location AgronomyHall = new Location("");
        AgronomyHall.setLatitude(42.028242);
        AgronomyHall.setLongitude(-93.642507);

        Location MemorialUnion = new Location("");
        MemorialUnion.setLatitude(42.023650);
        MemorialUnion.setLongitude(-93.645959);

        Location Campanile = new Location("");
        Campanile.setLatitude(42.026619);
        Campanile.setLongitude(-93.646465);

        Location LakeLaverne = new Location("");
        LakeLaverne.setLatitude(42.023705);
        LakeLaverne.setLongitude(-93.647987);

        Location ParksLibrary = new Location("");
        ParksLibrary.setLatitude(42.028125);
        ParksLibrary.setLongitude(-93.648814);

        Location StateGym = new Location("");
        StateGym.setLatitude(42.025076);
        StateGym.setLongitude(-93.653605);

        Location LiedRec = new Location("");
        LiedRec.setLatitude(42.026350);
        LiedRec.setLongitude(-93.637990);

        Location JackTrice = new Location("");
        JackTrice.setLatitude(42.016052);
        JackTrice.setLongitude(-93.635651);

        Location HoweHall = new Location("");
        HoweHall.setLatitude(42.026797);
        HoweHall.setLongitude(-93.652409);

        Location CooverHall = new Location("");
        CooverHall.setLatitude(42.028406);
        CooverHall.setLongitude(-93.651529);

        Location FrileyHall = new Location("");
        FrileyHall.setLatitude(42.024326);
        FrileyHall.setLongitude(-93.650757);

        Location SeasonsDining = new Location("");
        SeasonsDining.setLatitude(42.024079);
        SeasonsDining.setLongitude(-93.638218);

        Location UnionDrive = new Location("");
        UnionDrive.setLatitude(42.025187);
        UnionDrive.setLongitude(-93.651250);

        Location Person = new Location("");
        Person.setLatitude(x.getLatitude());
        Person.setLongitude(x.getLongitude());

        Location VermeerBuilding = new Location("");
        VermeerBuilding.setLatitude(41.997865);
        VermeerBuilding.setLongitude(-93.632737);

        Location[] checkpoints = {GilmanHall, AgronomyHall, MemorialUnion, Campanile, LakeLaverne, ParksLibrary,
            StateGym, LiedRec, JackTrice, HoweHall, CooverHall, FrileyHall, SeasonsDining, UnionDrive, VermeerBuilding};


        for(int i = 0; i < 15; i++){
            if(checkpoints[i].distanceTo(Person) < 20){
                if(checkbool[i]){
                    checkbool[i] = false;
                    score += 10;
                }

            }
        }





    }
}