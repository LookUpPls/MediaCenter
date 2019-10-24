package ljj.pojo;

import java.util.Date;

public class Pictures {
    private Integer id;

    private String name;

    private String type;

    private String spacesize;

    private Integer fromdirid;

    private Integer saveddirid;

    private Date uploadtime;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSpacesize() {
        return spacesize;
    }

    public void setSpacesize(String spacesize) {
        this.spacesize = spacesize == null ? null : spacesize.trim();
    }

    public Integer getFromdirid() {
        return fromdirid;
    }

    public void setFromdirid(Integer fromdirid) {
        this.fromdirid = fromdirid;
    }

    public Integer getSaveddirid() {
        return saveddirid;
    }

    public void setSaveddirid(Integer saveddirid) {
        this.saveddirid = saveddirid;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}