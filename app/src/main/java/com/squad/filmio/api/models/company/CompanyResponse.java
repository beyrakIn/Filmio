package com.squad.filmio.api.models.company;

import com.squad.filmio.api.models.company.Company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompanyResponse implements Serializable {
    private int page;
    List<Company> results = new ArrayList<>();
    private int total_pages;
    private int total_results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Company> getResults() {
        return results;
    }

    public void setResults(List<Company> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "page=" + page +
                ", results=" + results +
                ", total_pages=" + total_pages +
                ", total_results=" + total_results +
                '}';
    }
}
