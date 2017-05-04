package com.merryapps.rxarch.ui.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.merryapps.rxarch.R;
import com.merryapps.rxarch.ui.repositories.RepositoryListFragment;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    loadRepositoryFragment();
  }

  private void loadRepositoryFragment() {
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.main_placeholder_frmLyt_id, new RepositoryListFragment(),
            RepositoryListFragment.FRAGMENT_TAG)
        .commit();
  }
}
