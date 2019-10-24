package ljj.pojo;

import java.util.Date;

public class CenterDir {
    private Integer id;

    private String uri;

    private String name;

    private Integer filecount;

    private Integer spacesize;

    private Date lastmodifiedtime;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getFilecount() {
        return filecount;
    }

    public void setFilecount(Integer filecount) {
        this.filecount = filecount;
    }

    public Integer getSpacesize() {
        return spacesize;
    }

    public void setSpacesize(Integer spacesize) {
        this.spacesize = spacesize;
    }

    public Date getLastmodifiedtime() {
        return lastmodifiedtime;
    }

    public void setLastmodifiedtime(Date lastmodifiedtime) {
        this.lastmodifiedtime = lastmodifiedtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}