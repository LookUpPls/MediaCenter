package ljj.mapper;

import java.util.List;
import ljj.pojo.DeviceScanDirTreepath;
import ljj.pojo.DeviceScanDirTreepathExample;
import ljj.pojo.DeviceScanDirTreepathKey;
import org.apache.ibatis.annotations.Param;

public interface DeviceScanDirTreepathMapper {
    int countByExample(DeviceScanDirTreepathExample example);

    int deleteByExample(DeviceScanDirTreepathExample example);

    int deleteByPrimaryKey(DeviceScanDirTreepathKey key);

    int insert(DeviceScanDirTreepath record);

    int insertSelective(DeviceScanDirTreepath record);

    List<DeviceScanDirTreepath> selectByExample(DeviceScanDirTreepathExample example);

    DeviceScanDirTreepath selectByPrimaryKey(DeviceScanDirTreepathKey key);

    int updateByExampleSelective(@Param("record") DeviceScanDirTreepath record, @Param("example") DeviceScanDirTreepathExample example);

    int updateByExample(@Param("record") DeviceScanDirTreepath record, @Param("example") DeviceScanDirTreepathExample example);

    int updateByPrimaryKeySelective(DeviceScanDirTreepath record);

    int updateByPrimaryKey(DeviceScanDirTreepath record);
}