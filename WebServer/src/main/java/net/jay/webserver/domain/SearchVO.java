package net.jay.webserver.domain;

import org.springframework.data.annotation.Id;

import java.util.Arrays;

/**
 * Created by jay on 2017. 3. 30..
 */
public class SearchVO {
    @Id
    String search;
    Object[] data;

    public SearchVO(String search, Object[] data) {
        this.search = search;
        this.data = data;
    }

    @Override
    public String toString() {
        return "SearchVO{" +
                "search='" + search + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }
}
