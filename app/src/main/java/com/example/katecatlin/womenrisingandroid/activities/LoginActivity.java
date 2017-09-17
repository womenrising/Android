package com.example.katecatlin.womenrisingandroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.katecatlin.womenrisingandroid.R;
import com.example.katecatlin.womenrisingandroid.interfaces.WomenRisingService;
import com.example.katecatlin.womenrisingandroid.models.Profile;
import com.example.katecatlin.womenrisingandroid.services.RetrofitHelper;
import com.linkedin.platform.APIHelper;
import com.linkedin.platform.LISessionManager;
import com.linkedin.platform.errors.LIApiError;
import com.linkedin.platform.errors.LIAuthError;
import com.linkedin.platform.listeners.ApiListener;
import com.linkedin.platform.listeners.ApiResponse;
import com.linkedin.platform.listeners.AuthListener;
import com.linkedin.platform.utils.Scope;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.disposables.CompositeDisposable;

public class LoginActivity extends Activity {

    public static final String FULL_URL_KEY = "FULL_URL_KEY";
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    //TODO: Refactor this and pull some logic out to a new class.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton loginButton = (ImageButton) findViewById(R.id.LILoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }

        });
    }

    private void handleLogin() {
        final Activity thisActivity = this;

        LISessionManager.getInstance(getApplicationContext()).init(thisActivity, buildScope(), new AuthListener() {
            @Override
            public void onAuthSuccess() {
                fetchPersonalInfoFromLinkedIn();
            }

            @Override
            public void onAuthError(LIAuthError error) {
                Log.e("TAG", error.toString());
            }
        }, true);
    }

    private void fetchPersonalInfoFromLinkedIn() {
        String url = "https://api.linkedin.com/v1/people/~:(id,first-name,last-name,picture-url,email-address)?format=json";

        final APIHelper apiHelper = APIHelper.getInstance(getApplicationContext());
        apiHelper.getRequest(this, url, new ApiListener() {
            @Override
            public void onApiSuccess(ApiResponse apiResponse) {
                try {
                    JSONObject jsonObject = apiResponse.getResponseDataAsJson();

                    String firstName = jsonObject.getString("firstName");
                    String lastName = jsonObject.getString("lastName");
                    String userID = jsonObject.getString("id");
                    String pictureURL = jsonObject.getString("pictureUrl");
                    String emailAddress = jsonObject.getString("emailAddress");

                    Profile myProfile = new Profile(userID, firstName, lastName, null, null, pictureURL, emailAddress);

                    fetchInfoFromWRWebsite(myProfile);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onApiError(LIApiError liApiError) {
                Log.e("TAG", "Error onAPI Login");
            }
        });
    }

    private void fetchInfoFromWRWebsite (Profile loggedInProfile) {
//        WomenRisingService womenRisingService = new RetrofitHelper().getWomenRisingService();
//
//        mCompositeDisposable.add(mCityService.queryGeonames(44.1, -9.9, -22.4, 55.2, “de”)
//                .subscribeOn(Schedulers.io()) // “work” on io thread
//                .observeOn(AndroidSchedulers.mainThread()) // “listen” on UIThread
//                .map(new Function<CityResponse, List<Geoname>>() {
//                    @Override
//                    public List<Geoname> apply(
//                            @io.reactivex.annotations.NonNull final CityResponse  cityResponse) throws Exception {
//                        // we want to have the geonames and not the wrapper object
//                        return cityResponse.geonames;
//                    }
//                })
//                .subscribe(new Consumer<List<Geoname>>() {
//                    @Override
//                    public void accept(
//                            @io.reactivex.annotations.NonNull final List<Geoname> geonames)
//                            throws Exception {
//                        displayGeonames(geonames);
//                    }
//                })
//        );
    }


    private void launchProfileViewActivity (Profile fullyLoadedProfile) {
        Intent intent = new Intent(this, ProfileViewActivity.class);
        intent.putExtra(FULL_URL_KEY, fullyLoadedProfile);
        startActivity(intent);
    }

    private static Scope buildScope() {
        return Scope.build(Scope.R_BASICPROFILE, Scope.W_SHARE, Scope.R_EMAILADDRESS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        LISessionManager.getInstance(getApplicationContext()).onActivityResult(this, requestCode, resultCode, data);
    }

}

