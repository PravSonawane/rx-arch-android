package com.merryapps.rxarch.ui.repositories;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.merryapps.rxarch.R;
import com.merryapps.rxarch.model.repositories.Repository;
import java.util.List;

/**
 * //TODO add description here
 *
 * @author Pravin Sonawane (june.pravin@gmail.com)
 * @since v1.0.0
 */

class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {

  private List<Repository> repositories;

  RepositoryAdapter(List<Repository> repositories) {
    this.repositories = repositories;
  }

  @Override public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repository, parent, false);
    return new RepositoryViewHolder(view);
  }

  @Override public void onBindViewHolder(RepositoryViewHolder holder, int position) {
    holder.nameTxtVw.setText(repositories.get(position).getName());
  }

  @Override public int getItemCount() {
    return repositories.size();
  }

  void updateRepositories(List<Repository> repositories) {
    this.repositories = repositories;
    notifyDataSetChanged();
  }

  class RepositoryViewHolder extends RecyclerView.ViewHolder {

    TextView nameTxtVw;

    RepositoryViewHolder(View itemView) {
      super(itemView);
      nameTxtVw = (TextView) itemView.findViewById(R.id.repository_name_txtVw_id);
    }
  }
}
