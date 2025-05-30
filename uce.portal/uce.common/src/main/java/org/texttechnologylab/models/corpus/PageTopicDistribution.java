package org.texttechnologylab.models.corpus;

import org.texttechnologylab.models.ModelBase;
import org.texttechnologylab.models.UIMAAnnotation;

import javax.persistence.*;

@Entity
@Table(name="pagetopicdistribution")
public class PageTopicDistribution extends TopicDistribution {
    @OneToOne()
    @JoinColumn(name="page_id", insertable = false, updatable = false)
    private Page page;

    @Column(name = "page_id")
    private Long pageId;

    @Column(name = "\"beginn\"")
    private Integer begin;
    @Column(name = "\"endd\"")
    private Integer end;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
