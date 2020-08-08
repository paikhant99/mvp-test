
package com.paikhantko.mvptest.data.model.api;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Row {

    @SerializedName("active_cases")
    private String activeCases;

    @SerializedName("cases_per_mill_pop")
    private String casesPerMillPop;

    private String country;

    @SerializedName("country_abbreviation")
    private String countryAbbreviation;

    private String flag;

    @SerializedName("new_cases")
    private String newCases;

    @SerializedName("new_deaths")
    private String newDeaths;

    @SerializedName("serious_critical")
    private String seriousCritical;

    @SerializedName("total_cases")
    private String totalCases;

    @SerializedName("total_deaths")
    private String totalDeaths;

    @SerializedName("total_recovered")
    private String totalRecovered;

}
