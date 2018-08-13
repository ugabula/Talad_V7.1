package talad.co.taladv7.map;

/**
 * Created by cvanderhaar on 2018/07/23.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alium.nibo.autocompletesearchbar.NiboAutocompleteSVProvider;
import com.alium.nibo.autocompletesearchbar.NiboPlacesAutoCompleteSearchView;
import com.alium.nibo.autocompletesearchbar.NiboSearchSuggestionItem;
import com.alium.nibo.models.NiboSelectedOriginDestination;
import com.alium.nibo.models.NiboSelectedPlace;
import com.alium.nibo.origindestinationpicker.NiboOriginDestinationPickerActivity;
import com.alium.nibo.placepicker.NiboPlacePickerActivity;
import com.alium.nibo.utils.NiboConstants;
import com.alium.nibo.utils.NiboStyle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import talad.co.taladv7.R;

public class NiboMainActivity extends AppCompatActivity implements OnMapReadyCallback, NiboAutocompleteSVProvider, GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks {

    private GoogleApiClient mGoogleApiClient;
    private NiboPlacesAutoCompleteSearchView mAutocompletesearchbar;
    private AppCompatButton mLocationPicker;
    private AppCompatButton mOriginDestinationPicker;
    private GoogleMap mMap;
    ArrayList<Marker> markers = new ArrayList<Marker>();
    static final int POLYGON_POINTS = 5;
    Polygon shape;
    private Button btnMark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nibo_map);

        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .enableAutoManage(this, 0, this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        initView();

        btnMark = (Button) findViewById(R.id.mark_your_farm);
        btnMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent overlay = new Intent(NiboMainActivity.this, MapActivity.class);
                startActivity(overlay);
//                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                Uri.parse("https://maps.google.ch/maps?saddr=Oklahoma City, OK, USA&daddr=Los Angeles, CA, USA to:41.8525800,-87.6514100 to: 41.8107300,-87.6012600"));
//                startActivity(intent);
            }
        });

    }

    //START OF MY CLAYTON CODE
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        if(mMap != null){


            mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                @Override
                public void onMapLongClick(LatLng latLng) {
                    NiboMainActivity.this.setMarker("Local", latLng.latitude, latLng.longitude);
                }
            });


            mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
                @Override
                public void onMarkerDragStart(Marker marker) {

                }

                @Override
                public void onMarkerDrag(Marker marker) {

                }

                @Override
                public void onMarkerDragEnd(Marker marker) {

                    Geocoder gc = new Geocoder(NiboMainActivity.this);
                    LatLng ll = marker.getPosition();
                    double lat = ll.latitude;
                    double lng = ll.longitude;
                    List<Address> list = null;
                    try {
                        list = gc.getFromLocation(lat, lng, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Address add = list.get(0);
                    marker.setTitle(add.getLocality());
                    marker.showInfoWindow();
                }
            });


            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter(){

                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    View v = getLayoutInflater().inflate(R.layout.info_window, null);

                    TextView tvLocality = (TextView) v.findViewById(R.id.tv_locality);
                    TextView tvLat = (TextView) v.findViewById(R.id.tv_lat);
                    TextView tvLng = (TextView) v.findViewById(R.id.tv_lng);
                    TextView tvSnippet = (TextView) v.findViewById(R.id.tv_snippet);

                    LatLng ll = marker.getPosition();
                    tvLocality.setText(marker.getTitle());
                    tvLat.setText("Latitude: " + ll.latitude);
                    tvLng.setText("Longitude: " + ll.longitude);
                    tvSnippet.setText(marker.getSnippet());

                    return v;
                }
            });
        }


        goToLocationZoom(39.008224, -76.8984527, 15);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                // TODO: Consider calling
//                //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
//                // here to request the missing permissions, and then overriding
//                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                //                                          int[] grantResults)
//                // to handle the case where the user grants the permission. See the documentation
//                // for Activity#requestPermissions for more details.
//                return;
//            }
//        }
//        mGoogleMap.setMyLocationEnabled(true);

//        mGoogleApiClient = new GoogleApiClient.Builder(this)
//                .addApi(LocationServices.API)
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this)
//                .build();
//        mGoogleApiClient.connect();


    }

    Marker marker;

    public void geoLocate(View view) throws IOException {

        EditText et = (EditText) findViewById(R.id.editText);
        String location = et.getText().toString();

        Geocoder gc = new Geocoder(this);
        List<Address> list = gc.getFromLocationName(location, 1);
        Address address = list.get(0);
        String locality = address.getLocality();

        Toast.makeText(this, locality, Toast.LENGTH_LONG).show();

        double lat = address.getLatitude();
        double lng = address.getLongitude();
        goToLocationZoom(lat, lng, 15);

        if (marker != null){
            marker.remove();
        }

        MarkerOptions options = new MarkerOptions()
                .title(locality)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_farmer_locator))
                .draggable(true)
                .position(new LatLng(lat, lng))
                .snippet("LONG PRESS TO DRAG PIN!");
        marker = mMap.addMarker(options);

        //setMarker(locality, lat, lng);

    }

    private void setMarker(String locality, double lat, double lng) {
//        if(marker != null){
//            removeEverything();
//        }

        if(markers.size() == POLYGON_POINTS){
            removeEverything();
        }

        MarkerOptions options = new MarkerOptions()
                .title(locality)
                .draggable(true)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher))
                .position(new LatLng(lat, lng))
                .snippet("I am Here");

        markers.add(mMap.addMarker(options));

        if(markers.size() == POLYGON_POINTS){
            drawPolygon();
        }

//        if(marker1 == null) {
//            marker1 = mGoogleMap.addMarker(options);
//        } else if(marker2 == null) {
//            marker2 = mGoogleMap.addMarker(options);
//            drawLine();
//        } else {
//            removeEverything();
//            marker1 = mGoogleMap.addMarker(options);
//        }

//        circle = drawCircle(new LatLng(lat, lng));

    }

    private void drawPolygon() {
        PolygonOptions options = new PolygonOptions()
                .fillColor(0x330000FF)
                .strokeWidth(3)
                .strokeColor(Color.RED);

        for(int i=0; i < POLYGON_POINTS; i++){
            options.add(markers.get(i).getPosition());
        }
        shape = mMap.addPolygon(options);

    }

    private void removeEverything() {
        for(Marker marker : markers) {
            marker.remove();
        }
        markers.clear();
        shape.remove();
        shape = null;

    }

    private void goToLocation(double lat, double lng) {
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLng(ll);
        mMap.moveCamera(update);
    }

    private void goToLocationZoom(double lat, double lng, float zoom) {
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, zoom);
        mMap.moveCamera(update);
    }


    //END OF MY CLAYTON CODE


    private void launchPickerFragment() {
        Intent intent = new Intent(this, NiboPlacePickerActivity.class);
        NiboPlacePickerActivity.NiboPlacePickerBuilder config = new NiboPlacePickerActivity.NiboPlacePickerBuilder()
                .setSearchBarTitle("Search for an area")
                .setConfirmButtonTitle("Pick here")
                .setMarkerPinIconRes(R.drawable.ic_farmer_locator)
                .setStyleEnum(NiboStyle.NIGHT_MODE);
        //.setStyleFileID(R.raw.retro);
        NiboPlacePickerActivity.setBuilder(config);
        startActivityForResult(intent, 300);
    }

    private void launchStartFinishActivity() {
        Intent intent = new Intent(this, NiboOriginDestinationPickerActivity.class);

        NiboOriginDestinationPickerActivity.NiboOriginDestinationPickerBuilder config = new NiboOriginDestinationPickerActivity.NiboOriginDestinationPickerBuilder()
                .setDestinationMarkerPinIconRes(R.drawable.ic_farmer_locator)
                .setOriginMarkerPinIconRes(R.drawable.ic_farmer_locator)
                .setBackButtonIconRes(R.drawable.arrow_left)
                .setOriginEditTextHint("Input pick up location")
                .setPrimaryPolyLineColor(R.color.colorPrimary)
                .setSecondaryPolyLineColor(R.color.colorAccent)
                .setDestinationEditTextHint("Input destination")
                .setStyleEnum(NiboStyle.SUBTLE_GREY_SCALE);

        NiboOriginDestinationPickerActivity.setBuilder(config);
        startActivityForResult(intent, 200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == 300) {
            NiboSelectedPlace selectedPlace = data.getParcelableExtra(NiboConstants.SELECTED_PLACE_RESULT);
            Toast.makeText(this, selectedPlace.getPlaceAddress(), Toast.LENGTH_LONG).show();
        } else if (resultCode == Activity.RESULT_OK && requestCode == 200) {
            NiboSelectedOriginDestination selectedOriginDestination = data.getParcelableExtra(NiboConstants.SELECTED_ORIGIN_DESTINATION_RESULT);
            Toast.makeText(this, selectedOriginDestination.getOriginFullName() + " - " + selectedOriginDestination.getDestinationFullName(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error getting results", Toast.LENGTH_LONG).show();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nibo_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public GoogleApiClient getGoogleApiClient() {
        return mGoogleApiClient;
    }

    @Override
    public void onHomeButtonClicked() {

    }

    @Override
    public NiboPlacesAutoCompleteSearchView.SearchListener getSearchListener() {
        return new NiboPlacesAutoCompleteSearchView.SearchListener() {


            @Override
            public void onSearchEditOpened() {


            }

            @Override
            public void onSearchEditClosed() {

            }


            @Override
            public boolean onSearchEditBackPressed() {

                return false;
            }

            @Override
            public void onSearchExit() {

            }

            @Override
            public void onSearchTermChanged(String term) {


            }

            @Override
            public void onSearch(String string) {

            }

            @Override
            public boolean onSuggestion(NiboSearchSuggestionItem niboSearchSuggestionItem) {
                Toast.makeText(NiboMainActivity.this, "PLACE NAME:" + niboSearchSuggestionItem.getFullTitle() + " PLACE ID: " + niboSearchSuggestionItem.getPlaceID(), Toast.LENGTH_SHORT).show();
                mAutocompletesearchbar.closeSearch();
                return false;
            }

            @Override
            public void onSearchCleared() {

            }

        };
    }

    @Override
    public boolean getShouldUseVoice() {
        return false;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    private void initView() {

        mAutocompletesearchbar = (NiboPlacesAutoCompleteSearchView) findViewById(R.id.autocompletesearchbar);
        mLocationPicker = (AppCompatButton) findViewById(R.id.location_picker);
        mOriginDestinationPicker = (AppCompatButton) findViewById(R.id.origin_destination_picker);
        mAutocompletesearchbar.setmProvider(this);

        mLocationPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchPickerFragment();
            }
        });


        mOriginDestinationPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchStartFinishActivity();
            }
        });

    }
}