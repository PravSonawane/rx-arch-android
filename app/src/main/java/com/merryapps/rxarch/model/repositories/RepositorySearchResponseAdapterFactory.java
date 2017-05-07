package com.merryapps.rxarch.model.repositories;

import android.support.annotation.NonNull;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.reactivex.Observable;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
 */

class RepositorySearchResponseAdapterFactory extends CallAdapter.Factory {

  @Override
  public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
    if (getRawType(returnType) != Observable.class) {
      return null;
    }
    if (!(returnType instanceof ParameterizedType)) {
      throw new IllegalStateException(
          "Observable must have generic type (e.g., Observable<SearchResponse>)");
    }

    return newAdapter();
  }

  @NonNull
  private CallAdapter<SearchResponseRaw, Observable<SearchResponse>> newAdapter() {
    return new CallAdapter<SearchResponseRaw, Observable<SearchResponse>>() {
      @Override public Type responseType() {
        return SearchResponseRaw.class;
      }

      @Override public Observable<SearchResponse> adapt(
          Call<SearchResponseRaw> call) {
        return Observable.fromCallable(call::execute).map(response -> {
          if (response.isSuccessful()) {
            return new SearchResponse(response.body());
          } else {
            return new SearchResponse(
                createGson().fromJson(response.errorBody().string(), RateLimitErrorRaw.class));
          }
        });
      }
    };
  }

  @NonNull private Gson createGson() {
    return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();
  }

  private boolean isValidReturnType(Type returnType) {
    if (getRawType(returnType) != Observable.class) {
      return false;
    }
    if (!(returnType instanceof ParameterizedType)) {
      throw new IllegalStateException(
          "Observable must have generic type (e.g., Observable<SearchResponse>)");
    }
    return true;
  }
}