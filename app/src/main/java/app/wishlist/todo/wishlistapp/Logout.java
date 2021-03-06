package app.wishlist.todo.wishlistapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by durga on 12/9/16.
 */

public class Logout extends Fragment {
    SharedPreferences wishListAppSettings;
    String usertoken;
    public Logout() {
        // Required empty public constructor
    }
    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.content_user_items);
//        sharedPreferences = getSharedPreferences("WishListAppSettings",MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.remove("token");
//        editor.remove("user-token");
//        editor.apply();
//        Intent intent = new Intent(Logout.this,SignInActivity.class);
//        startActivity(intent);
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_login, container, false);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wishListAppSettings = getActivity() .getSharedPreferences("WishListAppSettings", MODE_PRIVATE);
        usertoken = wishListAppSettings.getString("token", "token is missing");
        SharedPreferences.Editor editor = wishListAppSettings.edit();
        editor.remove("token");
        editor.remove("name");
        editor.remove("emailid");
        editor.apply();
//        getActivity().finish();
        Intent intent = new Intent(getActivity(),LoginActivity.class);
        startActivity(intent);
    }

}