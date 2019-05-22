package com.gemall.library.bean;

import java.util.List;

/**
 * author : g-emall
 * time   : 2019/4/19
 * desc   : 分类列表
 */
public class CategoryListBean {

    /**
     * uid : 0aa90cc3-4ee2-46f3-b112-41b4c49e5017
     * id : 4
     * parentID : 0
     * name : 我分类名称04151
     * englishAlias : I am classifiedI am
     * status : 0
     * sort : 1
     * keyWords : 我是关键词
     * thumbnail : gemall_20190415134518_10426c7c-cb30-469a-9a3c-be5fdb1aa32a.jpg
     * isRecommend : null
     * sons : []
     */

    private String uid;
    private int id;
    private int parentID;
    private String name;
    private String englishAlias;
    private int status;
    private int sort;
    private String keyWords;
    private String thumbnail;
    private Object isRecommend;
    private List<CategoryListBean> sons;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishAlias() {
        return englishAlias;
    }

    public void setEnglishAlias(String englishAlias) {
        this.englishAlias = englishAlias;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Object getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Object isRecommend) {
        this.isRecommend = isRecommend;
    }

    public List<CategoryListBean> getSons() {
        return sons;
    }

    public void setSons(List<CategoryListBean> sons) {
        this.sons = sons;
    }
}
