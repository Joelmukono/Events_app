
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
    private com.joel.events.Pagination pagination;
    @SerializedName("categories")
    @Expose
    private List<com.joel.events.Category> categories = null;
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
    public EventsSearchResponse(String locale, com.joel.events.Pagination pagination, List<com.joel.events.Category> categories) {
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

    public com.joel.events.Pagination getPagination() {
        return pagination;
    }

    public void setPagination(com.joel.events.Pagination pagination) {
        this.pagination = pagination;
    }

    public List<com.joel.events.Category> getCategories() {
        return categories;
    }

    public void setCategories(List<com.joel.events.Category> categories) {
        this.categories = categories;
    }

}
