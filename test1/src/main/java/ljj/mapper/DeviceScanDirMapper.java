package ljj.mapper;

import java.util.List;
import ljj.pojo.DeviceScanDir;
import ljj.pojo.DeviceScanDirExample;
import org.apache.ibatis.annotations.Param;

public interface DeviceScanDirMapper {
    int countByExample(DeviceScanDirExample example);

    int deleteByExample(DeviceScanDirExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeviceScanDir record);

    int insertSelective(DeviceScanDir record);

    List<DeviceScanDir> selectByExample(DeviceScanDirExample example);

    DeviceScanDir selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeviceScanDir record, @Param("example") DeviceScanDirExample example);

    int updateByExample(@Param("record") DeviceScanDir record, @Param("example") DeviceScanDirExample example);

    int updateByPrimaryKeySelective(DeviceScanDir record);

    int updateByPrimaryKey(DeviceScanDir record);
}