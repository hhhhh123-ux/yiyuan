package com.gzq.yiyuan.page;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName PageHelp
 * @Description 分页查询实体
 * @Author 高志强 gaozhiqiang@643146450.com
 * @Date 2020年12月28日
 * @Version 1.0
 */


@Data
public class PageHelp<T> implements Serializable {
    private static final long serialVersionUID = 6103720062680505647L;
    private final long total;
    private final List<T> list;
    private int pageNum;
    private int pageSize;
    private int pages;
    T data;

    public PageHelp(PageInfo<T> pageInfo) {
        this.total = pageInfo.getTotal();
        this.list = pageInfo.getList();
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.pages = pageInfo.getPages();

    }

    public PageHelp(long total, List list){
        this.total=total;
        this.list=list;
    }
}
