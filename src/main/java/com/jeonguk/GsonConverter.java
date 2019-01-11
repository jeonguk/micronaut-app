package com.jeonguk;

import com.google.gson.*;
import io.reactivex.annotations.NonNull;

import javax.inject.Singleton;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

@Singleton
public class GsonConverter {
    public Gson gson = new GsonBuilder()
        .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .setPrettyPrinting()
        .create();

    private static final GsonConverter globalGson = new GsonConverter();

    public static GsonConverter get() {
        return globalGson;
    }

    public Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
        }
        return gson;
    }

    public <T> String toJson(@NonNull final T t) {
        return getGson().toJson(t);
    }

    public <T> JsonObject getAsJsonObject(@NonNull final T t) {
        return getGson().toJsonTree(t).getAsJsonObject();
    }

    public <T> T fromJson(@NonNull final String o, @NonNull Class<T> tClass) {
        return getGson().fromJson(o, tClass);
    }

    public <T> T fromJson(@NonNull final JsonElement o, @NonNull Class<T> tClass) {
        return getGson().fromJson(o, tClass);
    }

    public <E> ArrayList<E> listFromJson(@NonNull final String o, @NonNull final Type listType) {
        return getGson().fromJson(o, listType);
    }

    public <E> ArrayList<E> listFromJson(@NonNull final JsonElement o, @NonNull final Type listType) {
        return getGson().fromJson(o, listType);
    }

    public <E> ArrayList<E> listFromJson(@NonNull final String o, @NonNull final Class<E> eClass) {
        return getGson().fromJson(o, new ListType<>(eClass));
    }

    public <E> ArrayList<E> listFromJson(@NonNull final JsonElement o, @NonNull final Class<E> eClass) {
        return getGson().fromJson(o, new ListType<>(eClass));
    }

    private static class ListType<E> implements ParameterizedType {

        private Class<?> wrapped;

        private ListType(Class<E> wrapped) {
            this.wrapped = wrapped;
        }

        public Type[] getActualTypeArguments() {
            return new Type[]{wrapped};
        }

        public Type getRawType() {
            return ArrayList.class;
        }

        public Type getOwnerType() {
            return null;
        }
    }
}
