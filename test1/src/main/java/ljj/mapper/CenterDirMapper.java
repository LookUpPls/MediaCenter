package ljj.mapper;

import java.util.List;
import ljj.pojo.CenterDir;
import ljj.pojo.CenterDirExample;
import org.apache.ibatis.annotations.Param;

public interface CenterDirMapper {
    int countByExample(CenterDirExample example);

    int deleteByExample(CenterDirExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CenterDir record);

    int insertSelective(CenterDir record);

    List<CenterDir> selectByExample(CenterDirExample example);

    CenterDir selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CenterDir record, @Param("example") CenterDirExample example);

    int updateByExample(@Param("record") CenterDir record, @Param("example") CenterDirExample example);

    int updateByPrimaryKeySelective(CenterDir record);

    int updateByPrimaryKey(CenterDir record);
}