package ljj.mapper;

import java.util.List;
import ljj.pojo.CenterDirTreepath;
import ljj.pojo.CenterDirTreepathExample;
import ljj.pojo.CenterDirTreepathKey;
import org.apache.ibatis.annotations.Param;

public interface CenterDirTreepathMapper {
    int countByExample(CenterDirTreepathExample example);

    int deleteByExample(CenterDirTreepathExample example);

    int deleteByPrimaryKey(CenterDirTreepathKey key);

    int insert(CenterDirTreepath record);

    int insertSelective(CenterDirTreepath record);

    List<CenterDirTreepath> selectByExample(CenterDirTreepathExample example);

    CenterDirTreepath selectByPrimaryKey(CenterDirTreepathKey key);

    int updateByExampleSelective(@Param("record") CenterDirTreepath record, @Param("example") CenterDirTreepathExample example);

    int updateByExample(@Param("record") CenterDirTreepath record, @Param("example") CenterDirTreepathExample example);

    int updateByPrimaryKeySelective(CenterDirTreepath record);

    int updateByPrimaryKey(CenterDirTreepath record);
}