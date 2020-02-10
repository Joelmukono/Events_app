
package com.joel.events;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventsSearchResponse implements Serializable
{

    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    private final static long serialVersionUID = -4707434165275256377L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public EventsSearchResponse() {
    }

    /**
     * 
     * @param pagination
     * @param categories
     * @param locale
     */
    public EventsSearchResponse(String locale, Pagination pagination, List<Category> categories) {
        super();
        this.locale = locale;
        this.pagination = pagination;
        this.categories = categories;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
