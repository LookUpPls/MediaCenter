package ljj.mapper;

import java.util.List;
import ljj.pojo.DeviceSaveDir;
import ljj.pojo.DeviceSaveDirExample;
import org.apache.ibatis.annotations.Param;

public interface DeviceSaveDirMapper {
    int countByExample(DeviceSaveDirExample example);

    int deleteByExample(DeviceSaveDirExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeviceSaveDir record);

    int insertSelective(DeviceSaveDir record);

    List<DeviceSaveDir> selectByExample(DeviceSaveDirExample example);

    DeviceSaveDir selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeviceSaveDir record, @Param("example") DeviceSaveDirExample example);

    int updateByExample(@Param("record") DeviceSaveDir record, @Param("example") DeviceSaveDirExample example);

    int updateByPrimaryKeySelective(DeviceSaveDir record);

    int updateByPrimaryKey(DeviceSaveDir record);
}