package android.support.p003v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.p000v4.content.PermissionChecker;
import android.util.Log;
import java.util.Calendar;

/* renamed from: android.support.v7.app.TwilightManager */
class TwilightManager {
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private static TwilightManager sInstance;
    private final Context mContext;
    private final LocationManager mLocationManager;
    private final TwilightState mTwilightState = new TwilightState();

    /* renamed from: android.support.v7.app.TwilightManager$TwilightState */
    private static class TwilightState {
        boolean isNight;
        long nextUpdate;
        long todaySunrise;
        long todaySunset;
        long tomorrowSunrise;
        long yesterdaySunset;

        TwilightState() {
        }
    }

    static TwilightManager getInstance(@NonNull Context context) {
        if (sInstance == null) {
            Context context2 = context.getApplicationContext();
            sInstance = new TwilightManager(context2, (LocationManager) context2.getSystemService("location"));
        }
        return sInstance;
    }

    @VisibleForTesting
    static void setInstance(TwilightManager twilightManager) {
        sInstance = twilightManager;
    }

    @VisibleForTesting
    TwilightManager(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.mContext = context;
        this.mLocationManager = locationManager;
    }

    /* access modifiers changed from: 0000 */
    public boolean isNight() {
        TwilightState state = this.mTwilightState;
        if (isStateValid()) {
            return state.isNight;
        }
        Location location = getLastKnownLocation();
        if (location != null) {
            updateState(location);
            return state.isNight;
        }
        Log.i(TAG, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int hour = Calendar.getInstance().get(11);
        return hour < 6 || hour >= 22;
    }

    private Location getLastKnownLocation() {
        Location coarseLoc = null;
        Location fineLoc = null;
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            coarseLoc = getLastKnownLocationForProvider("network");
        }
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            fineLoc = getLastKnownLocationForProvider("gps");
        }
        if (fineLoc == null || coarseLoc == null) {
            return fineLoc != null ? fineLoc : coarseLoc;
        }
        return fineLoc.getTime() > coarseLoc.getTime() ? fineLoc : coarseLoc;
    }

    private Location getLastKnownLocationForProvider(String provider) {
        if (this.mLocationManager != null) {
            try {
                if (this.mLocationManager.isProviderEnabled(provider)) {
                    return this.mLocationManager.getLastKnownLocation(provider);
                }
            } catch (Exception e) {
                Log.d(TAG, "Failed to get last known location", e);
            }
        }
        return null;
    }

    private boolean isStateValid() {
        return this.mTwilightState != null && this.mTwilightState.nextUpdate > System.currentTimeMillis();
    }

    private void updateState(@NonNull Location location) {
        long j;
        long nextUpdate;
        TwilightState state = this.mTwilightState;
        long now = System.currentTimeMillis();
        TwilightCalculator calculator = TwilightCalculator.getInstance();
        TwilightCalculator twilightCalculator = calculator;
        twilightCalculator.calculateTwilight(now - 86400000, location.getLatitude(), location.getLongitude());
        long yesterdaySunset = calculator.sunset;
        twilightCalculator.calculateTwilight(now, location.getLatitude(), location.getLongitude());
        boolean z = true;
        if (calculator.state != 1) {
            z = false;
        }
        boolean isNight = z;
        long todaySunrise = calculator.sunrise;
        long todaySunset = calculator.sunset;
        long j2 = now + 86400000;
        long yesterdaySunset2 = yesterdaySunset;
        long yesterdaySunset3 = todaySunset;
        TwilightState state2 = state;
        long todaySunrise2 = todaySunrise;
        double latitude = location.getLatitude();
        boolean isNight2 = isNight;
        calculator.calculateTwilight(j2, latitude, location.getLongitude());
        long tomorrowSunrise = calculator.sunrise;
        if (todaySunrise2 == -1 || yesterdaySunset3 == -1) {
            j = now + 43200000;
        } else {
            if (now > yesterdaySunset3) {
                nextUpdate = 0 + tomorrowSunrise;
            } else if (now > todaySunrise2) {
                nextUpdate = 0 + yesterdaySunset3;
            } else {
                nextUpdate = 0 + todaySunrise2;
            }
            j = nextUpdate + 60000;
        }
        long nextUpdate2 = j;
        TwilightState state3 = state2;
        state3.isNight = isNight2;
        state3.yesterdaySunset = yesterdaySunset2;
        state3.todaySunrise = todaySunrise2;
        state3.todaySunset = yesterdaySunset3;
        state3.tomorrowSunrise = tomorrowSunrise;
        state3.nextUpdate = nextUpdate2;
    }
}
