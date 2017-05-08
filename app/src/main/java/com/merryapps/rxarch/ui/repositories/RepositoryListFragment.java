package com.merryapps.rxarch.ui.repositories;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.merryapps.rxarch.R;
import com.merryapps.rxarch.model.repositories.RepositoryManager;
import com.merryapps.rxarch.model.repositories.RepositorySearchAction;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.Collections;

/**
 * A fragment that backs up the repository list UI.
 * //TODO add description
 *
 * @author Pravin Sonawane
 * @since 0.0.1
 */

public class RepositoryListFragment extends Fragment {
  private static final String TAG = "RepositoryListFragment";
  public static final String FRAGMENT_TAG = RepositoryListFragment.class.getSimpleName();

  private RecyclerView repositoryRcyclerView;
  private RepositoryAdapter repositoryAdapter;
  private RepositoryManager repositoryManager;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View parentView = inflater.inflate(R.layout.fragment_all_repositories, container, false);
    initViews(parentView);

    initVariables();

    loadData();

    return parentView;
  }

  private void initVariables() {
    repositoryManager = new RepositoryManager();
  }

  //TODO move this logic out of fragment later
  void loadData() {

    Observable.just(new GetRepositoriesUiAction())
        .map(event -> new RepositorySearchAction("retrofit"))
        .compose(repositoryManager.repositories())
        .scan(RepositoryListUiResult.createIdle(Collections.emptyList()), (ignored, result) -> {
          switch (result.state()) {
            case RATE_LIMIT_ERROR:return RepositoryListUiResult.onError(new IllegalStateException("rate limited"));
            case IN_PROGRESS:     return RepositoryListUiResult.onInProgress();
            case SUCCESSFUL:      return RepositoryListUiResult.onSuccess(result.data());
            case FAILED:          return RepositoryListUiResult.onError(result.error());
            default:              throw new AssertionError("Unknown state:" + result.state());
          }
        })
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(updateUi(),handleFatalErrors());
  }

  private Consumer<? super Throwable> handleFatalErrors() {
    return throwable -> {
      Log.e(TAG, "handleFatalErrors: fatal error!", throwable);
    };
  }

  @NonNull private Consumer<RepositoryListUiResult> updateUi() {
    return result -> {
        switch (result.state()) {
          case IDLE:        updateWhenIdle(result); break;
          case IN_PROGRESS: updateWhenInProgress(result);break;
          case SUCCESSFUL:  updateWhenSuccessful(result); break;
          case FAILED:      updateWhenFailed(result); break;
          default:          throw new AssertionError("Unknown state:" + result.state());
        }
      };
  }

  private void updateWhenSuccessful(RepositoryListUiResult repositoryListUiResult) {
    Log.d(TAG, "loadData: successful");
    repositoryAdapter.updateRepositories(repositoryListUiResult.data());
  }

  private void updateWhenFailed(RepositoryListUiResult repositoryListUiResult) {
    Log.d(TAG, "loadData: got an error" + repositoryListUiResult.error());
  }

  private void updateWhenInProgress(RepositoryListUiResult result) {
    Log.d(TAG, "loadData: in progress");
  }

  private void updateWhenIdle(RepositoryListUiResult result) {
    Log.d(TAG, "loadData: idle");
  }

  private void initViews(View parentView) {
    repositoryRcyclerView =
        (RecyclerView) parentView.findViewById(R.id.all_repositories_rcyclrVw_id);
    repositoryRcyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    repositoryAdapter = new RepositoryAdapter(Collections.emptyList());
    repositoryRcyclerView.setAdapter(repositoryAdapter);
  }
}
