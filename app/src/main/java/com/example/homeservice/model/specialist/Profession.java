
package com.example.homeservice.model.specialist;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Profession {

    @Expose
    private Long professionId;
    @Expose
    private String professionName;
    @Expose
    private String serviceIcon;
    @Expose
    private String slug;

    public Long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Long professionId) {
        this.professionId = professionId;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public String getServiceIcon() {
        return serviceIcon;
    }

    public void setServiceIcon(String serviceIcon) {
        this.serviceIcon = serviceIcon;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

}
