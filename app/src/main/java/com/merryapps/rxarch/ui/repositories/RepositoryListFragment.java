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
import com.merryapps.rxarch.model.repositories.LoadAction;
import com.merryapps.rxarch.model.repositories.RepositoryListResult;
import com.merryapps.rxarch.model.repositories.RepositoryManager;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
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

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View parentView = inflater.inflate(R.layout.fragment_all_repositories, container, false);
    initViews(parentView);

    loadData();

    return parentView;
  }

  //TODO move this logic out of fragment later
  void loadData() {
    Observable<LoadEvent> loadEvent = Observable.just(new LoadEvent());

    ObservableTransformer<LoadAction, RepositoryListResult> results =
        new RepositoryManager().transformToResult();
    Observable<RepositoryListUiModel> uiModel = uiEventToUiModel(loadEvent, results);

    uiModel.subscribe(updateUi());
  }

  @NonNull private Consumer<RepositoryListUiModel> updateUi() {
    return repositoryListUiModel -> {
        switch (repositoryListUiModel.state()) {
          case IDLE: {
            Log.d(TAG, "loadData: idle");
            break;
          }
          case IN_PROGRESS: {
            Log.d(TAG, "loadData: in progress");
            break;
          }
          case SUCCESSFUL: {
            Log.d(TAG, "loadData: successful");
            repositoryAdapter.updateRepositories(repositoryListUiModel.data());
            break;
          }
          case FAILED: {
            Log.d(TAG, "loadData: got an error" + repositoryListUiModel.error());
            break;
          }
          default:
            throw new AssertionError("Unknown state:" + repositoryListUiModel.state());
        }
      };
  }

  private Observable<RepositoryListUiModel> uiEventToUiModel(Observable<LoadEvent> loadEvent,
      ObservableTransformer<LoadAction, RepositoryListResult> results) {
    return loadEvent.map(event -> new LoadAction()).compose(results)
        .scan(RepositoryListUiModel.createIdle(Collections.emptyList()), (ignored,result) -> {
          switch(result.state()) {
            case IN_PROGRESS: return RepositoryListUiModel.createInProgress();
            case SUCCESSFUL: return RepositoryListUiModel.createSuccessful(result.data());
            case FAILED: return RepositoryListUiModel.createError(result.error());
            default: throw new AssertionError("Unknown state:" + result.state());
          }
        })
        .observeOn(AndroidSchedulers.mainThread());
  }

  private void initViews(View parentView) {
    repositoryRcyclerView =
        (RecyclerView) parentView.findViewById(R.id.all_repositories_rcyclrVw_id);
    repositoryRcyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    repositoryAdapter = new RepositoryAdapter(Collections.emptyList());
    repositoryRcyclerView.setAdapter(repositoryAdapter);
  }
}
