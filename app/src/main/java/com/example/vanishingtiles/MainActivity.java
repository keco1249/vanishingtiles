package com.example.vanishingtiles;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMapView = (MapView) findViewById(R.id.mapview);
        mMapView.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        mMapView.onResume();
        super.onResume();

        mMapView.setStyle("");
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(final MapboxMap mapboxMap) {

                // Init camera location
                CameraPosition.Builder tiltedCameraBuilder = new CameraPosition.Builder(mapboxMap.getCameraPosition())
                        .target(new LatLng(39.750881, -104.99961))
                        .zoom(16)
                        .tilt(65);
                mapboxMap.moveCamera(CameraUpdateFactory.newCameraPosition(tiltedCameraBuilder.build()));

                Handler handler = new Handler(getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        reproduceVanishingTiles(mapboxMap);
                    }
                }, 3000);
            }
        });
    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    private void reproduceVanishingTiles(MapboxMap mapboxMap) {
        Queue<LatLng> route = new LinkedList<>(routeLatLngs());
        moveCamera(route, mapboxMap);
    }

    private void moveCamera(final Queue<LatLng> latLngs, final MapboxMap mapboxMap) {
        if(latLngs == null || latLngs.isEmpty()) {
            return;
        } else {

            LatLng center = latLngs.remove();
            mapboxMap.moveCamera(CameraUpdateFactory.newLatLng(center));

            Handler handler = new Handler(getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    moveCamera(latLngs, mapboxMap);
                }
            }, 200);
        }
    }
    
    private List<LatLng> routeLatLngs() {
        return Arrays.asList(new LatLng(39.750881, -104.99961), new LatLng(39.750717, -104.999832),
                new LatLng(39.750587, -105.000007), new LatLng(39.750076, -105.000656),
                new LatLng(39.749988, -105.000778), new LatLng(39.750335, -105.00122),
                new LatLng(39.750225, -105.00135), new LatLng(39.750137, -105.001464),
                new LatLng(39.749694, -105.002044), new LatLng(39.749572, -105.002182),
                new LatLng(39.749485, -105.00225), new LatLng(39.749416, -105.002296),
                new LatLng(39.749378, -105.002319), new LatLng(39.749324, -105.002349),
                new LatLng(39.749183, -105.002433), new LatLng(39.74913, -105.002464),
                new LatLng(39.74905, -105.002517), new LatLng(39.748996, -105.002563),
                new LatLng(39.748878, -105.002822), new LatLng(39.748783, -105.003021),
                new LatLng(39.748748, -105.003143), new LatLng(39.748756, -105.003211),
                new LatLng(39.748817, -105.003334), new LatLng(39.749195, -105.003623),
                new LatLng(39.749504, -105.003868), new LatLng(39.749755, -105.004127),
                new LatLng(39.749908, -105.004325), new LatLng(39.750167, -105.004714),
                new LatLng(39.750213, -105.004776), new LatLng(39.750259, -105.004837),
                new LatLng(39.750324, -105.00492), new LatLng(39.751255, -105.006202),
                new LatLng(39.751354, -105.006332), new LatLng(39.751396, -105.006378),
                new LatLng(39.751445, -105.006446), new LatLng(39.751476, -105.006484),
                new LatLng(39.751678, -105.006721), new LatLng(39.751754, -105.006797),
                new LatLng(39.752048, -105.007049), new LatLng(39.752304, -105.007225),
                new LatLng(39.752475, -105.007362), new LatLng(39.75262, -105.007469),
                new LatLng(39.752841, -105.00769), new LatLng(39.752983, -105.007843),
                new LatLng(39.753112, -105.008033), new LatLng(39.753223, -105.008186),
                new LatLng(39.753307, -105.008331), new LatLng(39.753379, -105.008468),
                new LatLng(39.753589, -105.008857), new LatLng(39.753719, -105.009117),
                new LatLng(39.75378, -105.009223), new LatLng(39.753997, -105.009651),
                new LatLng(39.754199, -105.010078), new LatLng(39.754226, -105.010131),
                new LatLng(39.75431, -105.010299), new LatLng(39.754344, -105.01036),
                new LatLng(39.754451, -105.010505), new LatLng(39.754535, -105.01062),
                new LatLng(39.754631, -105.010704), new LatLng(39.754718, -105.010757),
                new LatLng(39.754772, -105.01078), new LatLng(39.754917, -105.01078),
                new LatLng(39.755012, -105.010757), new LatLng(39.755229, -105.010665),
                new LatLng(39.755386, -105.010643), new LatLng(39.755805, -105.010696),
                new LatLng(39.755889, -105.010696), new LatLng(39.756076, -105.010658),
                new LatLng(39.756229, -105.010597), new LatLng(39.756355, -105.010513),
                new LatLng(39.756923, -105.009902), new LatLng(39.757114, -105.009712),
                new LatLng(39.757595, -105.009178), new LatLng(39.757896, -105.008781),
                new LatLng(39.758182, -105.008522), new LatLng(39.758884, -105.00756),
                new LatLng(39.759132, -105.007209), new LatLng(39.759212, -105.007087),
                new LatLng(39.759742, -105.006278), new LatLng(39.76012, -105.005706),
                new LatLng(39.760635, -105.00489), new LatLng(39.760982, -105.00431), new LatLng(39.76128, -105.003875),
                new LatLng(39.761516, -105.003562), new LatLng(39.761737, -105.003303),
                new LatLng(39.761993, -105.003021), new LatLng(39.76229, -105.002723),
                new LatLng(39.762496, -105.002532), new LatLng(39.762855, -105.002235),
                new LatLng(39.763572, -105.001716), new LatLng(39.764152, -105.001327),
                new LatLng(39.764556, -105.001022), new LatLng(39.765289, -105.000457),
                new LatLng(39.765563, -105.000183), new LatLng(39.765773, -104.999916),
                new LatLng(39.766098, -104.999435), new LatLng(39.766296, -104.999084),
                new LatLng(39.766403, -104.998878), new LatLng(39.766567, -104.998527),
                new LatLng(39.766841, -104.99784), new LatLng(39.76688, -104.997734),
                new LatLng(39.766944, -104.997558), new LatLng(39.766994, -104.997436),
                new LatLng(39.767135, -104.99707), new LatLng(39.767658, -104.995727),
                new LatLng(39.767856, -104.995216), new LatLng(39.767948, -104.994972),
                new LatLng(39.768016, -104.994804), new LatLng(39.768119, -104.994567),
                new LatLng(39.768222, -104.994171), new LatLng(39.768318, -104.993797),
                new LatLng(39.768608, -104.993095), new LatLng(39.768894, -104.992546),
                new LatLng(39.769176, -104.992126), new LatLng(39.769554, -104.991676),
                new LatLng(39.769916, -104.99131), new LatLng(39.770446, -104.990844),
                new LatLng(39.770561, -104.990745), new LatLng(39.770931, -104.990478),
                new LatLng(39.771522, -104.990097), new LatLng(39.772129, -104.989784),
                new LatLng(39.772441, -104.989646), new LatLng(39.772968, -104.989448),
                new LatLng(39.773712, -104.989242), new LatLng(39.774036, -104.989173),
                new LatLng(39.774684, -104.989082), new LatLng(39.775024, -104.989051),
                new LatLng(39.775753, -104.989021), new LatLng(39.776515, -104.989044),
                new LatLng(39.776969, -104.989051), new LatLng(39.777729, -104.989013),
                new LatLng(39.778041, -104.988983), new LatLng(39.77827, -104.988937),
                new LatLng(39.778396, -104.988899), new LatLng(39.778629, -104.988731),
                new LatLng(39.778804, -104.988616), new LatLng(39.778942, -104.988487),
                new LatLng(39.779098, -104.988319), new LatLng(39.779281, -104.988075),
                new LatLng(39.779399, -104.987861), new LatLng(39.779483, -104.987663),
                new LatLng(39.779563, -104.987319), new LatLng(39.779594, -104.986968),
                new LatLng(39.779594, -104.985839), new LatLng(39.779537, -104.985351),
                new LatLng(39.77959, -104.98278), new LatLng(39.779548, -104.981803), new LatLng(39.77943, -104.98027),
                new LatLng(39.779384, -104.979301), new LatLng(39.779376, -104.979042),
                new LatLng(39.779384, -104.977851), new LatLng(39.779388, -104.977691),
                new LatLng(39.779438, -104.97657), new LatLng(39.779479, -104.976295),
                new LatLng(39.779514, -104.975669), new LatLng(39.779602, -104.97406),
                new LatLng(39.779621, -104.973335), new LatLng(39.779617, -104.973159),
                new LatLng(39.779647, -104.972564), new LatLng(39.779663, -104.97232),
                new LatLng(39.779708, -104.971343), new LatLng(39.779788, -104.969779),
                new LatLng(39.779891, -104.967796), new LatLng(39.779922, -104.967155),
                new LatLng(39.779926, -104.967025), new LatLng(39.77993, -104.966903),
                new LatLng(39.779979, -104.96566), new LatLng(39.780002, -104.964584),
                new LatLng(39.779979, -104.962951), new LatLng(39.779975, -104.962669),
                new LatLng(39.779987, -104.962181), new LatLng(39.779979, -104.962104),
                new LatLng(39.779994, -104.961509), new LatLng(39.779987, -104.960929),
                new LatLng(39.779987, -104.960258), new LatLng(39.779991, -104.96006),
                new LatLng(39.779991, -104.959609), new LatLng(39.779991, -104.959297),
                new LatLng(39.779994, -104.959083), new LatLng(39.78001, -104.958251),
                new LatLng(39.780006, -104.957145), new LatLng(39.779998, -104.956451),
                new LatLng(39.779998, -104.955291), new LatLng(39.779987, -104.954727),
                new LatLng(39.779998, -104.954147), new LatLng(39.779998, -104.953453),
                new LatLng(39.779998, -104.9533), new LatLng(39.779991, -104.953033),
                new LatLng(39.779991, -104.951911), new LatLng(39.779987, -104.950279),
                new LatLng(39.779972, -104.949905), new LatLng(39.779983, -104.948585),
                new LatLng(39.77996, -104.946403), new LatLng(39.77996, -104.945304),
                new LatLng(39.779964, -104.944549), new LatLng(39.779968, -104.944152),
                new LatLng(39.779964, -104.943199), new LatLng(39.779953, -104.941894),
                new LatLng(39.77996, -104.940879), new LatLng(39.77996, -104.940765), new LatLng(39.77996, -104.940689),
                new LatLng(39.779964, -104.940521), new LatLng(39.779956, -104.940338),
                new LatLng(39.779953, -104.940116), new LatLng(39.779975, -104.938484),
                new LatLng(39.780014, -104.937828), new LatLng(39.780033, -104.937423),
                new LatLng(39.780059, -104.936721), new LatLng(39.780075, -104.935913),
                new LatLng(39.780059, -104.932708), new LatLng(39.780044, -104.931983),
                new LatLng(39.780017, -104.931655), new LatLng(39.779972, -104.931266),
                new LatLng(39.779838, -104.930442), new LatLng(39.778499, -104.923507),
                new LatLng(39.778385, -104.922821), new LatLng(39.778347, -104.92247),
                new LatLng(39.778327, -104.922286), new LatLng(39.778297, -104.921905),
                new LatLng(39.778266, -104.921203), new LatLng(39.77827, -104.9179), new LatLng(39.778274, -104.913055),
                new LatLng(39.778274, -104.912879), new LatLng(39.778278, -104.912315),
                new LatLng(39.778285, -104.907981), new LatLng(39.778297, -104.907524),
                new LatLng(39.778293, -104.907188), new LatLng(39.778297, -104.906715),
                new LatLng(39.778308, -104.906372), new LatLng(39.778312, -104.903594),
                new LatLng(39.778305, -104.903442), new LatLng(39.778305, -104.903236),
                new LatLng(39.778301, -104.900344), new LatLng(39.778297, -104.900306),
                new LatLng(39.778293, -104.900093), new LatLng(39.778293, -104.899658),
                new LatLng(39.778293, -104.897819), new LatLng(39.77827, -104.896858),
                new LatLng(39.778266, -104.896697), new LatLng(39.77819, -104.895324),
                new LatLng(39.778125, -104.89447), new LatLng(39.777942, -104.892219),
                new LatLng(39.777305, -104.884864), new LatLng(39.77713, -104.882751),
                new LatLng(39.776924, -104.880134), new LatLng(39.77671, -104.877937),
                new LatLng(39.776596, -104.877006), new LatLng(39.77658, -104.876869),
                new LatLng(39.776504, -104.876182), new LatLng(39.776477, -104.875885),
                new LatLng(39.77629, -104.87371), new LatLng(39.776222, -104.872825),
                new LatLng(39.776008, -104.870124), new LatLng(39.77568, -104.866333),
                new LatLng(39.775665, -104.866096), new LatLng(39.775661, -104.866027),
                new LatLng(39.77565, -104.865928), new LatLng(39.775642, -104.865776),
                new LatLng(39.775623, -104.865638), new LatLng(39.775608, -104.865455),
                new LatLng(39.775341, -104.862258), new LatLng(39.77526, -104.86145),
                new LatLng(39.775157, -104.860206), new LatLng(39.774513, -104.852859),
                new LatLng(39.774452, -104.852195), new LatLng(39.774417, -104.851745),
                new LatLng(39.774036, -104.847274), new LatLng(39.774024, -104.847106),
                new LatLng(39.774017, -104.846954), new LatLng(39.773979, -104.846603),
                new LatLng(39.773563, -104.84185), new LatLng(39.773532, -104.841453),
                new LatLng(39.773494, -104.84098), new LatLng(39.77341, -104.840011),
                new LatLng(39.773242, -104.837997), new LatLng(39.772956, -104.834899),
                new LatLng(39.772891, -104.834144), new LatLng(39.772747, -104.83229),
                new LatLng(39.772495, -104.829582), new LatLng(39.772373, -104.828193),
                new LatLng(39.772193, -104.826171), new LatLng(39.772171, -104.825775),
                new LatLng(39.772106, -104.825256), new LatLng(39.771629, -104.819885),
                new LatLng(39.771541, -104.818862), new LatLng(39.771141, -104.81427),
                new LatLng(39.770969, -104.813507));
    }
}
